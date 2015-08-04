
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
    /**
     * This method will return Connection object.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "");
    }

    /**
     * for get prepare statement 
     * @param sql
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        return con.prepareStatement(sql);
    }

    /**
     * to get prepare statement with return some auto generated key like those stuff
     * @param sql
     * @param n
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static PreparedStatement getPreparedStatement(String sql, int n) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();

        return con.prepareStatement(sql, n);
    }

    /**
     * this Method will insert a row to the database and return auto generated id for last inserted row
     * @param stmt
     * @return
     * @throws SQLException 
     */
    public static Long insertAndGetId(PreparedStatement stmt) throws SQLException {

        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Inserted Failed, no ID obtained.");
        }
        ResultSet generatedKeys = stmt.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        } else {
            throw new SQLException("Inserted Failed, no ID obtained.");
        }

    }

    public static void main(String[] args) throws Exception {

    }
}
