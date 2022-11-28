package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.ChiTietPhieuHoanXuatCustom;
import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import cores.nhanVienQuanLy.services.Tai_LuongHoanXuatService;
import cores.nhanVienQuanLy.services.Tai_NvqlLuongPhieuXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_LuongHoanXuatServiceImpl;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_NvqlLuongPhieuXuatServiceImpl;
import domainModels.PhieuHoanXuat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.MsgBox;

public class Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView extends javax.swing.JFrame {

    private Tai_NvqlLuongPhieuXuatService luongService;
    private Tai_LuongHoanXuatService luongHXService;
    private List<ChiTietPhieuHoanXuatCustom> listCTPHX;
    public PhieuHoanXuat phieuHX;
//    public double tongTien;
    private String duongDan = getClass().getResource("/icons/file.png").getPath();

    public void setPhieuHX(PhieuHoanXuat phieuHX) {
        this.phieuHX = phieuHX;
    }

    public Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView() {
        initComponents();
        luongHXService = new Tai_LuongHoanXuatServiceImpl();
        luongService = new Tai_NvqlLuongPhieuXuatServiceImpl();
        listCTPHX = new ArrayList<>();
        loadTable(listCTPHX);

        clearForm();
    }

//    public double getTongTien() {
//        return tongTien;
//    }
    public void clearForm() {
        tblCTPhieuXuat.removeAll();
    }

    public void loadTable(List<ChiTietPhieuHoanXuatCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblCTPhieuXuat.getModel();
        dtm.setRowCount(0);
        for (ChiTietPhieuHoanXuatCustom ctphx : listCTPHX) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                ctphx.getIdPhieuHoanXuat().getId(),
                ctphx.getIdChiTietSp().getId(),
                ctphx.getIdChiTietSp().getSanPham().getTen(),
                ctphx.getSoLuong(),
                ctphx.getIdChiTietSp().getGiaBan(),
                ctphx.getIdChiTietSp().getNamBaoHanh()
            };
            dtm.addRow(rowData);
        }
