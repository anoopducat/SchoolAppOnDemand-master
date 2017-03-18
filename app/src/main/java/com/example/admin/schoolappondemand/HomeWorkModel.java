package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/6/2017.
 */

public class HomeWorkModel implements Serializable {

    private String hDate;
    private String hday;
    private int image;
    private String hlesson;
    private String hchapter;
    private String tchr;

    public String getTchr() {
        return tchr;
    }

    public void setTchr(String tchr) {
        this.tchr = tchr;
    }

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    public String getHday() {
        return hday;
    }

    public void setHday(String hday) {
        this.hday = hday;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHlesson() {
        return hlesson;
    }

    public void setHlesson(String hlesson) {
        this.hlesson = hlesson;
    }

    public String getHchapter() {
        return hchapter;
    }

    public void setHchapter(String hchapter) {
        this.hchapter = hchapter;
    }
}
