/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.helper;

/**
 *
 * @author This PC
 */
public class Mycbb {
    
    Object value;
    Object text;

    public Mycbb(Object value, Object text) {
        this.value = value;
        this.text = text;
    }
    
    public String toString() {
        return text.toString();
    }
    
    // hàm lấy value kiểu int
    public int MaInt() {
        return Integer.parseInt(value.toString());
        
    } 
    
    // hàm lấy kiểu string
    
    public String MaString() {
        return value.toString();
        
    } 

}
