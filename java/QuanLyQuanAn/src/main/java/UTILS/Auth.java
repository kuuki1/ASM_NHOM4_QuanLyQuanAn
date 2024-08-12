/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILS;

import CLASSES.NhanVien;

/**
 *
 * @author FPTSHOP
 */
public class Auth {
    public static NhanVien user;
    
    public static void clear() {
        Auth.user = null;
    }
    //kiểm tra đăng nhập
    public static boolean isLogin() {
        return Auth.user != null;
    }
    //kiểm tra quyền
    public static boolean isManager() {
        return Auth.isLogin() && user.isVaiTro();
    }
}
