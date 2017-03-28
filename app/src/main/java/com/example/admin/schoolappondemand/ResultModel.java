package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/28/2017.
 */

public class ResultModel implements Serializable {

    private String grpnm;
    private String subnem;
    private String obtnd;
    private String fll;


    public String getGrpnm() {
        return grpnm;
    }

    public void setGrpnm(String grpnm) {
        this.grpnm = grpnm;
    }

    public String getSubnem() {
        return subnem;
    }

    public void setSubnem(String subnem) {
        this.subnem = subnem;
    }

    public String getObtnd() {
        return obtnd;
    }

    public void setObtnd(String obtnd) {
        this.obtnd = obtnd;
    }

    public String getFll() {
        return fll;
    }

    public void setFll(String fll) {
        this.fll = fll;
    }
}
