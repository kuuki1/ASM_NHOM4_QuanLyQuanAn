/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

/**
 *
 * @author FPTSHOP
 */
public class DatMon {
    private String tenMon;
    private String soLuong;
    private float gia;
    private float thanhTien;
    private String idBan;

    public DatMon(String tenMon, String soLuong, float gia, float thanhTien, String idBan) {
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
        this.idBan = idBan;
    }

    public DatMon() {        
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getIdBan() {
        return idBan;
    }

    public void setIdBan(String idBan) {
        this.idBan = idBan;
    }

    @Override
    public String toString() {
        return "DatMon{" +
                "tenMon='" + tenMon + '\'' +
                ", soLuong='" + soLuong + '\'' +
                ", gia=" + gia +
                ", thanhTien=" + thanhTien +
                ", idBan='" + idBan + '\'' +
                '}';
    }
}

