/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import cores.nhanVienQuanLy.repositories.NvqlLuongKiemKeRepository;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeService;
import domainModels.NhanVien;
import domainModels.PhieuKiemKe;
import infrastructures.constant.TrangThaiPhieuKiemConstant;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeServiceImpl implements NvqlLuongKiemKeService{
    
    private NvqlLuongKiemKeRepository rp;
    
    public NvqlLuongKiemKeServiceImpl(){
        rp = new NvqlLuongKiemKeRepository();
    }

    @Override
    public List<NvqlLuongKiemKeCustom> getAll() {
        return rp.getAll();
    }

    @Override
    public void Insert(NvqlLuongKiemKeCustom phieuKiemKe) {
        NhanVien nv = phieuKiemKe.getIdNV();
        PhieuKiemKe a = new PhieuKiemKe(phieuKiemKe.getMaPhieuKiem(), phieuKiemKe.getNgayTao(), TrangThaiPhieuKiemConstant.MOI_TAO, nv);
        rp.them(a);
    }

    @Override
    public boolean UpdateTrangThai(NvqlLuongKiemKeCustom phieuKiemKe) {
        PhieuKiemKe p = new PhieuKiemKe();
        p.setGhiChu(phieuKiemKe.getGhiChu());
        p.setId(phieuKiemKe.getId());
        p.setMa(phieuKiemKe.getMaPhieuKiem());
        p.setNgayTao(phieuKiemKe.getNgayTao());
        p.setNgayXacNhan(new Date().getTime());
        p.setNhanVien(phieuKiemKe.getIdNV());
        p.setTrangThai(phieuKiemKe.getTrangThai());
        return rp.updateTrangThai(p);
    }
        
}
