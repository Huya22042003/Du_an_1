package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtpkCustom;
import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtpkService;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtspService;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeService;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlLuongKiemKeCtpkServiceImpl;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlLuongKiemKeCtspServiceImpl;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlLuongKiemKeServiceImpl;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiPhieuKiemConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Auth;
import utilities.Converter;
import utilities.MaTuSinh;
import utilities.MsgBox;
import utilities.Page;
import utilities.palette.SearchCustom.EventCallBack;
import utilities.palette.SearchCustom.EventTextField;

/**
 *
 * @author window
 */
public class NvqlKiemKeView extends javax.swing.JPanel {

    /**
     * Creates new form NvqlKiemKeView
     */
    private NvqlLuongKiemKeService kiemKeService;
    private NvqlLuongKiemKeCtpkService ctpkService;
    private List<NvqlLuongKiemKeCustom> listPhieuKiemKeCustom;
    private NhanVien nhanVien;
    private NvqlKiemKeCtpkView ctpkView;
    private NvqlKiemKeCtspView ctspView;
    private List<NvqlLuongKiemKeCtpkCustom> listCtpkCustom = new ArrayList<>();
    private NvqlLuongKiemKeCtspService ctspService;
    private Page p;
    private NvqlLuongKiemKeCtspCustom ctspct;

    public void SanPham(NvqlLuongKiemKeCtspCustom ctspct) {
        this.ctspct = ctspct;
    }

    private int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    String pattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public NvqlKiemKeView() {

        initComponents();
        kiemKeService = new NvqlLuongKiemKeServiceImpl();
        ctpkService = new NvqlLuongKiemKeCtpkServiceImpl();
        ctspService = new NvqlLuongKiemKeCtspServiceImpl();
        p = new Page();

        ctpkView = new NvqlKiemKeCtpkView();
        ctspView = new NvqlKiemKeCtspView();
        listPhieuKiemKeCustom = kiemKeService.getAll();

        nhanVien = new NhanVien();
        nhanVien.setId(Auth.nhanVien.getId());
        nhanVien.setMa(Auth.nhanVien.getMa());
        nhanVien.setEmail(Auth.nhanVien.getEmail());
        nhanVien.setDiaChi(Auth.nhanVien.getDiaChi());
        nhanVien.setGioiTinh(Auth.nhanVien.getGioiTinh());
        nhanVien.setHinhAnh(Auth.nhanVien.getHinhAnh());
        nhanVien.setIdChucVu(Auth.nhanVien.getChucVu());
        nhanVien.setMatKhau(Auth.nhanVien.getMatKhau());
        nhanVien.setNgaySinh(Auth.nhanVien.getNgaySinh());
        nhanVien.setSdt(Auth.nhanVien.getSdt());
        nhanVien.setTen(Auth.nhanVien.getTen());
        nhanVien.setTrangThai(Auth.nhanVien.getTrangThai());
        rdoMa.setSelected(true);
        cbbTrangThai.setSelectedIndex(0);
        sizes = listPhieuKiemKeCustom.size();
        loadIndex();
        fillTablePhieuKiemKe(kiemKeService.phanTrang(listPhieuKiemKeCustom, offset, limit));
        txtSearch.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                try {
                    for (int i = 1; i <= 100; i++) {

                        Thread.sleep(5);
                    }
                    call.done();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });

    }

