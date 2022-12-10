package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtpkCustom;
import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtpkService;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtspService;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlLuongKiemKeCtpkServiceImpl;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlLuongKiemKeCtspServiceImpl;
import infrastructures.constant.TrangThaiPhieuKiemConstant;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MsgBox;
import utilities.Page;

/**
 *
 * @author QUOC HUY
 */
public class NvqlKiemKeCtpkView extends javax.swing.JFrame {

    /**
     * Creates new form DemoRUDCoSoView
     */
    private List<NvqlLuongKiemKeCtspCustom> listChiTietSanPham = new ArrayList<>();
    private DecimalFormat formatter = new DecimalFormat("###,###,##0");
    private NvqlLuongKiemKeCtpkService ctpkService;
    public List<NvqlLuongKiemKeCtpkCustom> listCtpk;
    private NvqlLuongKiemKeCustom phieuKiemKe;
    public NvqlLuongKiemKeCtpkCustom ctpkk;
    private Page p;
    private NvqlLuongKiemKeCtspService ctspService;
    private int limit = 7;
    private int offset = 0;
    private int sizes = 0;
    private int index = 1;
    
    public void PhieuKiemKe(NvqlLuongKiemKeCustom phieuKiemKe) {
        this.phieuKiemKe = phieuKiemKe;
    }
    
    public NvqlKiemKeCtpkView() {
        p = new Page();
        initComponents();
        ctpkService = new NvqlLuongKiemKeCtpkServiceImpl();
        ctspService = new NvqlLuongKiemKeCtspServiceImpl();
        listCtpk = new ArrayList<>();
        ctpkk = new NvqlLuongKiemKeCtpkCustom();
        sizes = listCtpk.size();
        fillTablePhieuKiemChiTiet(ctpkService.phanTrang(listCtpk, offset, limit));
        
    }
    
    public void fillTablePhieuKiemChiTiet(List<NvqlLuongKiemKeCtpkCustom> list) {
        DefaultTableModel model = (DefaultTableModel) tbPhieuKiemChiTiet.getModel();
        model.setRowCount(0);
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                return;
            }
            
            NvqlLuongKiemKeCtpkCustom m = list.get(i);
            
