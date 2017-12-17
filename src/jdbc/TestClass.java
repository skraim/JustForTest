package jdbc;

import java.sql.*;

public class TestClass {
    public static final String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost/mydb?user=artem&password=1234plaekA";
    public static final String MYSQL_SELECT_FROM_USERS = "SELECT * FROM USERS";
    public static final String MYSQL_SELECT_ALL_CLIENTS =
            "SELECT u.login FROM users u, roles r WHERE u.role_id=r.id "
                    + "AND r.name='client'";
    public static final String MYSQL_INSERT_INTO_USERS = "insert into users values(DEFAULT, ?, (SELECT roles.id FROM roles WHERE name = ?))";

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(MYSQL_CONNECTION_URL);
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println(dbmd.getUserName());
        System.out.println(dbmd.getClass().getName());
        System.out.println(dbmd.getSQLKeywords());
        ResultSet rss = dbmd.getPrimaryKeys("mydb","","users");
        while (rss.next()) {
            System.out.println(rss.getString(1));
        }
        System.out.println("===");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(MYSQL_SELECT_FROM_USERS);
        while (rs.next()) {
            System.out.println(rs.getString("login"));
        }
        System.out.println();
        rs = stmt.executeQuery(MYSQL_SELECT_ALL_CLIENTS);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
//        PreparedStatement pstmt = con.prepareStatement(MYSQL_INSERT_INTO_USERS);//, new String[]{"Igor"});
//        pstmt.setString(1,"Igor");
//        pstmt.setString(2,"moderator");
//        pstmt.executeUpdate();
        rs = stmt.executeQuery(MYSQL_SELECT_FROM_USERS);
        while (rs.next()) {
            System.out.println(rs.getString("login")+" "+rs.getString("role_id"));
        }
        transactionTest(con, "gadjlg", "semiadmin");
        rs = stmt.executeQuery(MYSQL_SELECT_FROM_USERS);
        while (rs.next()) {
            System.out.println(rs.getString("login")+" "+rs.getString("role_id"));
        }
    }

    public static boolean transactionTest(Connection con, String login, String newRole) {
        try {
            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO roles VALUES(DEFAULT, ?)");
            pstmt.setString(1, newRole);
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("INSERT INTO users VALUES(DEFAULT, ?, (SELECT roles.id FROM roles WHERE name = ?))");
            pstmt.setString(1, login);
            pstmt.setString(2, newRole);
            pstmt.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(ex);
            return false;
        }
    }
}
