package dao;

import bean.Record;

import java.sql.*;

public class RecordDao {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL    = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN  = "postgres";
    private static final String PASS   = "postgres";
    private static final String ADD    = "INSERT INTO record VALUES((SELECT MAX(id)+1 FROM record), ?, ?, ?)";

    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void add(Record r) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = prepareStatement(c, ADD);
            ps.setString(1, r.getAddress());
            ps.setString(2, r.getLogin());
            ps.setString(3, r.getPass());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASS);
    }

    private static PreparedStatement prepareStatement(Connection c, String sql) throws SQLException {
        return c.prepareStatement(sql);
    }
}
