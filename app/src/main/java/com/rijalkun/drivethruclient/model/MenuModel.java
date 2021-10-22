package com.rijalkun.drivethruclient.model;

import java.io.InputStream;
import java.io.Serializable;

public class MenuModel implements Serializable {
    private InputStream gambarMenu;
    private String id_menu;
    private String ld_kasir;
    private int stok;
    private int harga;
    private String nama_menu;

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    private Boolean isSelected;

    public MenuModel(InputStream gambarMenu, String id_menu, String ld_kasir, int stok, int harga, String nama_menu, Boolean isSelected) {
        this.gambarMenu = gambarMenu;
        this.id_menu = id_menu;
        this.ld_kasir = ld_kasir;
        this.stok = stok;
        this.harga = harga;
        this.nama_menu = nama_menu;
        this.isSelected = isSelected;
    }

    public InputStream getGambarMenu() {
        return gambarMenu;
    }

    public String getId_menu() {
        return id_menu;
    }

    public String getLd_kasir() {
        return ld_kasir;
    }

    public int getStok() {
        return stok;
    }

    public int getHarga() {
        return harga;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public Boolean getSelected() {
        return isSelected;
    }
}
