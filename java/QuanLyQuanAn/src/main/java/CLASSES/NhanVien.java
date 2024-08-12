/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

/**
 *
 * @author FPTSHOP
 */
public class NhanVien {
    private String id;
    private String tenNV;
    private String tenDangNhap;
    private String matKhau;
    private boolean vaiTro;

    public NhanVien(String id, String tenNV, String tenDangNhap, String matKhau, boolean vaiTro) {
        this.id = id;
        this.tenNV = tenNV;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public NhanVien() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", tenNV='" + tenNV + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", vaiTro=" + vaiTro +
                '}';
    }
}
