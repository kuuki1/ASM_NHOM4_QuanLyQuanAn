/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILS;

import CLASSES.DoAn;
import CLASSES.NhanVien;
import DAOS.DoAnDAO;
import DAOS.NhanVienDAO;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class test_JDBC {
    public static void main(String[] args){
        //NhanVienDAO dao = new NhanVienDAO();
        DoAnDAO dao = new DoAnDAO();
        List<DoAn> ls = dao.selectAll();
        for (DoAn nv : ls){
            System.out.println("-"+nv.toString());
            System.out.println(" ");
        }
    }
}