//        System.out.println(tongTien);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTPhieuXuat = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        panelRound6 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        btnShow = new utilities.palette.MyButton();
        btnShow1 = new utilities.palette.MyButton();
        jPanel3 = new javax.swing.JPanel();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        txtIDSP = new utilities.palette.TextField();
        txtMaPhieu = new utilities.palette.TextField();
        txtGiaBan = new utilities.palette.TextField();
        txtNamBH = new utilities.palette.TextField();
        txtTenSP = new utilities.palette.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        tblCTPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Phiếu Hoàn", "Mã CT Sản Phẩm", "Tên Sản Phẩm", "Số lượng", "Giá Bán", "Năm Bảo Hành"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuXuatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTPhieuXuat);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        panelRound6.setBackground(new java.awt.Color(67, 130, 187));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh sách sản phẩm được hoàn");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound8.setBackground(new java.awt.Color(102, 255, 255));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnShow.setToolTipText("Hiện thị danh sách sản phẩm hoàn");
        btnShow.setBorderColor(new java.awt.Color(221, 242, 244));
        btnShow.setColor(new java.awt.Color(221, 242, 244));
        btnShow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow.setRadius(50);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit.png"))); // NOI18N
        btnShow1.setToolTipText("Exit\n");
        btnShow1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnShow1.setColor(new java.awt.Color(221, 242, 244));
        btnShow1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow1.setRadius(50);
        btnShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnShow1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Thông tin sản phẩm được hoàn");

        txtIDSP.setEditable(false);
        txtIDSP.setBackground(new java.awt.Color(228, 206, 224));
        txtIDSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIDSP.setLabelText("ID Sản phẩm");

        txtMaPhieu.setBackground(new java.awt.Color(228, 206, 224));
        txtMaPhieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaPhieu.setLabelText("Mã phiếu hoàn");
        txtMaPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuActionPerformed(evt);
            }
        });

        txtGiaBan.setEditable(false);
        txtGiaBan.setBackground(new java.awt.Color(228, 206, 224));
        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGiaBan.setLabelText("Giá Bán");

        txtNamBH.setEditable(false);
        txtNamBH.setBackground(new java.awt.Color(228, 206, 224));
        txtNamBH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNamBH.setLabelText("Năm Bảo Hành");
        txtNamBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamBHActionPerformed(evt);
            }
        });

        txtTenSP.setEditable(false);
        txtTenSP.setBackground(new java.awt.Color(228, 206, 224));
        txtTenSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenSP.setLabelText("Tên sản phẩm");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(409, 409, 409))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCTPhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuXuatMouseClicked
        int row = this.tblCTPhieuXuat.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaPhieu.setText(tblCTPhieuXuat.getValueAt(row, 1).toString());
        txtIDSP.setText(tblCTPhieuXuat.getValueAt(row, 2).toString());
        txtTenSP.setText(tblCTPhieuXuat.getValueAt(row, 3).toString());
        txtGiaBan.setText(tblCTPhieuXuat.getValueAt(row, 5).toString());
        txtNamBH.setText(tblCTPhieuXuat.getValueAt(row, 6).toString());

        String suaSL = JOptionPane.showInputDialog("Bạn muốn lấy lại bao nhiêu sản phẩm?");
        int sl = 0;
        try {
            sl = Integer.parseInt(suaSL);
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập lớn hơn 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập là kiểu số");
            return;
        }
        if (sl > listCTPHX.get(row).getSoLuong()) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập số lượng lấy về thấp hơn số lượng hoàn");
            return;
        }
        ChiTietPhieuHoanXuatCustom ctpHoanXuat = listCTPHX.get(row);

        for (LuongBanHang_ChiTietSanPhamCustom ctsp : luongService.getListCTSanPham()) {
            if (listCTPHX.get(row).getIdChiTietSp().getId().equals(ctsp.getId())) {
//                System.out.println((ctPhieuXuat.getSoLuong() - sl));
                ctsp.setSoLuongTon(ctsp.getSoLuongTon() - sl);
                luongService.updateCTSP(ctsp);
                System.out.println("đã update số lượng trong ctsp");
            }
        }
        System.out.println("đã update số lượng trong ctsp");
        for (Luong_ChiTietPhieuXuatCustom ctpx : luongService.getListCTPhieuXuat()) {
            if (listCTPHX.get(row).getIdChiTietSp().getId().equals(ctpx.getIdChiTietSp().getId())) {
                ctpx.setSoLuong(ctpx.getSoLuong() + sl);
                luongService.updateCTPX(ctpx);
                MsgBox.alert(this, "Đã Update lại số lượng trong phiếu xuất thành công!");
            }
        }
        ctpHoanXuat.setSoLuong(ctpHoanXuat.getSoLuong() - sl);
        luongHXService.updateCtPHX(ctpHoanXuat);
        listCTPHX.set(row, ctpHoanXuat);
        loadTable(listCTPHX);
//        ctPhieuXuat.setSoLuong(sl);
//        luongService.updateCTPX(ctPhieuXuat);
//        MsgBox.alert(this, "Hoàn số lượng thành công");
//
//        listCTPX.set(row, ctPhieuXuat);
//        loadTable(listCTPX);

    }//GEN-LAST:event_tblCTPhieuXuatMouseClicked


    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        listCTPHX = luongHXService.getListCTphxByID(this.phieuHX.getId());
        loadTable(listCTPHX);
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnShow1ActionPerformed

    private void txtMaPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void txtNamBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamBHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnShow;
    private utilities.palette.MyButton btnShow1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound6;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.TableDark_1 tblCTPhieuXuat;
    private utilities.palette.TextField txtGiaBan;
    private utilities.palette.TextField txtIDSP;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNamBH;
    private utilities.palette.TextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
