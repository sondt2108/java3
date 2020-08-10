/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;


import fpoly.tn.dal.dal_SanPham;
import fpoly.tn.helper.ThongBao;
import fpoly.tn.helper.chuyenDoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class bll_SanPham {
    public static void LoadSanPhamFormHoaDon(JTable tbl) {
        
        DefaultTableModel tbModel = (DefaultTableModel)tbl.getModel();
        tbModel.setRowCount(0); // bỏ hết các dòng đang có trong table
        
        //lấy dữ liệu từ tầng DAL_SanPham
        ResultSet rs = dal_SanPham.GetAll();
        
        Object obj[] = new Object[5];
        try {
            while(rs.next()) {
                    obj[0] = rs.getInt("IDSanPham");
                    obj[1] = rs.getString("MaSP");
                    obj[2] = rs.getString("TenSP");
                    obj[3] = rs.getInt("SoLuong");
                    obj[4] =chuyenDoi.SoString(rs.getDouble("GiaBan"));
                    
                    
                    // thêm obj vào table
                    tbModel.addRow(obj);
            }   
        } catch (SQLException ex) {
            ThongBao.ThongBaoDonGian("Thông báo", "Lỗi lấy dữ liệu sản phẩm");
        }
    }
}
