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
public class KhachHang {
    int MaKH;
    String TenKhachHang;
    String DiaChi;
    boolean GioiTinh;
    String SoDienThoai;
    String LoaiKH;
    String GhiChu;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String TenKhachHang, String DiaChi, boolean GioiTinh, String SoDienThoai, String LoaiKH, String GhiChu) {
        this.MaKH = MaKH;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.LoaiKH = LoaiKH;
        this.GhiChu = GhiChu;
    }

    public KhachHang(String TenKhachHang, String DiaChi, boolean GioiTinh, String SoDienThoai, String LoaiKH, String GhiChu) {
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.LoaiKH = LoaiKH;
        this.GhiChu = GhiChu;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(String LoaiKH) {
        this.LoaiKH = LoaiKH;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
