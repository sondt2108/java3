/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;

import fpoly.tn.helper.Mycbb;
import fpoly.tn.helper.ThongBao;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrator
 */
public class bll_MyCbb {
    
    
    // đổi dữ liệu vào cbb
    
    public static void LoadCbb(JComboBox cbb, ResultSet rs){
        
        
        try {
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbb.getModel();
            cbbModel.removeAllElements();
           
            while(rs.next()) {
                Mycbb mycbb = new Mycbb(rs.getInt(1), rs.getString(2));
                cbbModel.addElement(mycbb);
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDonGian("Thông báo", "Lỗi load dữ liệu cho cbb");
        }
    }
}
