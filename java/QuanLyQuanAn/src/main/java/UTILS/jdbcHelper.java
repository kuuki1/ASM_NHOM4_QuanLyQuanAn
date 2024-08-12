/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILS;

/**
 *
 * @author FPTSHOP
 */
import java.sql.*;

public class jdbcHelper {
    
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://13.71.106.166:1433;databaseName=SD19301_Team4;encrypt=true;trustServerCertificate=true;trustStore= C:\\\\cert;trustStorePassword=changeit";
    private static String user = "usr01_team4";
    private static String pass = "Phamtin123@@";
    
//    private static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyQuanAn;encrypt=true;trustServerCertificate=true;";
//    private static String user = "phamtin";
//    private static String pass = "123";
    
    // nạp driver
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }
    
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet query(String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, user, pass);
    }
}