            Object[] row = new Object[]{
                model.getRowCount() + 1,
                m.getMa(),
                m.getTen(),
                m.getSoLuongTon(),
                m.getSoLuongThucTon(),
                m.getChenhLech(),
                Converter.trangThaiSanPham(m.getIdChiTietSanPham().getTrangThai()),
                m.getLiDo()
            };
            model.addRow(row);
        }
        
    }
    
    private void clearForm() {
        sizes = listCtpk.size();
        offset = 0;
        index = 1;
        loadIndex();
    }
    
    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        test = new javax.swing.JLabel();
        erroMa = new javax.swing.JLabel();
        erroViTri = new javax.swing.JLabel();
        erroTen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhieuKiemChiTiet = new utilities.palette.TableDark_1();
        panelRound8 = new utilities.palette.PanelRound();
        btnShow = new utilities.palette.MyButton();
        btnShow1 = new utilities.palette.MyButton();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new utilities.palette.TextField();
        txtMaSp = new utilities.palette.TextField();
        txtSlTon = new utilities.palette.TextField();
        txtSlThuc = new utilities.palette.TextField();
        txtSlChenh = new utilities.palette.TextField();
        txtLiDo = new utilities.palette.TextField();
        btnAnh = new utilities.palette.UWPButton();
        btnPre = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        btnNext = new utilities.palette.UWPButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FPT_Polytechnic_doc.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(test, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        erroMa.setForeground(new java.awt.Color(255, 51, 51));

        erroViTri.setForeground(new java.awt.Color(255, 51, 51));

        erroTen.setForeground(new java.awt.Color(255, 51, 51));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh sách phiếu kiểm chi tiết");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbPhieuKiemChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng tồn", "Số lượng thực tồn", "Lệch", "Trạng thái SP", "Lí do"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPhieuKiemChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhieuKiemChiTietMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPhieuKiemChiTiet);

        panelRound8.setBackground(new java.awt.Color(102, 255, 255));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnShow.setToolTipText("Load lại table");
        btnShow.setBorderColor(new java.awt.Color(221, 242, 244));
        btnShow.setColor(new java.awt.Color(221, 242, 244));
        btnShow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow.setRadius(50);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        btnShow1.setToolTipText("Thoát");
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
                .addGap(41, 41, 41)
                .addComponent(btnShow1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnShow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Thông tin chi tiết");

        txtTen.setEditable(false);
        txtTen.setBackground(new java.awt.Color(228, 206, 224));
        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTen.setLabelText("Tên sản phẩm");

        txtMaSp.setBackground(new java.awt.Color(228, 206, 224));
        txtMaSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSp.setLabelText("Mã sản phẩm");

        txtSlTon.setEditable(false);
        txtSlTon.setBackground(new java.awt.Color(228, 206, 224));
        txtSlTon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSlTon.setLabelText("Số lượng tồn");

        txtSlThuc.setEditable(false);
        txtSlThuc.setBackground(new java.awt.Color(228, 206, 224));
        txtSlThuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSlThuc.setLabelText("Số lượng thực tồn");

        txtSlChenh.setBackground(new java.awt.Color(228, 206, 224));
        txtSlChenh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSlChenh.setLabelText("Số lượng chênh lệch");

        txtLiDo.setBackground(new java.awt.Color(228, 206, 224));
        txtLiDo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLiDo.setLabelText("Lí do");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSlTon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSlThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSlChenh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLiDo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSlTon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSlThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSlChenh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLiDo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        btnAnh.setBackground(new java.awt.Color(228, 206, 224));
        btnAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/d8566d8da1401a4114298a7726147ec8.jpg"))); // NOI18N

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-previous-circle-solid-24.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        txtIndex.setText("1/1");

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-next-circle-solid-24.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(303, 303, 303)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(erroMa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroViTri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(erroTen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(erroMa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(erroViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int xy, xx;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged
    
    public NvqlLuongKiemKeCtspCustom mouseClickSanPham(int row) {
        return listChiTietSanPham.get(row);
    }
    private void tbPhieuKiemChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuKiemChiTietMouseClicked
        int s = tbPhieuKiemChiTiet.getSelectedRow();
        txtMaSp.setText(tbPhieuKiemChiTiet.getValueAt(s, 1).toString());
        txtTen.setText(tbPhieuKiemChiTiet.getValueAt(s, 2).toString());
        txtSlTon.setText(tbPhieuKiemChiTiet.getValueAt(s, 3).toString());
        txtSlThuc.setText(tbPhieuKiemChiTiet.getValueAt(s, 4).toString());
        txtSlChenh.setText(tbPhieuKiemChiTiet.getValueAt(s, 5).toString());
        txtLiDo.setText(tbPhieuKiemChiTiet.getValueAt(s, 7).toString());
        
        if (phieuKiemKe.getTrangThai().equals(TrangThaiPhieuKiemConstant.DA_XAC_NHAN)) {
            MsgBox.alert(this, "Phiếu kiểm kê này đã ở trạng thái đã xác nhận nên không thể sửa số lượng! ");
            return;
        }
        String suaSL = JOptionPane.showInputDialog("bạn muốn sửa số lượng thực tồn là bao nhiêu?");
        if (suaSL == null) {
            return;
        }
        int sl = 0;
        try {
            sl = Integer.parseInt(suaSL);
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập số lượng lớn hơn 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập là kiểu số");
            return;
        }
        NvqlLuongKiemKeCtpkCustom ctPhieuKiem = listCtpk.get(s);
        ctpkService.updateSoLuongTon(ctPhieuKiem.getIdChiTietSanPham().getId(), sl);
        
        ctPhieuKiem.setSoLuongThucTon(sl);
        ctpkService.updateCTPKK(ctPhieuKiem);
        MsgBox.alert(this, "Update số lượng thực tồn thành công");
        listCtpk.set(s, ctPhieuKiem);
        fillTablePhieuKiemChiTiet(listCtpk);

    }//GEN-LAST:event_tbPhieuKiemChiTietMouseClicked

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        listCtpk = ctpkService.getAll(phieuKiemKe.getId());
        fillTablePhieuKiemChiTiet(listCtpk);
        clearForm();
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnShow1ActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        fillTablePhieuKiemChiTiet(ctpkService.phanTrang(listCtpk, offset, limit));
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        fillTablePhieuKiemChiTiet(ctpkService.phanTrang(listCtpk, offset, limit));
    }//GEN-LAST:event_btnNextActionPerformed
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NvqlKiemKeCtpkView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NvqlKiemKeCtpkView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NvqlKiemKeCtpkView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NvqlKiemKeCtpkView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NvqlKiemKeCtpkView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnAnh;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnShow;
    private utilities.palette.MyButton btnShow1;
    private javax.swing.JLabel erroMa;
    private javax.swing.JLabel erroTen;
    private javax.swing.JLabel erroViTri;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.TableDark_1 tbPhieuKiemChiTiet;
    private javax.swing.JLabel test;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtLiDo;
    private utilities.palette.TextField txtMaSp;
    private utilities.palette.TextField txtSlChenh;
    private utilities.palette.TextField txtSlThuc;
    private utilities.palette.TextField txtSlTon;
    private utilities.palette.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
