/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

import java.sql.Date;

/**
 *
 * @author FPTSHOP
 */

public class HoaDon {
    private Date Ngay;
    private String idBan;
    private float tongTien;

    public HoaDon(Date Ngay, String idBan, float tongTien) {
        this.Ngay = Ngay;
        this.idBan = idBan;
        this.tongTien = tongTien;
    }
    
    public HoaDon() {
        
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public String getIdBan() {
        return idBan;
    }

    public void setIdBan(String idBan) {
        this.idBan = idBan;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "idBan=" + idBan +
                ", tongTien=" + tongTien +
                '}';
    }
}

