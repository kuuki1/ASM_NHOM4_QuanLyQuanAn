package DAOS;

import CLASSES.DatMon;
import UTILS.jdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatMonDAO extends Dao<DatMon, String>{
    
    @Override
    public void insert(DatMon entity) {
        String sql = "INSERT INTO DatMon (TenMon, SoLuong, Gia, ThanhTien, idBan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTenMon());
            pstmt.setString(2, entity.getSoLuong());
            pstmt.setFloat(3, entity.getGia());
            pstmt.setFloat(4, entity.getThanhTien());
            pstmt.setString(5,entity.getIdBan());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DatMon entity) {
        String sql = "update DatMon set SoLuong = ?, Gia = ?, ThanhTien = ?, idBan = ? where TenMon = ?;";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getSoLuong());
            pstmt.setFloat(2, entity.getGia());
            pstmt.setFloat(3, entity.getThanhTien());
            pstmt.setString(4, entity.getIdBan());
            pstmt.setString(5, entity.getTenMon());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(String id) {
        String sql = "DELETE FROM DatMon WHERE idBan = ?";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteMon(String name) {
        String sql = "DELETE FROM DatMon WHERE TenMon = ?";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DatMon> selectAll() {
        return this.selectBySql("SELECT * FROM DatMon");
    }

    @Override
    public DatMon selectByID(String id) {
        List<DatMon> list = this.selectBySql("SELECT * FROM DatMon WHERE idBan = ?", id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<DatMon> selectByBanID(String banId) {
        String sql = "SELECT * FROM DatMon WHERE idBan = ?";
        return selectBySql(sql, banId);
    }

    public List<DatMon> selectbyName(String TenMonAN) {
        String sql = "SELECT TenMon FROM DatMon WHERE idBan = ?";
        return selectBySql(sql, TenMonAN);
    }

    @Override
    public List<DatMon> selectBySql(String sql, Object... args) {
        List<DatMon> list = new ArrayList<>();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DatMon entity = new DatMon(
                            rs.getString("TenMon"),
                            rs.getString("SoLuong"),
                            rs.getFloat("Gia"),
                            rs.getFloat("ThanhTien"),
                            rs.getString("idBan")
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
