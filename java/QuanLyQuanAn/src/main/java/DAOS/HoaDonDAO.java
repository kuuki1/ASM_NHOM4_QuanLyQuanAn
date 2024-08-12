package DAOS;

import CLASSES.HoaDon;
import UTILS.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO extends Dao<HoaDon, Integer> {

    @Override
    public void insert(HoaDon entity) {
        String sql = "INSERT INTO HoaDon (idBan, TongTien) VALUES (?, ?)";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,entity.getIdBan());
            pstmt.setFloat(2, entity.getTongTien());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HoaDon entity) {
        String sql = "UPDATE HoaDon SET idBan = ?, TongTien = ? WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getIdBan());
            pstmt.setFloat(2, entity.getTongTien());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM HoaDon WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql("SELECT * FROM HoaDon");
    }

    @Override
    public HoaDon selectByID(Integer id) {
        List<HoaDon> list = this.selectBySql("SELECT * FROM HoaDon WHERE id = ?", id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    HoaDon entity = new HoaDon(
                        rs.getDate("Ngay"),
                        rs.getString("idBan"),
                        rs.getFloat("TongTien")
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
