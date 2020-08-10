/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.dto;

/**
 *
 * @author Administrator
 */
public class LoaiSanPham {
    int MaLoaiSP;
    String TenLoai;
    String MoTa;

    public LoaiSanPham() {
    }
    
    

    public LoaiSanPham(int MaLoaiSP, String TenLoai, String MoTa) {
        this.MaLoaiSP = MaLoaiSP;
        this.TenLoai = TenLoai;
        this.MoTa = MoTa;
    }

    public LoaiSanPham(String TenLoai, String MoTa) {
        this.TenLoai = TenLoai;
        this.MoTa = MoTa;
    }
    
    

    public int getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(int MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
            
}
