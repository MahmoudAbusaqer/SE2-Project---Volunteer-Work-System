/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class DBConnection {

    private static Connection connection = null;

    private DBConnection() {
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vws?serverTimezone=UTC",
                        "root", "123456");
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            return connection;
        }
    }
}
