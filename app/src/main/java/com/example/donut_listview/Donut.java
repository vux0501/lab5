package com.example.donut_listview;

import java.io.Serializable;

public class Donut implements Serializable {
    private int donutImgId;
    private String donutName;
    private String donutDesc;
    private double donutprice;

    public Donut(int donutImgId, String donutName, String donutDesc, double donutprice) {
        this.donutImgId = donutImgId;
        this.donutName = donutName;
        this.donutDesc = donutDesc;
        this.donutprice = donutprice;
    }

    public int getDonutImgId() {
        return donutImgId;
    }

    public void setDonutImgId(int donutImgId) {
        this.donutImgId = donutImgId;
    }

    public String getDonutName() {
        return donutName;
    }

    public void setDonutName(String donutName) {
        this.donutName = donutName;
    }

    public String getDonutDesc() {
        return donutDesc;
    }

    public void setDonutDesc(String donutDesc) {
        this.donutDesc = donutDesc;
    }

    public double getDonutPrice() {
        return donutprice;
    }

    public void setDonutPrice(double donutprice) {
        this.donutprice = donutprice;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "donutImgId=" + donutImgId +
                ", donutName='" + donutName + '\'' +
                ", donutDesc='" + donutDesc + '\'' +
                ", price=" + donutprice +
                '}';
    }
}
