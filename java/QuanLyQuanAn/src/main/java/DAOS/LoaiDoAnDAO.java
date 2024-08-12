package DAOS;

import CLASSES.LoaiDoAn;
import UTILS.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoaiDoAnDAO extends Dao<LoaiDoAn, String> {

    @Override
    public void insert(LoaiDoAn entity) {
        String sql = "INSERT INTO LoaiDoAn (id, Ten) VALUES (?, ?)";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getId());
            pstmt.setString(2, entity.getTen());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LoaiDoAn entity) {
        String sql = "UPDATE LoaiDoAn SET Ten = ? WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTen());
            pstmt.setString(2, entity.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM LoaiDoAn WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LoaiDoAn> selectAll() {
        return this.selectBySql("SELECT * FROM LoaiDoAn");
    }

    @Override
    public LoaiDoAn selectByID(String id) {
        List<LoaiDoAn> list = this.selectBySql("SELECT * FROM LoaiDoAn WHERE id = ?", id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public int selectIdByName(String name) {
        String sql = "SELECT id FROM LoaiDoAn WHERE ten = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<LoaiDoAn> selectBySql(String sql, Object... args) {
        List<LoaiDoAn> list = new ArrayList<>();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LoaiDoAn entity = new LoaiDoAn(
                            rs.getString("id"),
                            rs.getString("Ten")
                    );
                    list.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public LoaiDoAn selectByName(String tenLoai) {
        LoaiDoAn result = null;
        String query = "SELECT * FROM LoaiDoAn WHERE Ten = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenLoai);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = new LoaiDoAn();
                    result.setId(rs.getString("id"));
                    result.setTen(rs.getString("Ten"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<String> getAllLoaiDoAn() throws SQLException {
        List<String> loaiDoAnList = new ArrayList<>();
        String query = "SELECT Ten FROM LoaiDoAn";
        try (Connection conn = jdbcHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                loaiDoAnList.add(rs.getString("Ten"));
            }
        }
        return loaiDoAnList;
    }

}
