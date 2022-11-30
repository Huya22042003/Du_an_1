package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpPhieuNhapChiTietCustom;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Acer
 */
public interface TpPhieuNhapChiTietService {
    public TpPhieuNhapChiTietCustom addPhieuNhap(TpPhieuNhapChiTietCustom pnct);
    List<TpPhieuNhapChiTietCustom> getListCTPhieuNhapByID(UUID idPX);
    public boolean addCTPN(TpPhieuNhapChiTietCustom ctpxct);
}
