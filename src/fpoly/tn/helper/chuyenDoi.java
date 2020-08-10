/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.helper;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class chuyenDoi {
    //Chuyá»ƒn Ä‘á»•i kiá»ƒu Date <-> String
    //Táº¡o Ä‘á»‹nh dáº¡ng ngÃ y thÃ¡ng
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //HÃ m chuyá»ƒn Date -> String
    public static String LayNgayString(Date date){
        return dateFormat.format(date);
    }
    
    //HÃ m chuyá»ƒn String -> Date
    public static Date LayNgayDate(String ngay){
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển ngày");
            return null;
        }
    }
    
    //Chuyá»ƒn Ä‘á»•i sá»‘ Double <-> String 10.000.000
    //HÃ m chuyá»ƒn Double -> String
    public static String SoString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    
    //HÃ m chuyá»ƒn String -> Double
    public static double SoDouble(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển số");
            return 0;
        }
    }
}
