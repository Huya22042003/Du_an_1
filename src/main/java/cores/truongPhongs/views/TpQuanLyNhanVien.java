/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TpNhanVienCustom;
import cores.truongPhongs.services.TpQuanLyNhanVienSevice;
import cores.truongPhongs.services.serviceImpls.TpQuanLyNhanVienServiceImpl;
import cores.truongPhongs.views.TpCreateQuanLyNhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.HibernateUtil;

/**
 *
 * @author LENOVO
 */
public class TpQuanLyNhanVien extends javax.swing.JPanel {

    private TpQuanLyNhanVienSevice nhanVienSevice;
    private List<TpNhanVienCustom> getList;
    private TpCreateQuanLyNhanVien create;
    private TpRUDQuanLyNhanVien rud;

    public TpQuanLyNhanVien() {
        nhanVienSevice = new TpQuanLyNhanVienServiceImpl();
        getList = new ArrayList<>();
        create = new TpCreateQuanLyNhanVien();
        rud = new TpRUDQuanLyNhanVien();
        initComponents();
        getList = nhanVienSevice.getListNhanVien();
        nhanVienSevice.loadComboboxTT(cbbTrangThai);
        loadTable(getList);
        clearForm();
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
        btnThem = new utilities.palette.UWPButton();
        btnHienThi = new utilities.palette.UWPButton();
        jPanel1 = new javax.swing.JPanel();
        lable1 = new utilities.palette.lable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNV = new utilities.palette.TableDark_1();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new utilities.palette.TextField();
        btnSearch = new utilities.palette.UWPButton();
        rdoTen = new utilities.palette.RadioButtonCustom();
        rdoMa = new utilities.palette.RadioButtonCustom();
        rdoDiaChi = new utilities.palette.RadioButtonCustom();
        cbbTrangThai = new utilities.palette.Combobox();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHienThi.setText("Hiển Thị");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        lable1.setForeground(new java.awt.Color(255, 255, 255));
        lable1.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Mã", "SĐT", "Email", "Mật Khẩu", "Ngày Sinh", "Hình Ảnh", "Giới Tính", "Địa Chỉ", "Trạng Thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblQLNVMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLNV);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        txtSearch.setLabelText("Search");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTen);
        rdoTen.setSelected(true);
        rdoTen.setText("Tên");

        buttonGroup1.add(rdoMa);
        rdoMa.setText("Mã");

        buttonGroup1.add(rdoDiaChi);
        rdoDiaChi.setText("Địa Chỉ");

        cbbTrangThai.setLabeText("Trạng Thái");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(rdoDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
  public void clearForm() {
        rdoTen.setSelected(true);
        cbbTrangThai.setSelectedIndex(0);
        getList = nhanVienSevice.findAllByRadio("", nhanVienSevice.loc(cbbTrangThai.getSelectedIndex()), 0);
    }

    public List<TpNhanVienCustom> listSearch(int rdo) {
        String timKiem = this.txtSearch.getText();
        getList = nhanVienSevice.findAllByRadio(timKiem, nhanVienSevice.loc(cbbTrangThai.getSelectedIndex()), rdo);
        return getList;
    }

    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTable(listSearch(0));
        } else if (rdoTen.isSelected()) {
            loadTable(listSearch(1));
        } else {
            loadTable(listSearch(2));
        }
    }

    public void loadTable(List<TpNhanVienCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblQLNV.getModel();
        dtm.setRowCount(0);
        for (TpNhanVienCustom nv : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                nv.getTen(),
                nv.getMa(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getMatKhau(),
                nv.getNgaySinh() == null ? "" : new Date(nv.getNgaySinh()),
                nv.getHinhAnh(),
                Converter.trangThaiGioiTinh(nv.getGioiTinh()),
                nv.getDiaChi(),
                Converter.trangThaiNhanVien(nv.getTrangThai())
            };
            dtm.addRow(rowData);
        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        create.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVMouseClicked

        int row = this.tblQLNV.getSelectedRow();
        create.setVisible(false);
        rud.custom = nhanVienSevice.finNhanVienByMa(tblQLNV.getValueAt(row, 2).toString());
        rud.setVisible(true);
        rud.showData();
    }//GEN-LAST:event_tblQLNVMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        searchRadio();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        getList = nhanVienSevice.getListNhanVien();
        loadTable(getList);
        clearForm();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void tblQLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblQLNVMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnHienThi;
    private utilities.palette.UWPButton btnSearch;
    private utilities.palette.UWPButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.lable lable1;
    private utilities.palette.RadioButtonCustom rdoDiaChi;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoTen;
    private utilities.palette.TableDark_1 tblQLNV;
    private utilities.palette.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}