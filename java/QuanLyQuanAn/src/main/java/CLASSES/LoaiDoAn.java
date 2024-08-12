/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

/**
 *
 * @author FPTSHOP
 */
public class LoaiDoAn {
    private String id;
    private String ten;

    public LoaiDoAn(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public LoaiDoAn() {
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

    @Override
    public String toString() {
        return "LoaiDoAn{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                '}';
    }
}

