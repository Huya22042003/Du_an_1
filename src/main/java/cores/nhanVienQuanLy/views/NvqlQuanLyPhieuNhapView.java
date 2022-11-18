/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom;
import cores.nhanVienQuanLy.services.NvqlQuanLyPhieuNhapService;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlQuanLyPhieuNhapServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author QUOC HUY
 */
public class NvqlQuanLyPhieuNhapView extends javax.swing.JPanel {

    /**
     * Creates new form DemoCoSoView
     */
    private NvqlQuanLyPhieuNhapService phieuNhapService;

    private List<NvqlQuanLyPhieuNhapCustom> getListPhieuNhap;

    public NvqlQuanLyPhieuNhapView() {
        initComponents();
        phieuNhapService = new NvqlQuanLyPhieuNhapServiceImpl();
        getListPhieuNhap = new ArrayList<>();
        this.loadTable(getListPhieuNhap);
//        clearForm();
    }

    public List<NvqlQuanLyPhieuNhapCustom> listSearch(int rdo) {
        // nhập vào 
        String timKiem = this.txtSearchTheo.getText();
        List<NvqlQuanLyPhieuNhapCustom> listTimKiem = new ArrayList<>();

        // tìm kiếm theo tên mã vị trí
        getListPhieuNhap.forEach(el -> {
            String search = "";
            List<String> strings = new ArrayList<>();

            // truyền tham số
            switch (rdo) {
                case 0:
                    search = el.getId().toString();
                    break;
                case 1:
                    search = el.getNgayThanhToan().toString();
                    break;
                case 2:
                    search = el.getNgayTao().toString();
                    break;
                case 3:
                    search = el.getTenNcc();
                    break;
                case 4:
                    search = el.getTenNhanVien();
                    break;
            }
            // cắt phần tử rồi ném vào mảng String[] vd Hà Nội =>  H, à , , N, ộ, i => [
//                                                                                      "H",
//                                                                                       "Hà",
//                                                                                      "Hà ",
//                                                                                      "Hà N"
//                                                                                       ....,
//                                                                                      "Hà Nội"]
            for (int i = 0; i <= search.length(); i++) {
                String newMa = search.substring(0, i);
                strings.add(newMa);
            }
            // so sánh mảng vừa cắt với phần tử nhập vào
            for (String e : strings) {
                if (e.equalsIgnoreCase(timKiem)) {
                    listTimKiem.add(el);
                }
            }
        });

        return listTimKiem;
    }

    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTable(listSearch(0));
        } else if (rdoNgayNhap.isSelected()) {
            loadTable(listSearch(1));
        } else if (rdoNgayTao.isSelected()) {
            loadTable(listSearch(2));
        } else if (rdoNcc.isSelected()) {
            loadTable(listSearch(3));
        } else {
            loadTable(listSearch(4));
        }
    }


    public void clearForm() {
        this.txtSearchTheo.setText("");
        this.rdoMa.setSelected(true);
        getListPhieuNhap = phieuNhapService.getListPn();
        searchRadio();
    }

    public void loadTable(List<NvqlQuanLyPhieuNhapCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        dtm.setRowCount(0);
        for (NvqlQuanLyPhieuNhapCustom el : list) {
            
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getId(),
                el.getGhiChu(),
                el.getNgayThanhToan() == null ? "" :  new Date(el.getNgayThanhToan()),
                 new Date(el.getNgayTao()),
                el.getTenNcc(),
                el.getTenNhanVien()
            };
            dtm.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        uWPButton1 = new utilities.palette.UWPButton();
        btnThem = new utilities.palette.UWPButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new utilities.palette.TableDark_1();
        txtSearchTheo = new utilities.palette.TextField();
        rdoMa = new utilities.palette.RadioButtonCustom();
        rdoNgayNhap = new utilities.palette.RadioButtonCustom();
        rdoNcc = new utilities.palette.RadioButtonCustom();
        rdoNgayTao = new utilities.palette.RadioButtonCustom();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHienThi = new utilities.palette.UWPButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        uWPButton1.setText("Các chức năng khác thì thêm bên trên này ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Create.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu nhập", "Ghi chú", "Ngày nhận", "Ngày tạo", "Nhà cung cấp", "Nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        txtSearchTheo.setLabelText("Search");
        txtSearchTheo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTheoKeyReleased(evt);
            }
        });

        buttonGroup1.add(rdoMa);
        rdoMa.setText("Mã");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNgayNhap);
        rdoNgayNhap.setText("Ngày nhập");
        rdoNgayNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgayNhapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNcc);
        rdoNcc.setText("Nhà cung cấp");
        rdoNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNccActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNgayTao);
        rdoNgayTao.setText("Ngày tạo");
        rdoNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgayTaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân viên");
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh sách phiếu nhập");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnHienThi.setText("HIển thị");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(btnHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchTheoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTheoKeyReleased
        searchRadio();
    }//GEN-LAST:event_txtSearchTheoKeyReleased

    private void rdoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoMaActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        NvqlCreatePhieuNhapView create = new NvqlCreatePhieuNhapView();
        create.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int row = this.tblPhieuNhap.getSelectedRow();
        NvqlRUDPhieuNhapView rud = new NvqlRUDPhieuNhapView(phieuNhapService.findPhieuNhapById((UUID) tblPhieuNhap.getValueAt(row, 1)));
        rud.setVisible(true);
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void rdoNgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgayNhapActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoNgayNhapActionPerformed

    private void rdoNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNccActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoNccActionPerformed

    private void rdoNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgayTaoActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoNgayTaoActionPerformed

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnHienThi;
    private utilities.palette.UWPButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoNcc;
    private utilities.palette.RadioButtonCustom rdoNgayNhap;
    private utilities.palette.RadioButtonCustom rdoNgayTao;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tblPhieuNhap;
    private utilities.palette.TextField txtSearchTheo;
    private utilities.palette.UWPButton uWPButton1;
    // End of variables declaration//GEN-END:variables
}