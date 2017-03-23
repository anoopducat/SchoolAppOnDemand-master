package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/23/2017.
 */

public class NewsModel implements Serializable {

    private int nwimg;
    private  String nwsheading;
    private String nwsdt;
    private String nws;

    public int getNwimg() {
        return nwimg;
    }

    public void setNwimg(int nwimg) {
        this.nwimg = nwimg;
    }

    public String getNwsheading() {
        return nwsheading;
    }

    public void setNwsheading(String nwsheading) {
        this.nwsheading = nwsheading;
    }

    public String getNwsdt() {
        return nwsdt;
    }

    public void setNwsdt(String nwsdt) {
        this.nwsdt = nwsdt;
    }

    public String getNws() {
        return nws;
    }

    public void setNws(String nws) {
        this.nws = nws;
    }
}
