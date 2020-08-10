/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;

import fpoly.tn.dal.dal_NhanVien;
import fpoly.tn.dto.dto_NhanVien;
import fpoly.tn.helper.ThongBao;
import fpoly.tn.helper.chuyenDoi;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class bll_NhanVien {
    
    public static Boolean KiemTraThongTin (String TenDangNhap, String MatKhau) {
        
        if(TenDangNhap.isEmpty() || MatKhau.isBlank()) {
            ThongBao.ThongBaoDonGian("Lỗi đăng nhập", "Chưa nhập thông tin");
            
            return false;
        }
        
        return true;
    }
    
    public static String DangNhap(String TenDangNhap, String MatKhau) {
        try {
            ResultSet rs = dal_NhanVien.DangNhap(TenDangNhap, MatKhau);
            
            if(rs.next()) {
                return TenDangNhap;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDonGian("Thông báo lỗi", "Lỗi SQL đăng nhập");
        }
        return "";
    }
    
    public static boolean KiemTraThem(dto_NhanVien nv) {
        if(nv.getTenNV().isBlank()) {
            ThongBao.ThongBaoDonGian("thông báo", "Bạn chưa nhập thông tin nhân viên");
            
            return false;
        }
        
        if(nv.getTenNV().length() < 6) {
          ThongBao.ThongBaoDonGian("thông báo", "Tên nhân viên lớn hơn 6 kí tự"); 
          
          return false;
        }
        
        return true;
    }
    
    public static void ThemNV(dto_NhanVien nv) {
        // gọi hàm kiểm tra tính hợp lệ của nhân viên
        boolean kiemTra = KiemTraThem(nv);
        // nếu kiểm tra ok thì thực hiện thêm nhân viên
        
        if(kiemTra) {
            dal_NhanVien.ThemNV(nv);
        }
    }
    
    //Hàm đổ dữ liệu nhân viên vào table
    
    public static void LoadNhanVien(JTable tbl) {
        
        DefaultTableModel tbModel = (DefaultTableModel)tbl.getModel();
        tbModel.setRowCount(0); // bỏ hết các dòng đang có trong table
        
        //lấy dữ liệu từ tầng DAL_NhanVien
        ResultSet rs = dal_NhanVien.GetAllNhanVien();
        
        Object obj[] = new Object[7];
        try {
            while(rs.next()) {
                    obj[0] = rs.getInt("MaNhanVien");
                    obj[1] = tbModel.getRowCount() + 1 ;
                    obj[2] = rs.getString("TenNhanVien");
                    obj[3] = rs.getString("SoDienThoai");
                    boolean gt = rs.getBoolean("GioiTinh");
                    if(gt) {
                        obj[4] = "Nam";
                    }else {
                        obj[4] = "Nữ";
                    }
                    
                    obj[5] = chuyenDoi.LayNgayString(rs.getDate("NgaySinh")) ;
                    obj[6] = rs.getString("ChucVu");
                    
                    // thêm obj vào table
                    tbModel.addRow(obj);
            }   
        } catch (SQLException ex) {
            ThongBao.ThongBaoDonGian("Thông báo", "Lỗi lấy dữ liệu nhân viên");
        }
    }
    
    // hàm lấy thông tin nhân viên
    
    public static dto_NhanVien GetNhanVien(String MaNV) {
        //gọi hàm lấy nhân viên theo mã
        ResultSet rs = dal_NhanVien.GetNhanVienTheoMa(MaNV);
        
        try {
            if(rs.next()) {
              dto_NhanVien nv = new dto_NhanVien();
              nv.setMaNhanVien(rs.getInt("MaNhanVien"));
              nv.setTenNV(rs.getString("TenNhanVien"));
              nv.setDiaChi(rs.getString("DiaChi"));
              nv.setSoDienThoai(rs.getString("SoDienThoai"));
              nv.setGioiTinh(rs.getBoolean("GioiTinh"));
              nv.setChucVu(rs.getString("ChucVu"));
              nv.setNgaySinh(rs.getDate("NgaySinh"));
              nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
              nv.setTenDangNhap(rs.getString("TenDangNhap"));
              nv.setMatKhau(rs.getString("MatKhau"));
              
              //trả về nhân viên
              
              return nv;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDonGian("Thông báo lỗi", "Lỗi lấy nhân viên theo mã");
            
            
        }
        return null;
    }
    
    public static void Sua(dto_NhanVien nv) {
        //gọi hàm kiểm tra nhân viên
        if(!KiemTraThem(nv)) {
            return; // thoát khỏi hàm
        }
        
        //gọi hàm sửa nhân viên từ DAL
        dal_NhanVien.Sua(nv);
    }
    
    // hàm xóa danh sách nhân viên theo list mã nhân viên
    public static void Xoa(List<String> lstMaNhanVien) {
        for(String MaNhanVien : lstMaNhanVien) {
            dal_NhanVien.Xoa(MaNhanVien);
        }
    }
    
    //hàm tìm kiếm nhân viên
    
    public static void TimKiem(JTable tbl, String TenNhanVien, String ChucVu) {
        
        DefaultTableModel tbModel = (DefaultTableModel)tbl.getModel();
        tbModel.setRowCount(0); // bỏ hết các dòng đang có trong table
        
        //lấy dữ liệu từ tầng DAL_NhanVien
        ResultSet rs = dal_NhanVien.TimKiem(TenNhanVien, ChucVu);
        
        Object obj[] = new Object[7];
        try {
            while(rs.next()) {
                    obj[0] = rs.getInt("MaNhanVien");
                    obj[1] = tbModel.getRowCount() + 1 ;
                    obj[2] = rs.getString("TenNhanVien");
                    obj[3] = rs.getString("SoDienThoai");
                    boolean gt = rs.getBoolean("GioiTinh");
                    if(gt) {
                        obj[4] = "Nam";
                    }else {
                        obj[4] = "Nữ";
                    }
                    
                    obj[5] = chuyenDoi.LayNgayString(rs.getDate("NgaySinh")) ;
                    obj[6] = rs.getString("ChucVu");
                    
                    // thêm obj vào table
                    tbModel.addRow(obj);
            }   
        } catch (SQLException ex) {
            ThongBao.ThongBaoDonGian("Thông báo", "Lỗi lấy dữ liệu nhân viên");
        }
    }
}
