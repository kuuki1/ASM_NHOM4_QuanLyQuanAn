/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

/**
 *
 * @author FPTSHOP
 */
public class DoAn {
    private String id;
    private String ten;
    private float gia;
    private String loai;

    public DoAn(String id, String ten, float gia, String loai) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.loai = loai;
    }

    public DoAn() {
        
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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return "DoAn{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", gia=" + gia +
                ", loai='" + loai + '\'' +
                '}';
    }
}

