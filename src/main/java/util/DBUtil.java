/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phongdm
 */
public class DBUtil {

    private static Connection connection = null;
    public static String ipConnectDB = "";
    public static String dbName = "";
    public static String user = "";
    public static String pass = "";

    public static Connection getConnection() {
        try {
            if (connection != null && connection.isValid(0)) {
                return connection;
            } else {
                dbName = new ResourceUtil().getConfigPath("nameDb");
                ipConnectDB = new ResourceUtil().getConfigPath("serverDb");
                user = new ResourceUtil().getConfigPath("accDb");
                pass = new ResourceUtil().getConfigPath("passDb");

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
                Class.forName("com.mysql.jdbc.Driver");

            }
            String url = "jdbc:mysql://" + ipConnectDB + ":3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            return null;
        } catch (Exception otherEx) {
            System.out.println(otherEx.getMessage());
            return null;
        }
        return connection;
    }
}
