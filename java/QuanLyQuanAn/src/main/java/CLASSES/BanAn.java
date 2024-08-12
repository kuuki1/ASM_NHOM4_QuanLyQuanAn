/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

/**
 *
 * @author FPTSHOP
 */
public class BanAn {
    private String id;
    private String ten;
    private String ghiChu;

    public BanAn(String id, String ten, String ghiChu) {
        this.id = id;
        this.ten = ten;
        this.ghiChu = ghiChu;
    }

    public BanAn() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "BanAn{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}

