/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.repositories.Tai_SanPhamRepository;
import cores.nhanVienQuanLy.services.Tai_SanPhamService;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpThemSanPhamCustom;
import domainModels.SanPham;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import infrastructures.constant.ValidateConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class Tai_SanPhamServiceImpl implements Tai_SanPhamService{
    private Tai_SanPhamRepository rp;

    public Tai_SanPhamServiceImpl() {
        rp  = new Tai_SanPhamRepository();
    }
    
   @Override
    public List<TpQuanLySanPhamCustom> getAll(String ten) {
        return rp.getAll(ten);
    }

    @Override
    public TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom) {
        SanPham sp = new SanPham();
        sp.setMa(custom.getMa());
        sp.setTen(custom.getTen());
        custom.setId(rp.addSanPham(sp).getId());
        return custom;
    }

    @Override
    public boolean updateSanPham(TpThemSanPhamCustom custom) {
        SanPham sp = new SanPham();
        sp.setMa(custom.getMa());
        sp.setTen(custom.getTen());
        sp.setId(custom.getId());
        return rp.updateSanPham(sp);
    }

    @Override
    public boolean deleteSanPham(UUID id) {
        return rp.deleteSanPham(id);
    }

    @Override
    public TpQuanLySanPhamCustom findSanPhamByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen) {

        boolean check = true;

        if (sp.getMa().trim() != null) {
            if (sp.getMa().trim().length() == 0) {
                erroMa.setText("M?? kh??ng ???????c ????? tr???ng");
                check = false;
            } else if (!sp.getMa().trim().matches(sp.getMa().toUpperCase())) {
                erroMa.setText("M?? ph???i vi???t hoa");
                check = false;
            } else if (!sp.getMa().trim().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroMa.setText("M?? kh??ng ???????c c?? kho???ng tr???ng");
                check = false;
            } else if (findSanPhamByMa(sp.getMa().trim()) != null) {
                erroMa.setText("M?? ???? t???n t???i");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (sp.getTen().trim().length() == 0) {
            erroTen.setText("T??n kh??ng ???????c ????? tr???ng");
            check = false;
        } else if (sp.getTen().matches("[A-Z a-z]+")) {
            erroTen.setText("T??n ph???i l?? ch???");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (!check) {
            return null;
        }

        return sp;
    }

    @Override
    public List<TpQuanLySanPhamCustom> phanTrang(List<TpQuanLySanPhamCustom> list, int offset, int limit) {
        List<TpQuanLySanPhamCustom> listPhanTrang = new ArrayList<>();
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                break;
            }
            TpQuanLySanPhamCustom el = list.get(i);
            listPhanTrang.add(el);
        }
        return listPhanTrang;
    }
    
}
