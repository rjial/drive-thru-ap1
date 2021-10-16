package com.rijalkun.drivethruclient.model;

import java.io.InputStream;
import java.io.Serializable;

public class MinumanModel implements Serializable {
    private InputStream gambarMenu;
    private String id_menu;
    private String ld_kasir;
    private int stok;
    private int harga;
    private String nama_minuman;

    public MinumanModel(InputStream gambarMenu, String id_menu, String ld_kasir, int stok, int harga, String nama_minuman) {
        this.gambarMenu = gambarMenu;
        this.id_menu = id_menu;
        this.ld_kasir = ld_kasir;
        this.stok = stok;
        this.harga = harga;
        this.nama_minuman = nama_minuman;
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

    public String getNama_minuman() {
        return nama_minuman;
    }

    public int getHarga() {
        return harga;
    }
}
