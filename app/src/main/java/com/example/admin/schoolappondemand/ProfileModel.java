package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/1/2017.
 */

public class ProfileModel implements Serializable {

    private  String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
