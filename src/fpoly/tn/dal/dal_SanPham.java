/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.dal;
import fpoly.tn.helper.sql_Helper;
import java.sql.*;
/**
 *
 * @author Administrator
 */
public class dal_SanPham {
    
    
    // hàm lấy tất cả sản phẩm
    
    public static ResultSet GetAll(){
        String sql = "Select * from SanPham";
        
        return sql_Helper.executeQuery(sql);
    }
}
