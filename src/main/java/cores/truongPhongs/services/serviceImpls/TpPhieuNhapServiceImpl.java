/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import cores.nhanVienQuanLy.repositories.NvqlGetTenNccRepository;
import cores.nhanVienQuanLy.repositories.NvqlGetTenNhanVienRepository;
import cores.truongPhongs.repositories.TpPhieuNhapRepository;
import domainModels.NhaCungCap;
import domainModels.NhanVien;
import domainModels.PhieuNhap;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.DateTimeUtil;
import cores.truongPhongs.services.TpPhieuNhapService;
import infrastructures.constant.TrangThaiPhieuNhapConstant;
import utilities.Auth;

/**
 *
 * @author Acer
 */
public class TpPhieuNhapServiceImpl implements TpPhieuNhapService {

    private TpPhieuNhapRepository repo;
    private NvqlGetTenNccRepository repoNcc;
    private NvqlGetTenNhanVienRepository repoNv;

    public TpPhieuNhapServiceImpl() {
        repo = new TpPhieuNhapRepository();
        repoNcc = new NvqlGetTenNccRepository();
        repoNv = new NvqlGetTenNhanVienRepository();
    }

    @Override
    public List<TpPhieuNhapCustom> getListPn() {
        return repo.getListPhieuNhap();
    }

    @Override
    public TpPhieuNhapCustom addPn(TpPhieuNhapCustom p) {
        p.setNgayTao(utilities.DateTimeUtil.convertDateToTimeStampSecond());
        p.setIdNhanVien(UUID.fromString("6e6bd9d9-e92b-7247-b2ee-f75d2f528127"));
        NhaCungCap ncc = repoNcc.getNccById(p.getIdNcc());
        NhanVien nv = repoNv.getNhanVienById(p.getIdNhanVien());
        PhieuNhap pn = new PhieuNhap();
        pn.setGhiChu(p.getGhiChu());
        pn.setNgayThanhToan(p.getNgayThanhToan());
        pn.setNgayTao(p.getNgayTao());
        pn.setNhaCungCap(ncc);
        pn.setNhanVien(nv);
        p.setTrangThai(TrangThaiPhieuConstant.CHO_THANH_TOAN);
        pn.setTrangThai(p.getTrangThai());
        p.setId(repo.addPn(pn).getId());
        return p;
    }

    @Override
    public boolean updatePn(TpPhieuNhapCustom p) {
        NhaCungCap ncc = repoNcc.getNccById(p.getIdNcc());
        NhanVien nv = repoNv.getNhanVienById(Auth.nhanVien.getId());
        PhieuNhap pn = new PhieuNhap();
        pn.setId(p.getId());
        pn.setTrangThai(p.getTrangThai());
        pn.setGhiChu(p.getGhiChu());
        pn.setNgayThanhToan(p.getNgayThanhToan());
        pn.setNgayTao(p.getNgayTao());
        pn.setNhaCungCap(ncc);
        pn.setNhanVien(nv);
        return repo.updatePn(pn);
    }

    @Override
    public boolean deletePn(UUID id) {
        return repo.deletePn(id);
    }

    @Override
    public TpPhieuNhapCustom checkValidate(String ghiChu, Date ngayThanhToan, JLabel errNgayThanhToan, JLabel errGhiChu) {

        TpPhieuNhapCustom pn = new TpPhieuNhapCustom();
        pn.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());

        return pn;

    }

    @Override
    public TpPhieuNhapCustom findPhieuNhapById(UUID id) {
        TpPhieuNhapCustom p = new TpPhieuNhapCustom();
        PhieuNhap pn = repo.findPhieuNhapById(id);
        p.setId(pn.getId());
        p.setTrangThai(pn.getTrangThai());
        p.setIdNcc(pn.getNhaCungCap().getId());
        p.setIdNhanVien(pn.getNhanVien().getId());
        p.setGhiChu(pn.getGhiChu());
        p.setNgayThanhToan(pn.getNgayThanhToan());
        p.setNgayTao(pn.getNgayTao());
        p.setTenNcc(pn.getNhaCungCap().getTen());
        p.setTenNhanVien(pn.getNhanVien().getTen());

        return p;
    }

    @Override
    public TrangThaiPhieuConstant loc(int a) {
        switch (a) {
            case 0:
                return TrangThaiPhieuConstant.CHO_THANH_TOAN;
            case 1:
                return TrangThaiPhieuConstant.DA_HUY;
            case 2:
                return TrangThaiPhieuConstant.DA_THANH_TOAN;
            default:
                return null;
        }
    }

    @Override
    public List<TpPhieuNhapCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        return repo.getListByNgayThanhToan(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<TpPhieuNhapCustom> getListByNgayTao(Long ngayTao, Long ngayKetThuc) {
        return repo.getListByNgayTao(ngayTao, ngayKetThuc);
    }

}
