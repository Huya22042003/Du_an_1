package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpXemPhieuXuatCustom;
import cores.truongPhongs.customModels.TpXemSanPham_PhieuXuat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class TpXemPhieuXuatRepository {

    public List<TpXemPhieuXuatCustom> getListPhieuXuat(String maPhieu,
            String tenKh, String maKh, String diaChiKh, String emailKh, String sdtKh,
            String maSp, String tenSp,
            String maPn,
            String tenNcc, String maNcc, String diaChiNcc, String emailNcc, String sdtNcc, String maSpNcc
    ) {
        List<TpXemPhieuXuatCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createNativeQuery("""
                                            SELECT 
                                            px.Id,
                                            px.GhiChu,
                                            px.MaPhieu,
                                            px.NgayTao,
                                            px.NgayThanhToan,
                                            px.TrangThai,
                                            kh.Ma,
                                            kh.Ten,
                                            kh.Sdt,
                                            kh.Email,
                                            kh.MatKhau,
                                            kh.NgaySinh,
                                            kh.HinhAnh,
                                            kh.GioiTinh,
                                            kh.DiaChi,
                                            kh.DanhGia
                                            FROM PhieuXuat px 
                                            JOIN KhachHang kh ON px.IdKhachHang = kh.Id
                                            JOIN ChiTietPhieuXuat ctpx ON ctpx.IdPhieuXuat = px.Id
                                            JOIN ChiTietSanPham ctsp ON ctsp.Id = ctpx.IdChiTietSP
                                            JOIN SanPham sp ON sp.Id = ctsp.IdSanPham
                                            JOIN ChiTietPhieuNhap ctpn ON ctpn.IdChiTietSp = ctsp.Id
                                            JOIN PhieuNhap pn ON pn.Id = ctpn.IdPhieuNhap
                                            JOIN NhaCungCap ncc ON ncc.Id = pn.IdNhaCungCap
                                      WHERE px.MaPhieu LIKE CONCAT('%',:maPhieuXuat,'%')
                                       AND kh.Ma LIKE CONCAT('%',:maKh,'%')
                                      AND kh.Ten LIKE CONCAT('%',:tenKh,'%')
                                      AND kh.DiaChi LIKE CONCAT('%',:diaChiKh,'%')
                                      AND kh.Email LIKE CONCAT('%',:emailKh,'%')
                                      AND kh.Sdt LIKE CONCAT('%',:sdtKh,'%')
                                      AND sp.Ten LIKE CONCAT('%',:tenSp,'%')
                                      AND sp.Ma LIKE CONCAT('%',:maSp,'%')
                                      AND pn.MaPhieu LIKE CONCAT('%',:maPhieuNhap,'%')
                                      AND ncc.Ma LIKE CONCAT('%',:maNcc,'%')
                                      AND ncc.Ten LIKE CONCAT('%',:tenNcc,'%')
                                      AND ncc.DiaChi LIKE CONCAT('%',:diaChiNcc,'%')
                                      AND ncc.Email LIKE CONCAT('%',:emailNcc,'%')
                                      AND ctpn.MaSanPhamNhaCungCap LIKE CONCAT('%',:maSpNcc,'%')
                                      AND ncc.Sdt LIKE CONCAT('%',:sdtNcc,'%')
                                      """)
                .setParameter("maPhieuXuat", maPhieu)
                .setParameter("maKh", maKh)
                .setParameter("tenKh", tenKh)
                .setParameter("diaChiKh", diaChiKh)
                .setParameter("emailKh", emailKh)
                .setParameter("sdtKh", sdtKh)
                .setParameter("tenSp", tenSp)
                .setParameter("maSp", maSp)
                .setParameter("maPhieuNhap", maPn)
                .setParameter("maNcc", maNcc)
                .setParameter("tenNcc", tenNcc)
                .setParameter("diaChiNcc", diaChiNcc)
                .setParameter("emailNcc", emailNcc)
                .setParameter("maSpNcc", maPhieu)
                .setParameter("sdtNcc", sdtNcc);

        List<Object[]> listQuery = q.getResultList();
        listQuery.stream().forEach(el -> {
            UUID id = null;
            String ghiChu = "";
            String maPhieuXuat = "";
            Long ngayTao = 0L;
            Long ngayThanhToan = 0L;
            int trangThai = 0;
            String maKhachHang = "";
            String tenKhachHang = "";
            String sdtKhachHang = "";
            String email = "";
            String mkKhachHang = "";
            Long ngaySinh = 0L;
            String hinhAnh = "";
            int gioiTinh = 0;
            String diaChi = "";
            int danhGia = 0;

            if ("null".equalsIgnoreCase((String) el[0])) {
                id = null;
            } else {
                id = UUID.fromString((String) el[0]);
            }

            if ("null".equalsIgnoreCase((String) el[1])) {
                ghiChu = "Kh??ng c??";
            } else {
                ghiChu = (String) el[1];
            }

            if ("null".equalsIgnoreCase((String) el[2])) {
                maPhieuXuat = "Kh??ng c??";
            } else {
                maPhieuXuat = (String) el[2];
            }
            if (String.valueOf((BigDecimal) el[3]).equalsIgnoreCase("null")) {
                ngayTao = 0L;
            } else {
                ngayTao = Long.valueOf(String.valueOf((BigDecimal) el[3]));
            }
            if (String.valueOf((BigDecimal) el[4]).equalsIgnoreCase("null")) {
                ngayThanhToan = 0L;
            } else {
                ngayThanhToan = Long.valueOf(String.valueOf((BigDecimal) el[4]));
            }
            if ("null".equalsIgnoreCase(String.valueOf((Integer) el[5]))) {
                trangThai = 0;
            } else {
                trangThai = (int) el[5];
            }
            if ("null".equalsIgnoreCase((String) el[6])) {
                maKhachHang = "Kh??ng c??";
            } else {
                maKhachHang = (String) el[6];
            }
            if ("null".equalsIgnoreCase((String) el[7])) {
                tenKhachHang = "Kh??ng c??";
            } else {
                tenKhachHang = (String) el[7];
            }
            if ("null".equalsIgnoreCase((String) el[8])) {
                sdtKhachHang = "Kh??ng c??";
            } else {
                sdtKhachHang = (String) el[8];
            }
            if ("null".equalsIgnoreCase((String) el[9])) {
                email = "Kh??ng c??";
            } else {
                email = (String) el[9];
            }
            if ("null".equalsIgnoreCase((String) el[10])) {
                mkKhachHang = "Kh??ng c??";
            } else {
                mkKhachHang = (String) el[10];
            }
            if ("null".equalsIgnoreCase(String.valueOf((BigDecimal) el[11]))) {
                ngaySinh = 0L;
            } else {
                ngaySinh = Long.valueOf(String.valueOf((BigDecimal) el[11]));
            }
            if ("null".equalsIgnoreCase((String) el[12])) {
                hinhAnh = null;
            } else {
                hinhAnh = (String) el[12];
            }
            if ("null".equalsIgnoreCase(String.valueOf((Integer) el[13]))) {
                gioiTinh = 2;
            } else {
                gioiTinh = (int) el[13];
            }
            if ("null".equalsIgnoreCase((String) el[14])) {
                diaChi = "Kh??ng c??";
            } else {
                diaChi = (String) el[14];
            }
            if ("null".equalsIgnoreCase(String.valueOf((Integer) el[15]))) {
                danhGia = 0;
            } else {
                danhGia = (int) el[15];
            }

            list.add(new TpXemPhieuXuatCustom(id, ghiChu, maPhieuXuat, ngayTao, ngayThanhToan, trangThai,
                    maKhachHang, tenKhachHang, sdtKhachHang, email, mkKhachHang,
                    ngaySinh, hinhAnh, gioiTinh, diaChi, danhGia
            ));
        });
        return list;
    }

    public List<TpXemSanPham_PhieuXuat> getListSanPhamByPhieuXuat(UUID idPhieuXuat,
            String maSp, String tenSp,
            String maPn,
            String tenNcc, String maNcc, String diaChiNcc, String emailNcc, String sdtNcc, String maSpNcc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = s.createNativeQuery("""
                                                  SELECT 
                                                  sp.Id,
                                                  sp.Ma as maSp,
                                                  sp.Ten as tenSp,
                                                  ctpx.SoLuong,
                                                  ctsp.HinhAnh,
                                                  ctsp.GiaNhap,
                                                  ctsp.GiaBan,
                                                  ctsp.Mau,
                                                  ctsp.namBaoHanh,
                                                  ctsp.Size,
                                                  ctsp.createDate,
                                                  pn.MaPhieu,
                                                  pn.NgayTao,
                                                  pn.GhiChu,
                                                  pn.NgayThanhToan,
                                                  ncc.Ma as maNcc,
                                                  ncc.Ten as tenNcc,
                                                  ncc.DiaChi,
                                                  ncc.Email,
                                                  ncc.Sdt,
                                                  ctpn.MaSanPhamNhaCungCap
                                                  FROM SanPham sp join ChiTietSanPham ctsp ON sp.Id = ctsp.IdSanPham
                                                          join ChiTietPhieuXuat ctpx on ctpx.idChiTietSp = ctsp.id
                                                  		join ChiTietPhieuNhap ctpn on ctpn.IdChiTietSp = ctsp.id
                                                  		join PhieuNhap pn on pn.Id = ctpn.IdPhieuNhap
                                                  		join NhaCungCap ncc on ncc.Id = pn.IdNhaCungCap
                                                            WHERE ctpx.idPhieuXuat = :idPhieuXuat
                                                            AND sp.Ten LIKE CONCAT('%',:tenSp,'%')
                                                            AND sp.Ma LIKE CONCAT('%',:maSp,'%')
                                                            AND pn.MaPhieu LIKE CONCAT('%',:maPhieuNhap,'%')
                                                            AND ncc.Ma LIKE CONCAT('%',:maNcc,'%')
                                                            AND ncc.Ten LIKE CONCAT('%',:tenNcc,'%')
                                                            AND ncc.DiaChi LIKE CONCAT('%',:diaChiNcc,'%')
                                                            AND ncc.Email LIKE CONCAT('%',:emailNcc,'%')
                                                            AND ctpn.MaSanPhamNhaCungCap LIKE CONCAT('%',:maSpNcc,'%')
                                                            AND ncc.Sdt LIKE CONCAT('%',:sdtNcc,'%')
                                                  """)
                .setParameter("idPhieuXuat", idPhieuXuat.toString())
                .setParameter("tenSp", tenSp)
                .setParameter("maSp", maSp)
                .setParameter("maPhieuNhap", maPn)
                .setParameter("maNcc", maNcc)
                .setParameter("tenNcc", tenNcc)
                .setParameter("diaChiNcc", diaChiNcc)
                .setParameter("emailNcc", emailNcc)
                .setParameter("maSpNcc", maSpNcc)
                .setParameter("sdtNcc", sdtNcc);
        List<Object[]> listQuery = query.getResultList();
        List<TpXemSanPham_PhieuXuat> list = new ArrayList<>();
        listQuery.stream().forEach(el -> {
            UUID id = null;
            String maSp1 = "Kh??ng c??";
            String tenSp1 = "Kh??ng c??";
            int soLuongBan = 0;
            String hinhAnh = "";
            BigDecimal giaNhap = new BigDecimal("0");
            BigDecimal giaBan = new BigDecimal("0");
            int mau = 0;
            int namBaoHanh = 0;
            int size = 0;
            Long ngayNhap = 0L;
            String maPhieuNhap = "Kh??ng c??";
            Long ngayTao = 0L;
            String ghiChu = "Kh??ng c??";
            Long ngayThanhToan = 0L;
            String maNcc1 = "Kh??ng c??";
            String tenNcc1 = "Kh??ng c??";
            String diaChiNcc1 = "Kh??ng c??";
            String emailNcc1 = "Kh??ng c??";
            String sdtNcc1 = "Kh??ng c??";
            String maSpNcc1 = "Kh??ng c??";
            
            if(!"null".equalsIgnoreCase((String) el[0])) {
                id = UUID.fromString((String) el[0]);
            }
            if(!"null".equalsIgnoreCase((String) el[1])) {
                maSp1 = (String) el[1];
            }
            if(!"null".equalsIgnoreCase((String) el[2])) {
                tenSp1 = (String) el[2];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((int) el[3]))) {
                soLuongBan = (int) el[3];
            }
            if(!"null".equalsIgnoreCase((String) el[4])) {
                hinhAnh = (String) el[4];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((BigDecimal) el[5]))) {
                giaNhap = (BigDecimal) el[5];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((BigDecimal) el[6]))) {
                giaBan = (BigDecimal) el[6];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((int) el[7]))) {
                mau = (int) el[7];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((int) el[8]))) {
                namBaoHanh = (int) el[8];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((int) el[9]))) {
                size = (int) el[9];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((BigDecimal) el[10]))) {
                ngayNhap = Long.valueOf(String.valueOf((BigDecimal) el[10]));
            }
            if(!"null".equalsIgnoreCase((String) el[11])) {
                maPhieuNhap = (String) el[11];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((BigDecimal) el[12]))) {
                ngayTao = Long.valueOf(String.valueOf((BigDecimal) el[12]));
            }
            if(!"null".equalsIgnoreCase((String) el[13])) {
                ghiChu = (String) el[13];
            }
            if(!"null".equalsIgnoreCase(String.valueOf((BigDecimal) el[14]))) {
                ngayThanhToan = Long.valueOf(String.valueOf((BigDecimal) el[14]));
            }
            if(!"null".equalsIgnoreCase((String) el[15])) {
                maNcc1 = (String) el[15];
            }
            if(!"null".equalsIgnoreCase((String) el[16])) {
                tenNcc1 = (String) el[16];
            }
            if(!"null".equalsIgnoreCase((String) el[17])) {
                diaChiNcc1 = (String) el[17];
            }
            if(!"null".equalsIgnoreCase((String) el[18])) {
                emailNcc1 = (String) el[18];
            }
            if(!"null".equalsIgnoreCase((String) el[19])) {
                sdtNcc1 = (String) el[19];
            }
            if(!"null".equalsIgnoreCase((String) el[20])) {
                maSpNcc1 = (String) el[20];
            }
            
            
            list.add(new TpXemSanPham_PhieuXuat(id, maSp1, tenSp1, soLuongBan, hinhAnh, giaNhap, giaBan, mau, namBaoHanh, size, ngayNhap, maPhieuNhap, ngayTao, ghiChu, ngayThanhToan, maNcc1, tenNcc1, diaChiNcc1, emailNcc1, sdtNcc1, maSpNcc1));
        });
        return list;
    }
}
