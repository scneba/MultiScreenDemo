package com.example.clasence.multiscreendemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Neba.
 */

public class DetailsHelper{
    private String name;
    private double price;
    private int id;
    public DetailsHelper(int id, String name, double price){
        this.id = id;
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
