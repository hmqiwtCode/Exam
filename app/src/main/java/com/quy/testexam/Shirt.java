package com.quy.testexam;

import java.io.Serializable;

public class Shirt implements Serializable {
    private int id;
    private int image;
    private String header;
    private Double prices;

    public Shirt(int id,int image, String header, Double prices) {
        this.id = id;
        this.image = image;
        this.header = header;
        this.prices = prices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }
}
