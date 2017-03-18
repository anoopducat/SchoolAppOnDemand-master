package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/18/2017.
 */

public class CircularModel implements Serializable {

    private String dtname;
    private String nem;
    private String description;

    public String getDtname() {
        return dtname;
    }

    public void setDtname(String dtname) {
        this.dtname = dtname;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
