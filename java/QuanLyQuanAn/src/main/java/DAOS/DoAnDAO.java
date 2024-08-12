package DAOS;

import CLASSES.DoAn;
import UTILS.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoAnDAO extends Dao<DoAn, String> {

    @Override
    public void insert(DoAn entity) {
        String sql = "INSERT INTO DoAn (id, Ten, Gia, idLoaiDoAn) VALUES (?, ?, ?, ?)";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getId());
            pstmt.setString(2, entity.getTen());
            pstmt.setFloat(3, entity.getGia());
            pstmt.setString(4, entity.getLoai());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DoAn entity) {
        String sql = "UPDATE DoAn SET Ten = ?, Gia = ?, idLoaiDoAn = ? WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTen());
            pstmt.setFloat(2, entity.getGia());
            pstmt.setString(3, entity.getLoai());
            pstmt.setString(4, entity.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM DoAn WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    @Override
//    public List<DoAn> selectAll() {
//        return this.selectBySql("SELECT * FROM DoAn");
//    }

    @Override
    public List<DoAn> selectAll() {
        List<DoAn> list = new ArrayList<>();
        String sql = "SELECT DoAn.id, DoAn.ten, LoaiDoAn.ten AS loai, DoAn.gia " +
                     "FROM DoAn " +
                     "JOIN LoaiDoAn ON DoAn.idLoaiDoAn = LoaiDoAn.id";

        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DoAn doAn = new DoAn();
                doAn.setId(rs.getString("id"));
                doAn.setTen(rs.getString("ten"));
                doAn.setLoai(rs.getString("loai"));
                doAn.setGia(rs.getFloat("gia"));
                list.add(doAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public DoAn selectByID(String id) {
        List<DoAn> list = this.selectBySql("SELECT * FROM DoAn WHERE id = ?", id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DoAn> selectBySql(String sql, Object... args) {
        List<DoAn> list = new ArrayList<>();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DoAn entity = new DoAn(
                        rs.getString("id"),
                        rs.getString("ten"),
                        rs.getFloat("gia"),
                        rs.getString("idLoaiDoAn")
                    );
                    list.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<DoAn> getDoAnByLoai(String loaiId) {
        ArrayList<DoAn> result = new ArrayList<>();
        String query = "SELECT * FROM DoAn WHERE idLoaiDoAn = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, loaiId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DoAn da = new DoAn();
                    da.setId(rs.getString("id"));
                    da.setTen(rs.getString("ten"));
                    da.setGia(rs.getFloat("gia"));
                    da.setLoai(rs.getString("idLoaiDoAn"));
                    result.add(da);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<DoAn> selectByName(String name, String category) {
        List<DoAn> result = new ArrayList<>();
        
        String sql = "SELECT * FROM DoAn WHERE Ten = ? AND idLoaiDoAn = ?";

        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, category);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DoAn doAn = new DoAn();
                doAn.setId(resultSet.getString("id"));
                doAn.setTen(resultSet.getString("Ten"));
                doAn.setLoai(resultSet.getString("idLoaiDoAn"));
                doAn.setGia(resultSet.getFloat("Gia"));
                
                result.add(doAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        
        return result;
    }
}
