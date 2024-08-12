package DAOS;

import CLASSES.NhanVien;
import UTILS.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends Dao<NhanVien, String> {

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NhanVien ( id, TenNV, TenDangNhap, MatKhau, VaiTro) VALUES (?,?, ?, ?, ?)";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getId());
            pstmt.setString(2, entity.getTenNV());
            pstmt.setString(3, entity.getTenDangNhap());
            pstmt.setString(4, entity.getMatKhau());
            pstmt.setBoolean(5, entity.isVaiTro());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(NhanVien entity) {
        String sql = "UPDATE NhanVien SET TenNV = ?, TenDangNhap = ?, MatKhau = ?, VaiTro = ? WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTenNV());
            pstmt.setString(2, entity.getTenDangNhap());
            pstmt.setString(3, entity.getMatKhau());
            pstmt.setBoolean(4, entity.isVaiTro());
            pstmt.setString(5, entity.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM NhanVien WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql("SELECT * FROM NhanVien");
    }

    @Override
    public NhanVien selectByID(String id) {
        List<NhanVien> list = this.selectBySql("SELECT * FROM NhanVien WHERE id = ?", id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public NhanVien selectByTK(String tk) {
        String sql = "SELECT * FROM NhanVien WHERE TenDangNhap = ?";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, tk);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("id"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setTenDangNhap(rs.getString("TenDangNhap"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setVaiTro(rs.getBoolean("VaiTro"));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    NhanVien entity = new NhanVien(
                            rs.getString("id"),
                            rs.getString("TenNV"),
                            rs.getString("TenDangNhap"),
                            rs.getString("MatKhau"),
                            rs.getBoolean("VaiTro")
                    );
                    list.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
