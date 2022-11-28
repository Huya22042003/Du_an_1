package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TP_ChucVuCustom;
import cores.truongPhongs.services.TP_ChucVuService;
import cores.truongPhongs.services.serviceImpls.TP_ChucVuServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TP_ChucVuForm extends javax.swing.JPanel {

    private TP_ChucVuService chucVuService;
    private List<TP_ChucVuCustom> getList;
    private TP_RUDChucVuForm rud;
    private TP_CreateChucVuForm createChucVu;

    public TP_ChucVuForm() {
        chucVuService = new TP_ChucVuServiceImpl();
        getList = new ArrayList<>();
        rud = new TP_RUDChucVuForm();
        createChucVu = new TP_CreateChucVuForm();
        initComponents();
        getList = chucVuService.getListCV();
        
        loadTable(getList);
        clearForm();
    }

    public void clearForm() {
        rdoTen.setSelected(true);
        getList = chucVuService.findAllByRadio("", 0);
    }

    public List<TP_ChucVuCustom> listSearch(int rdo) {
        String timKiem = this.txtSearchTheo1.getText();
        getList = chucVuService.findAllByRadio(timKiem, rdo);
        return getList;

    }
    public void fillData(int index){
        TP_ChucVuCustom ql = getList.get(index);
        txtMaCV.setText(ql.getMa());
        txtTenCV.setText(ql.getTen());
    }

    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTable(listSearch(0));
        } else {
            loadTable(listSearch(1));
        }
    }

    public void loadTable(List<TP_ChucVuCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tableAll.getModel();
        dtm.setRowCount(0);
        for (TP_ChucVuCustom el : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getMa(),
                el.getTen()
            };
            dtm.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelRound4 = new utilities.palette.PanelRound();
        rdoTen1 = new utilities.palette.RadioButtonCustom();
        txtSearchTheo = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoMa1 = new utilities.palette.RadioButtonCustom();
        jPanel1 = new javax.swing.JPanel();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtTenCV = new utilities.palette.TextField();
        txtMaCV = new utilities.palette.TextField();
        myButton7 = new utilities.palette.MyButton();
        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAll = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        rdoTen = new utilities.palette.RadioButtonCustom();
        txtSearchTheo1 = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoMa = new utilities.palette.RadioButtonCustom();
        panelRound16 = new utilities.palette.PanelRound();
        btnSearch = new utilities.palette.MyButton();
        btnThem = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        panelRound15 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        rdoTen1.setBackground(new java.awt.Color(67, 130, 187));
        rdoTen1.setForeground(new java.awt.Color(255, 255, 255));
        rdoTen1.setText("Tên");
        rdoTen1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoMa1.setBackground(new java.awt.Color(67, 130, 187));
        rdoMa1.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa1.setText("Mã");
        rdoMa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(rdoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(rdoMa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin chức vụ");

        txtTenCV.setEditable(false);
        txtTenCV.setBackground(new java.awt.Color(228, 206, 224));
        txtTenCV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenCV.setLabelText("Tên Chức Vụ");

        txtMaCV.setBackground(new java.awt.Color(228, 206, 224));
        txtMaCV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaCV.setLabelText("Mã  ");

        myButton7.setBackground(new java.awt.Color(51, 204, 255));
        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        myButton7.setText("Clear");
        myButton7.setToolTipText("Clear");
        myButton7.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton7.setColor(new java.awt.Color(221, 242, 244));
        myButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton7.setRadius(50);
        myButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTenCV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                        .addComponent(txtMaCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tableAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAll);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        rdoTen.setBackground(new java.awt.Color(67, 130, 187));
        rdoTen.setForeground(new java.awt.Color(255, 255, 255));
        rdoTen.setText("Tên");
        rdoTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoMa.setBackground(new java.awt.Color(67, 130, 187));
        rdoMa.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa.setText("Mã");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txtSearchTheo1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTheo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound16.setBackground(new java.awt.Color(67, 130, 187));
        panelRound16.setRoundBottomLeft(50);
        panelRound16.setRoundBottomRight(50);
        panelRound16.setRoundTopLeft(50);
        panelRound16.setRoundTopRight(50);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm chức vụ");
        btnSearch.setBorderColor(new java.awt.Color(221, 242, 244));
        btnSearch.setColor(new java.awt.Color(221, 242, 244));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setRadius(50);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(221, 242, 244));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThem.setToolTipText("Thêm chức vụ mới");
        btnThem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem.setColor(new java.awt.Color(221, 242, 244));
        btnThem.setRadius(50);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Properties.png"))); // NOI18N
        btnHienThi.setToolTipText("Hiển thị");
        btnHienThi.setBorderColor(new java.awt.Color(221, 242, 244));
        btnHienThi.setColor(new java.awt.Color(221, 242, 244));
        btnHienThi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHienThi.setRadius(50);
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Danh sách chức vụ");

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllMouseClicked
        int row = this.tableAll.getSelectedRow();
        createChucVu.setVisible(false);
        
        rud.custom = chucVuService.findChucVuByMa(tableAll.getValueAt(row, 1).toString());
        fillData(row);
        rud.setVisible(true);
        rud.showData();
    }//GEN-LAST:event_tableAllMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchRadio();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        createChucVu.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        getList = chucVuService.getListCV();
        loadTable(getList);
        clearForm();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        txtMaCV.setText("");
        txtTenCV.setText("");
    }//GEN-LAST:event_myButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.MyButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoMa1;
    private utilities.palette.RadioButtonCustom rdoTen;
    private utilities.palette.RadioButtonCustom rdoTen1;
    private utilities.palette.TableDark_1 tableAll;
    private utilities.palette.TextField txtMaCV;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearchTheo;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearchTheo1;
    private utilities.palette.TextField txtTenCV;
    // End of variables declaration//GEN-END:variables
}
