/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Entity
@Data
@Table(name = "ChiTietPhieuHoanXuat")
@IdClass(ChiTietPhieuHoanXuatId.class)
public class ChiTietPhieuHoanXuat implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdPhieuHoanXuat")
    private PhieuHoanXuat idPhieuHoanXuat;
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham idChiTietSP;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    
}