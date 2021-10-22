package com.rijalkun.drivethruclient.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.rijalkun.drivethruclient.ConnectMysql;
import com.rijalkun.drivethruclient.model.MakananModel;
import com.rijalkun.drivethruclient.model.MenuModel;
import com.rijalkun.drivethruclient.model.MinumanModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private Connection connection;
    private ConnectMysql connectMysql = null;

    public MenuRepository() {
        if (connectMysql == null) {
            this.connectMysql = new ConnectMysql();
        }
    }

    public MutableLiveData<List<MenuModel>> getMakananList() {
        List<MenuModel> list = new ArrayList<>();
        MutableLiveData<List<MenuModel>> data = new MutableLiveData<>();
        try {
            data.setValue(connectMysql.getMakanan());
        } catch (SQLException throwables) {
            data.postValue(null);
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
    public MutableLiveData<List<MenuModel>> getMinumanList() {
        List<MenuModel> list = new ArrayList<>();
        MutableLiveData<List<MenuModel>> data = new MutableLiveData<>();
        try {
            data.setValue(connectMysql.getMinuman());
        } catch (SQLException throwables) {
            data.postValue(null);
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
