/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.nhanVienVanDons.views;

import cores.nhanVienVanDons.customModels.NvvdXemThongTinCaNhanCustom;
import cores.nhanVienVanDons.services.NvvdXemThongTinCaNhanService;
import cores.nhanVienVanDons.services.serviceImpls.NvvdXemThongTinCaNhanServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilities.Converter;

/**
 *
 * @author window
 */
public class NvvdXemThongTinCaNhanForm extends javax.swing.JPanel {

    private List<NvvdXemThongTinCaNhanCustom> listNvvdXemThongTinCaNhanCustom = new ArrayList<>();
    private NvvdXemThongTinCaNhanService khXemThongTinCaNhanService = new NvvdXemThongTinCaNhanServiceImpl();

    public NvvdXemThongTinCaNhanForm() {
        initComponents();
        listNvvdXemThongTinCaNhanCustom = khXemThongTinCaNhanService.getAll();
        showData(listNvvdXemThongTinCaNhanCustom);
    }

    public void showData(List<NvvdXemThongTinCaNhanCustom> list) {
        for (NvvdXemThongTinCaNhanCustom kh : list) {
            txtMa.setText(kh.getMa());
            txtTen.setText(kh.getTen());
            txtGioiTinh.setText(Converter.trangThaiGioiTinh(kh.getGioiTinh()));
            txtDienThoai.setText(kh.getSdt());
            txtNgaySinh.setText(kh.getNgaySinh() + "");
            txtDiaChi.setText(kh.getDiaChi());
            txtVaiTro.setText("Nhan viên vận đơn");
        }
    }

    public NvvdXemThongTinCaNhanCustom checkPass() {
        String oldPass = txtOldPass.getText();
        String newPass = txtNewPass.getText();
        String cFPass = txtConfirmPass.getText();
        if (oldPass.isEmpty() || newPass.isEmpty() || cFPass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống trường nào");
            return null;
        }
        if (!khXemThongTinCaNhanService.checkMatKhau(oldPass)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ chưa chính xác");
            return null;
        }
        if (oldPass.equals(newPass)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ không được giống mật khẩu mới");
            return null;
        }
        if (!newPass.equals(cFPass)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận chưa đúng");
            return null;
        }

        NvvdXemThongTinCaNhanCustom kh = new NvvdXemThongTinCaNhanCustom();
        kh.setMatKhau(newPass);
        return kh;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialTabbed1 = new utilities.palette.MaterialTabbed();
        jPanel1 = new javax.swing.JPanel();
        txtNgaySinh = new utilities.palette.TextField();
        txtMa = new utilities.palette.TextField();
        txtDienThoai = new utilities.palette.TextField();
        txtVaiTro = new utilities.palette.TextField();
        txtDiaChi = new utilities.palette.TextField();
        txtGioiTinh = new utilities.palette.TextField();
        txtTen = new utilities.palette.TextField();
        jPanel2 = new javax.swing.JPanel();
        txtOldPass = new utilities.palette.PasswordField();
        txtConfirmPass = new utilities.palette.PasswordField();
        txtNewPass = new utilities.palette.PasswordField();
        btnHuyBo = new utilities.palette.UWPButton();
        btnXacNhan = new utilities.palette.UWPButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtNgaySinh.setLabelText("Ngày sinh: ");

        txtMa.setLabelText("Mã: ");

        txtDienThoai.setLabelText("Điện thoại: ");

        txtVaiTro.setLabelText("Vai trò: ");

        txtDiaChi.setLabelText("Địa chỉ: ");

        txtGioiTinh.setLabelText("Giới tính: ");

        txtTen.setLabelText("Tên: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Thông tin tài khoản", jPanel1);

        txtOldPass.setLabelText("Mật khẩu hiện tại: ");
        txtOldPass.setShowAndHide(true);

        txtConfirmPass.setLabelText("Xác nhân mật khẩu mới: ");
        txtConfirmPass.setShowAndHide(true);

        txtNewPass.setLabelText("Mật khẩu mới: ");
        txtNewPass.setShowAndHide(true);

        btnHuyBo.setText("HỦY BỎ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Đổi mật khẩu", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        txtConfirmPass.setText("");
        txtOldPass.setText("");
        txtNewPass.setText("");
    }//GEN-LAST:event_btnHuyBoActionPerformed

    public void clearForm() {
        txtOldPass.setText("");
        txtNewPass.setText("");
        txtConfirmPass.setText("");
    }
    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        NvvdXemThongTinCaNhanCustom kh = checkPass();
        if (kh == null) {
            return;
        }
        String oldPass = txtOldPass.getText();
        String newPass = txtNewPass.getText();

        khXemThongTinCaNhanService.doiMatKhau(txtNewPass.getText());
        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
        clearForm();
    }//GEN-LAST:event_btnXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnHuyBo;
    private utilities.palette.UWPButton btnXacNhan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private utilities.palette.MaterialTabbed materialTabbed1;
    private utilities.palette.PasswordField txtConfirmPass;
    private utilities.palette.TextField txtDiaChi;
    private utilities.palette.TextField txtDienThoai;
    private utilities.palette.TextField txtGioiTinh;
    private utilities.palette.TextField txtMa;
    private utilities.palette.PasswordField txtNewPass;
    private utilities.palette.TextField txtNgaySinh;
    private utilities.palette.PasswordField txtOldPass;
    private utilities.palette.TextField txtTen;
    private utilities.palette.TextField txtVaiTro;
    // End of variables declaration//GEN-END:variables
}
