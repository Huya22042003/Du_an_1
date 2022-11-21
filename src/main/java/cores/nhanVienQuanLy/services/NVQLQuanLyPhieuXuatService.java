/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import domainModels.KhachHang;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

/**
 *
 * @author admin
 */
public interface NVQLQuanLyPhieuXuatService {
    List<PhieuXuatCustom> getList();
    List<PhieuXuatCustom> getListByNgayTao(Long ngayTao, Long ngayKetThuc);
    PhieuXuatCustom addPhieuXuat(PhieuXuatCustom pncs);
    boolean updatePhieuXuat(PhieuXuatCustom pncs);
    boolean deletePhieuXuat(UUID id);
    PhieuXuatCustom findByID(UUID id);
    void loadComBox(Combobox cbbTT);
    void loadComBoBoxNV(Combobox cbbNV);
    void loadComBoBoxKh(Combobox cbbKH);
    TrangThaiPhieuConstant loc(int a);
    List<NhanVien> getListMaNhanVien();
    List<KhachHang> getListMaKhachHang();
    NhanVien chonNV(int chon);
    KhachHang chonKH(int chon);
    List<PhieuXuatCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc);
}