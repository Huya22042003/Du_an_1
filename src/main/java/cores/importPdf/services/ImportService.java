package cores.importPdf.services;

import cores.importPdf.customModels.MessAlert;
import cores.importPdf.customModels.SanPhamCustom;
import java.util.List;

/**
 *
 * @author QUOC HUY
 */
public interface ImportService {
    List<SanPhamCustom> importList(String fileName);
    MessAlert importData(List<SanPhamCustom> listPdf);
}
