package com.example.taotoon.model;

import java.io.Serializable;

public class Manga implements Serializable {
    private int maMG;
    private String tenMG;
    private int hinhMG;

    public Manga() {
    }

    public Manga(int maMG, String tenMG, int hinhMG) {
        this.maMG = maMG;
        this.tenMG = tenMG;
        this.hinhMG = hinhMG;
    }

    public int getMaMG() {
        return maMG;
    }

    public void setMaMG(int maMG) {
        this.maMG = maMG;
    }

    public String getTenMG() {
        return tenMG;
    }

    public void setTenMG(String tenMG) {
        this.tenMG = tenMG;
    }

    public int getHinhMG() {
        return hinhMG;
    }

    public void setHinhMG(int hinhMG) {
        this.hinhMG = hinhMG;
    }
}
