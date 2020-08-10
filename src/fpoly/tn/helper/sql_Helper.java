/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class sql_Helper {
     private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl="jdbc:sqlserver://localhost;database=QLSanPham";
    private static String username="sa";
    private static String password="21122000";
    
    /*
     * Náº¡p driver
     */
    static{
        try {
            Class.forName(driver);
        } 
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * XÃ¢y dá»±ng PreparedStatement
     * @param sql lÃ  cÃ¢u lá»‡nh SQL chá»©a cÃ³ thá»ƒ chá»©a tham sá»‘. NÃ³ cÃ³ thá»ƒ lÃ  má»™t lá»�i gá»�i thá»§ tá»¥c lÆ°u
     * @param args lÃ  danh sÃ¡ch cÃ¡c giÃ¡ trá»‹ Ä‘Æ°á»£c cung cáº¥p cho cÃ¡c tham sá»‘ trong cÃ¢u lá»‡nh sql
     * @return PreparedStatement táº¡o Ä‘Æ°á»£c
     * @throws java.sql.SQLException lá»—i sai cÃº phÃ¡p
     */
    public static PreparedStatement prepareStatement(String sql, Object...args) throws SQLException{
        Connection connection = DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }
        else{
            pstmt = connection.prepareStatement(sql);
        }
        for(int i=0;i<args.length;i++){
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }
    /**
     * Thá»±c hiá»‡n cÃ¢u lá»‡nh SQL thao tÃ¡c (INSERT, UPDATE, DELETE) hoáº·c thá»§ tá»¥c lÆ°u thao tÃ¡c dá»¯ liá»‡u
     * @param sql lÃ  cÃ¢u lá»‡nh SQL chá»©a cÃ³ thá»ƒ chá»©a tham sá»‘. NÃ³ cÃ³ thá»ƒ lÃ  má»™t lá»�i gá»�i thá»§ tá»¥c lÆ°u
     * @param args lÃ  danh sÃ¡ch cÃ¡c giÃ¡ trá»‹ Ä‘Æ°á»£c cung cáº¥p cho cÃ¡c tham sá»‘ trong cÃ¢u lá»‡nh sql     * 
     */
    public static void executeUpdate(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            System.out.println(stmt.toString());
            try {
                stmt.executeUpdate();
            } 
            finally{
                stmt.getConnection().close();
            }
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Thá»±c hiá»‡n cÃ¢u lá»‡nh SQL truy váº¥n (SELECT) hoáº·c thá»§ tá»¥c lÆ°u truy váº¥n dá»¯ liá»‡u
     * @param sql lÃ  cÃ¢u lá»‡nh SQL chá»©a cÃ³ thá»ƒ chá»©a tham sá»‘. NÃ³ cÃ³ thá»ƒ lÃ  má»™t lá»�i gá»�i thá»§ tá»¥c lÆ°u
     * @param args lÃ  danh sÃ¡ch cÃ¡c giÃ¡ trá»‹ Ä‘Æ°á»£c cung cáº¥p cho cÃ¡c tham sá»‘ trong cÃ¢u lá»‡nh sql
     */    
    public static ResultSet executeQuery(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
