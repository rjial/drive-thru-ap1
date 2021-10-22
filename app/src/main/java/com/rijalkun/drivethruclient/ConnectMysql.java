package com.rijalkun.drivethruclient;

import android.util.Log;

//import com.mysql.cj.jdbc.Driver;
import com.rijalkun.drivethruclient.model.MakananModel;
import com.rijalkun.drivethruclient.model.MenuModel;
import com.rijalkun.drivethruclient.model.MinumanModel;

//import org.mariadb.jdbc.Driver;

//import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectMysql {
//    private Connection connection = null;

    public ResultSet getResult(String sql) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ResultSet resultSet = null;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2/kasir_db", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeQuery();
//        return resultSet;
    }
    public List<MenuModel> getMakanan() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<MenuModel> list = new ArrayList<>();
        String sql = "SELECT * FROM MENU inner join MAKANAN on MAKANAN.ID_MENU = MENU.ID_MENU";
        ResultSet resultSet = getResult(sql);
//        System.out.println(resultSet);
        while (true) {
                if (!resultSet.next()) break;
                list.add(new MenuModel(resultSet.getBinaryStream("GAMBAR_MENU"), resultSet.getString("ID_MENU"), resultSet.getString("LD_KASIR"), resultSet.getInt("STOCK"), resultSet.getInt("HARGA"), resultSet.getString("NAMA_MAKANAN"), false));
//                Log.d("MYSQL", resultSet.getString("NAMA_MAKANAN"));
        }
//        Log.d("TASK MYSQL", "success");
        return list;
    }
    public List<MenuModel> getMinuman() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<MenuModel> list = new ArrayList<>();
        String sql = "SELECT * FROM MENU inner join MINUMAN on MINUMAN.ID_MENU = MENU.ID_MENU";
        ResultSet resultSet = getResult(sql);
        while (true) {
            if (!resultSet.next()) break;
            list.add(new MenuModel(resultSet.getBinaryStream("GAMBAR_MENU"), resultSet.getString("ID_MENU"), resultSet.getString("LD_KASIR"), resultSet.getInt("STOCK"), resultSet.getInt("HARGA"), resultSet.getString("NAMA_MINUMAN"), false));
//            Log.d("MYSQL", resultSet.getString("NAMA_MINUMAN"));
        }
//        Log.d("TASK MYSQL", "success");
        return list;
    }
}
