/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.dal;

import fpoly.tn.dto.dto_NhanVien;
import fpoly.tn.helper.chuyenDoi;
import fpoly.tn.helper.sql_Helper;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class dal_NhanVien {

    public static ResultSet DangNhap(String TenDangNhap, String MatKhau) {
        String sql = "Select * from NhanVien where TenDangNhap = ? and MatKhau = ?";

        return sql_Helper.executeQuery(sql, TenDangNhap, MatKhau);
    }

    public static void ThemNV(dto_NhanVien nv) {
        String sql = "Set DateFormat DMY INSERT INTO [dbo].[NhanVien]([TenNhanVien], [DiaChi], [SoDienThoai], [GioiTinh],  "
                + "								[ChucVu], [NgaySinh], [NgayVaoLam], [TenDangNhap], [MatKhau]) "
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        sql_Helper.executeUpdate(sql,
                nv.getTenNV(),
                nv.getDiaChi(),
                nv.getSoDienThoai(),
                nv.isGioiTinh(),
                nv.getChucVu(),
                chuyenDoi.LayNgayString(nv.getNgaySinh()),
                chuyenDoi.LayNgayString(nv.getNgayVaoLam()),
                nv.getTenDangNhap(),
                nv.getMatKhau());
    }

    // hàm lấy tất cả nhân viên
    public static ResultSet GetAllNhanVien() {
        String sql = "Select * from NhanVien";

        return sql_Helper.executeQuery(sql);
    }

    //Hàm lấy nhân viên theo mã
    public static ResultSet GetNhanVienTheoMa(String MaNV) {
        String sql = "Select * from NhanVien where MaNhanVien = ? ";

        return sql_Helper.executeQuery(sql, MaNV);
    }

    //hàm sửa nhân viên theo mã
    public static void Sua(dto_NhanVien nv) {
        String sql = " Set Dateformat DMY "
                + " UPDATE [dbo].[NhanVien] "
                + "   SET [TenNhanVien] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[SoDienThoai] = ? "
                + "      ,[GioiTinh] = ? "
                + "      ,[ChucVu] = ? "
                + "      ,[NgaySinh] = ? "
                + "      ,[NgayVaoLam] = ? "
                + "      ,[TenDangNhap] = ? "
                + "      ,[MatKhau] = ? "
                + " WHERE MaNhanVien = ?";

        sql_Helper.executeUpdate(sql,
                nv.getTenNV(),
                nv.getDiaChi(),
                nv.getSoDienThoai(),
                nv.isGioiTinh(),
                nv.getChucVu(),
                chuyenDoi.LayNgayString(nv.getNgaySinh()),
                chuyenDoi.LayNgayString(nv.getNgayVaoLam()),
                nv.getTenDangNhap(),
                nv.getMatKhau(),
                nv.getMaNhanVien());
                
    }
    
    public static void Xoa(String MaNhanVien) {
        String sql = "Delete from NhanVien Where MaNhanVien = ? ";
        
        sql_Helper.executeUpdate(sql, MaNhanVien);
    }
    
    // hàm tìm kiếm gọi thủ (proc) từ sql
    
    public static ResultSet TimKiem(String TenNhanVien, String ChucVu) {
        String sql = "{call spTimKiem(?,?)}";
        
        return sql_Helper.executeQuery(sql, TenNhanVien, ChucVu);
    }
}
