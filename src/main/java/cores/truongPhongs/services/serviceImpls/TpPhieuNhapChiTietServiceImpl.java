package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpPhieuNhapChiTietCustom;
import cores.truongPhongs.repositories.TpPhieuNhapChiTietRepository;
import cores.truongPhongs.services.TpPhieuNhapChiTietService;
import domainModels.ChiTietPhieuNhap;
import domainModels.ChiTietSanPham;
import domainModels.PhieuNhap;

/**
 *
 * @author Acer
 */
public class TpPhieuNhapChiTietServiceImpl implements TpPhieuNhapChiTietService{
    private TpPhieuNhapChiTietRepository repo;

    public TpPhieuNhapChiTietServiceImpl() {
        repo = new TpPhieuNhapChiTietRepository();
    }
    
    @Override
    public TpPhieuNhapChiTietCustom addPhieuNhap(TpPhieuNhapChiTietCustom pnct) {
        PhieuNhap pn = repo.findPnById(pnct.getIdPhieuNhap());
        ChiTietSanPham sp = repo.findSpById(pnct.getIdSanPham());
        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
        ctpn.setSoLuong(pnct.getSoLuong());
        ctpn.setIdChiTietSp(sp);
        ctpn.setIdPhieuNhap(pn);
        repo.addPhieuNhap(ctpn);
                return pnct;
    }
    
    
}