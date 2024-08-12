package DAOS;

import UTILS.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {

    public List<Object[]> getDoanhThuTheoNgayVaBan(int ngay) {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT HoaDon.Ngay, BanAn.Ten AS Ban, HoaDon.Tongtien "
                   + "FROM HoaDon "
                   + "JOIN BanAn ON HoaDon.idBan = BanAn.id "
                   + "WHERE DAY(HoaDon.Ngay) = ? ";
        try {
            ResultSet rs = jdbcHelper.query(sql, ngay);
            while (rs.next()) {
                Object[] model = {
                    rs.getDate("Ngay"),
                    rs.getString("Ban"),
                    rs.getDouble("Tongtien")
                };
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getDoanhThuTheoThangVaBan(int thang) {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT HoaDon.Ngay, BanAn.Ten AS Ban, HoaDon.Tongtien "
                   + "FROM HoaDon "
                   + "JOIN BanAn ON HoaDon.idBan = BanAn.id "
                   + "WHERE MONTH(HoaDon.Ngay) = ? ";
        try {
            ResultSet rs = jdbcHelper.query(sql, thang);
            while (rs.next()) {
                Object[] model = {
                    rs.getDate("Ngay"),
                    rs.getString("Ban"),
                    rs.getDouble("Tongtien")
                };
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getDoanhThuTheoNamVaBan(int nam) {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT HoaDon.Ngay, BanAn.Ten AS Ban, HoaDon.Tongtien "
                   + "FROM HoaDon "
                   + "JOIN BanAn ON HoaDon.idBan = BanAn.id "
                   + "WHERE YEAR(HoaDon.Ngay) = ? ";
        try {
            ResultSet rs = jdbcHelper.query(sql, nam);
            while (rs.next()) {
                Object[] model = {
                    rs.getDate("Ngay"),
                    rs.getString("Ban"),
                    rs.getDouble("Tongtien")
                };
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
