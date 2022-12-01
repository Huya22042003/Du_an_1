package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import cores.nhanVienQuanLy.repositories.NvqlLuongKiemKeCtspRepository;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtspService;
import domainModels.ChiTietSanPham;
import java.util.List;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeCtspServiceImpl implements NvqlLuongKiemKeCtspService{
    private NvqlLuongKiemKeCtspRepository rp;
    
    public NvqlLuongKiemKeCtspServiceImpl(){
        rp = new NvqlLuongKiemKeCtspRepository();
    }

    @Override
    public List<NvqlLuongKiemKeCtspCustom> getAll() {
        return rp.getAll();
    }

    @Override
    public void updateSoLuong(NvqlLuongKiemKeCtspCustom a) {
        ChiTietSanPham ctsp = new ChiTietSanPham(
                a.getId(), 
                a.getSoLuongTon(), 
                a.getHinhAnh(), 
                a.getGiaNhap(), 
                a.getGiaBan(), 
                a.getNamBaoHanh(), 
                a.getMau(), 
                a.getTrangThai(), 
                a.getSize(),
                a.getNgayTao(),
                a.getSanPham(), 
                a.getDonVi()
        );
        rp.updateSoLuong(ctsp);
    }
}
