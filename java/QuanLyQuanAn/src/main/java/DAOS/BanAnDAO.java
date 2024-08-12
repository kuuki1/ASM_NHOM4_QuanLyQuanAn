package DAOS;

import CLASSES.BanAn;
import UTILS.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BanAnDAO extends Dao<BanAn, String> {

    @Override
    public void insert(BanAn entity) {
        String sql = "INSERT INTO BanAn (id, Ten, GhiChu) VALUES (?, ?, ?)";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getId());
            pstmt.setString(2, entity.getTen());
            pstmt.setString(3, entity.getGhiChu());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BanAn entity) {
        String sql = "UPDATE BanAn SET Ten = ?, GhiChu = ? WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTen());
            pstmt.setString(2, entity.getGhiChu());
            pstmt.setString(3, entity.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sqlHoaDon = "DELETE FROM HoaDon WHERE idBan = ?";
        String sqlBanAn = "DELETE FROM BanAn WHERE id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmtHoaDon = conn.prepareStatement(sqlHoaDon);
             PreparedStatement pstmtBanAn = conn.prepareStatement(sqlBanAn)) {
            conn.setAutoCommit(false);
            pstmtHoaDon.setString(1, id);
            pstmtHoaDon.executeUpdate();
            pstmtBanAn.setString(1, id);
            pstmtBanAn.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BanAn> selectAll() {
        return this.selectBySql("SELECT * FROM BanAn");
    }

    @Override
    public BanAn selectByID(String id) {
        List<BanAn> list = this.selectBySql("SELECT * FROM BanAn WHERE id = ?", id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BanAn> selectBySql(String sql, Object... args) {
        List<BanAn> list = new ArrayList<>();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BanAn entity = new BanAn(
                            rs.getString("id"),
                            rs.getString("Ten"),
                            rs.getString("GhiChu")
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
