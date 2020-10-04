package com.example.mad_y2s2;

public class Water {

    private String waDate;
    private int amt;
    private int totAmt;

    public int getTotAmt() {
        return totAmt;
    }

    public void setTotAmt(int totAmt) {
        this.totAmt = totAmt;
    }

    public Water() {
    }

    public String getWaDate() {
        return waDate;
    }

    public void setWaDate(String waDate) {
        this.waDate = waDate;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }
}