//    public List<NvqlLuongKiemKeCustom> listSearch(int rdo) {
//        // nh???p v??o 
//        String timKiem = this.txtSearch.getText();
//        List<NvqlLuongKiemKeCustom> listTimKiem = new ArrayList<>();
//
//        // t??m ki???m theo t??n m?? v??? tr??
//        checkCbb(kiemKeService.loc(this.cbbTrangThai.getSelectedIndex())).forEach(el -> {
//            String search = "";
//            List<String> strings = new ArrayList<>();
//
//            // truy???n tham s???
//            switch (rdo) {
//                case 0:
//                    search = el.getId().toString();
//                    break;
//
//                case 1:
//                    search = el.getIdNV().getTen();
//                    break;
//
//            }
//            for (int i = 0; i <= search.length(); i++) {
//                String newMa = search.substring(0, i);
//                strings.add(newMa);
//            }
//            // so s??nh m???ng v???a c???t v???i ph???n t??? nh???p v??o
//            for (String e : strings) {
//                if (e.equalsIgnoreCase(timKiem)) {
//                    listTimKiem.add(el);
//                }
//            }
//        });
//
//        return listTimKiem;
//    }
//
//    public List<NvqlLuongKiemKeCustom> checkCbb(TrangThaiPhieuKiemConstant cs) {
//        List<NvqlLuongKiemKeCustom> listTimKiem = new ArrayList<>();
//        listPhieuKiemKeCustom.forEach(el -> {
//            if (el.getTrangThai() == cs) {
//                listTimKiem.add(el);
//            }
//        });
//        return listTimKiem;
//    }
//
//    public void searchRadio() {
//        if (rdoMa.isSelected()) {
//            fillTablePhieuKiemKe(listSearch(0));
//        }
//        if (rdoNhanVien.isSelected()) {
//            fillTablePhieuKiemKe(listSearch(1));
//        }
//    }
    public List<NvqlLuongKiemKeCustom> TimKiemTheoNgay() {
        if (ngayBatDau.getDate() == null) {

            return null;
        }
        if (ngayKetThuc.getDate() == null) {

            return null;
        }

        return listPhieuKiemKeCustom = kiemKeService.getListByNgayTao(ngayBatDau.getDate().getTime(), ngayKetThuc.getDate().getTime());

    }

    public void fillTablePhieuKiemKe(List<NvqlLuongKiemKeCustom> list) {
        DefaultTableModel model = (DefaultTableModel) tbPhieuKiemKe.getModel();
        model.setRowCount(0);

        list.forEach((m) -> {
            Date ngayTao = new Date(m.getNgayTao());
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                m.getMaPhieuKiem(),
                simpleDateFormat.format(ngayTao),
                m.getIdNV().getTen(),
                Converter.TrangThaiPhieuKiem(m.getTrangThai()),
                m.getGhiChu() == null ? "Nothing" : m.getGhiChu()
            });

        });

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
        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuKiemKe = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        rdoMa = new utilities.palette.RadioButtonCustom();
        txtSearch = new utilities.palette.SearchCustom.TextFieldAnimation();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        cbbTrangThai = new utilities.palette.Combobox();
        panelRound15 = new utilities.palette.PanelRound();
        btnChiTietPhieuKiem = new utilities.palette.MyButton();
        btnTaoPhieu = new utilities.palette.MyButton();
        btnThemSPKiem = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        panelRound9 = new utilities.palette.PanelRound();
        rdoNgayTao = new utilities.palette.RadioButtonCustom();
        ngayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ngayKetThuc = new com.toedter.calendar.JDateChooser();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtNgayTao = new utilities.palette.TextField();
        txtMaPhieuKiem = new utilities.palette.TextField();
        textAreaScroll1 = new utilities.palette.TextAreaScroll();
        txtGhiChu = new utilities.palette.TextAreaCustom();
        btnXacNhan = new utilities.palette.MyButton();
        txtTenNhanVien = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        btnPre = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        btnNext = new utilities.palette.UWPButton();

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tbPhieuKiemKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? phi???u ki???m", "Ng??y t???o", "T??n nh??n vi??n", "Tr???ng th??i", "L?? do"
            }
        ));
        tbPhieuKiemKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhieuKiemKeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhieuKiemKe);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        rdoNhanVien.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setText("Nh??n vi??n");
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        rdoMa.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoMa);
        rdoMa.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa.setText("M??");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaActionPerformed(evt);
            }
        });

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANH S??CH PHI???U KI???M K??");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound8.setBackground(new java.awt.Color(67, 130, 187));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        cbbTrangThai.setBackground(new java.awt.Color(67, 130, 187));
        cbbTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M???i t???o", "Ch??a x??c nh???n", "???? x??c nh???n" }));
        cbbTrangThai.setSelectedIndex(-1);
        cbbTrangThai.setToolTipText("Ch???n tr???ng th??i ????? t??m ki???m");
        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbTrangThai.setLabeText("Tr???ng th??i");
        cbbTrangThai.setLineColor(new java.awt.Color(145, 200, 249));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        btnChiTietPhieuKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnChiTietPhieuKiem.setToolTipText("Phi???u ki???m chi ti???t");
        btnChiTietPhieuKiem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChiTietPhieuKiem.setColor(new java.awt.Color(221, 242, 244));
        btnChiTietPhieuKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChiTietPhieuKiem.setRadius(50);
        btnChiTietPhieuKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPhieuKiemActionPerformed(evt);
            }
        });

        btnTaoPhieu.setBackground(new java.awt.Color(221, 242, 244));
        btnTaoPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnTaoPhieu.setToolTipText("T???o phi???u nh???p");
        btnTaoPhieu.setBorderColor(new java.awt.Color(221, 242, 244));
        btnTaoPhieu.setColor(new java.awt.Color(221, 242, 244));
        btnTaoPhieu.setRadius(50);
        btnTaoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuActionPerformed(evt);
            }
        });

        btnThemSPKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-to-basket.png"))); // NOI18N
        btnThemSPKiem.setToolTipText("Th??m s???n ph???m mu???n ki???m k??");
        btnThemSPKiem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThemSPKiem.setColor(new java.awt.Color(221, 242, 244));
        btnThemSPKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSPKiem.setRadius(50);
        btnThemSPKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPKiemActionPerformed(evt);
            }
        });

        btnHienThi.setBackground(new java.awt.Color(255, 255, 102));
        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnHienThi.setText("\n");
        btnHienThi.setToolTipText("Load l???i table");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnTaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTietPhieuKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemSPKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound15Layout.createSequentialGroup()
                        .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnTaoPhieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTietPhieuKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSPKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound9.setBackground(new java.awt.Color(67, 130, 187));
        panelRound9.setRoundBottomLeft(50);
        panelRound9.setRoundBottomRight(50);
        panelRound9.setRoundTopLeft(50);
        panelRound9.setRoundTopRight(50);

        rdoNgayTao.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoNgayTao);
        rdoNgayTao.setForeground(new java.awt.Color(255, 255, 255));
        rdoNgayTao.setText("Ng??y T???o");
        rdoNgayTao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgayTaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("From:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("To:");

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ngayBatDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ngayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Th??ng tin phi???u");

        txtNgayTao.setEditable(false);
        txtNgayTao.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTao.setLabelText("Ng??y t???o");

        txtMaPhieuKiem.setBackground(new java.awt.Color(228, 206, 224));
        txtMaPhieuKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaPhieuKiem.setLabelText("M?? phi???u ki???m");

        textAreaScroll1.setBackground(new java.awt.Color(153, 204, 255));
        textAreaScroll1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textAreaScroll1.setLabelText("L?? do");

        txtGhiChu.setBackground(new java.awt.Color(228, 206, 224));
        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.setDisabledTextColor(new java.awt.Color(204, 204, 255));
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textAreaScroll1.setViewportView(txtGhiChu);

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/credit-card.png"))); // NOI18N
        btnXacNhan.setText("X??C NH???N");
        btnXacNhan.setToolTipText("THANH TO??N");
        btnXacNhan.setBorderColor(new java.awt.Color(221, 242, 244));
        btnXacNhan.setColor(new java.awt.Color(221, 242, 244));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.setRadius(50);
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        txtTenNhanVien.setEditable(false);
        txtTenNhanVien.setBackground(new java.awt.Color(228, 206, 224));
        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenNhanVien.setLabelText("Nh??n vi??n");

        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTrangThai.setLabelText("Tr???ng th??i");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtMaPhieuKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaPhieuKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(286, 286, 286)))
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietPhieuKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPhieuKiemActionPerformed
        if (chon() == null) {
            return;
        }
        int s = tbPhieuKiemKe.getSelectedRow();
        if (s == -1) {
            JOptionPane.showMessageDialog(this, "B???n c???n ch???n 1 phi???u ki???m");
            return;
        }
        ctpkView.PhieuKiemKe(chon());
        ctpkView.setVisible(true);
    }//GEN-LAST:event_btnChiTietPhieuKiemActionPerformed

    public NvqlLuongKiemKeCustom getFormData() {
        NvqlLuongKiemKeCustom pnct = new NvqlLuongKiemKeCustom();
        pnct.setNgayTao(new Date().getTime());
        pnct.setTrangThai(TrangThaiPhieuKiemConstant.MOI_TAO);
        pnct.setIdNV(nhanVien);
        pnct.setMaPhieuKiem(MaTuSinh.gen("PKK"));
        return pnct;
    }
    private void btnTaoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuActionPerformed
        NvqlLuongKiemKeCustom phieuKiemKe1 = getFormData();
        kiemKeService.Insert(phieuKiemKe1);
        listPhieuKiemKeCustom = kiemKeService.getAll();
        fillTablePhieuKiemKe(kiemKeService.phanTrang(listPhieuKiemKeCustom, offset, limit));
    }//GEN-LAST:event_btnTaoPhieuActionPerformed

    private void btnThemSPKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPKiemActionPerformed
        if (chon() == null) {
            return;
        }
        int s = tbPhieuKiemKe.getSelectedRow();
        if (s == -1) {
            JOptionPane.showMessageDialog(this, "B???n c???n ch???n 1 phi???u ki???m");
            return;
        }
        if (tbPhieuKiemKe.getValueAt(s, 4).toString().equals("???? x??c nh???n")) {
            JOptionPane.showMessageDialog(this, "B???n ph???i ch???n m???t phi???u ki???m ch??a x??c nh???n!");
            return;
        }
        NvqlKiemKeCtspView create = new NvqlKiemKeCtspView();
        create.PhieuKiemKe(chon());
        create.setVisible(true);
    }//GEN-LAST:event_btnThemSPKiemActionPerformed

    public NvqlLuongKiemKeCustom chon() {
        int row = tbPhieuKiemKe.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "B???n ph???i ch???n 1 phi???u ki???m");
            return null;
        }
        NvqlLuongKiemKeCustom kk = new NvqlLuongKiemKeCustom();
        kk.setId(listPhieuKiemKeCustom.get(row).getId());
        kk.setIdNV(nhanVien);
        kk.setMaPhieuKiem(listPhieuKiemKeCustom.get(row).getMaPhieuKiem());
        kk.setNgayTao(listPhieuKiemKeCustom.get(row).getNgayTao());
        kk.setTrangThai(listPhieuKiemKeCustom.get(row).getTrangThai());
        return kk;
    }

    public NvqlLuongKiemKeCustom mouseClickPhieuKiem(int row) {
        return listPhieuKiemKeCustom.get(row);
    }
    private void tbPhieuKiemKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuKiemKeMouseClicked
        int s = tbPhieuKiemKe.getSelectedRow();
        String ngayTao = tbPhieuKiemKe.getValueAt(s, 2).toString();
        txtMaPhieuKiem.setText(tbPhieuKiemKe.getValueAt(s, 1).toString());
        txtNgayTao.setText(ngayTao);
        txtTenNhanVien.setText(tbPhieuKiemKe.getValueAt(s, 3).toString());
        txtTrangThai.setText(tbPhieuKiemKe.getValueAt(s, 4).toString());
        txtGhiChu.setText(tbPhieuKiemKe.getValueAt(s, 5).toString());
        NvqlLuongKiemKeCustom kiemKeCustom = mouseClickPhieuKiem(s);
        List<NvqlLuongKiemKeCtpkCustom> listCtpk = ctpkService.getAll(listPhieuKiemKeCustom.get(s).getId());

    }//GEN-LAST:event_tbPhieuKiemKeMouseClicked

    private void rdoNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNgayTaoActionPerformed

    public void hienThi() {
        listPhieuKiemKeCustom = kiemKeService.getAll();
        sizes = listPhieuKiemKeCustom.size();
        fillTablePhieuKiemKe(kiemKeService.phanTrang(listPhieuKiemKeCustom, offset, limit));
    }
    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        hienThi();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int row = tbPhieuKiemKe.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "B???n ph???i ch???n 1 phi???u ki???m k??");
            return;
        }
        listCtpkCustom = ctpkService.getAll(listPhieuKiemKeCustom.get(row).getId());
        if (listCtpkCustom.size() == 0) {
            MsgBox.alert(this, "B???n ph???i th??m s???n ph???m tr?????c khi x??c nh???n");
            return;
        }
        if (txtGhiChu.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "L?? do b???t bu???c ph???i c??!!");
            return;
        }
        if (listPhieuKiemKeCustom.get(row).getTrangThai() == TrangThaiPhieuKiemConstant.DA_XAC_NHAN) {
            MsgBox.alert(this, "Phi???u ki???m k?? ???? ho??n t???t. Vui l??ng m???i b???n thanh to??n phi???u xu???t kh??c");
            return;
        }
        NvqlLuongKiemKeCustom a = listPhieuKiemKeCustom.get(row);
        a.setTrangThai(TrangThaiPhieuKiemConstant.DA_XAC_NHAN);
        a.setGhiChu(txtGhiChu.getText());
        kiemKeService.UpdateTrangThai(a);
        listPhieuKiemKeCustom.set(row, a);
        hienThi();
        MsgBox.alert(this, "Ho??n t???t ki???m k??, b???ng ki???m k?? s??? ???????c g???i t???i c???p tr??n");
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        // TODO add your handling code here:
        searchhRadio();

    }//GEN-LAST:event_cbbTrangThaiActionPerformed
    public List<NvqlLuongKiemKeCustom> getListByTT(int rdo) {
        String timKiem = this.txtSearch.getText();
        listPhieuKiemKeCustom = kiemKeService.findAllByKhAndNV(timKiem, kiemKeService.loc(cbbTrangThai.getSelectedIndex()), rdo);
        return listPhieuKiemKeCustom;
    }

    public void searchhRadio() {
        if (rdoMa.isSelected()) {
            fillTablePhieuKiemKe(kiemKeService.phanTrang(getListByTT(0), offset, limit));
        }
        if (rdoNhanVien.isSelected()) {
            fillTablePhieuKiemKe(kiemKeService.phanTrang(getListByTT(1), offset, limit));
        }
        if (rdoNgayTao.isSelected()) {
            fillTablePhieuKiemKe(kiemKeService.phanTrang(TimKiemTheoNgay(), offset, limit));

        }
    }
    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
        searchhRadio();

    }//GEN-LAST:event_txtSearchMouseClicked

    private void rdoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaActionPerformed
        // TODO add your handling code here:
        searchhRadio();
    }//GEN-LAST:event_rdoMaActionPerformed

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        // TODO add your handling code here:
        searchhRadio();
    }//GEN-LAST:event_rdoNhanVienActionPerformed
    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }
    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        //        loadTable(getList);
        fillTablePhieuKiemKe(kiemKeService.phanTrang(listPhieuKiemKeCustom, offset, limit));
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        fillTablePhieuKiemKe(kiemKeService.phanTrang(listPhieuKiemKeCustom, offset, limit));
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnChiTietPhieuKiem;
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnTaoPhieu;
    private utilities.palette.MyButton btnThemSPKiem;
    private utilities.palette.MyButton btnXacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser ngayBatDau;
    private com.toedter.calendar.JDateChooser ngayKetThuc;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.PanelRound panelRound9;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoNgayTao;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tbPhieuKiemKe;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtMaPhieuKiem;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearch;
    private utilities.palette.TextField txtTenNhanVien;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
