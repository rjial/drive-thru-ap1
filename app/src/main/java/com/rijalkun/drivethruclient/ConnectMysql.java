package com.rijalkun.drivethruclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMysql {
    private Connection connection = null;
    public ConnectMysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc://localhost/drive_thru", "root", "");
    }
    public ResultSet getResult(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
