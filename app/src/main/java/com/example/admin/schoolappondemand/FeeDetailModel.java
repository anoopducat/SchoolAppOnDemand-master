package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 4/1/2017.
 */

public class FeeDetailModel implements Serializable {

    private String recept;
    private String fedepe;
    private String tofe;
    private String fine;
    private String consesn;
    private String hostalcha;
    private String netfe;
    private String pefe;
    private String blfe;
    private String pementtype;

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }

    public String getFedepe() {
        return fedepe;
    }

    public void setFedepe(String fedepe) {
        this.fedepe = fedepe;
    }

    public String getTofe() {
        return tofe;
    }

    public void setTofe(String tofe) {
        this.tofe = tofe;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getConsesn() {
        return consesn;
    }

    public void setConsesn(String consesn) {
        this.consesn = consesn;
    }

    public String getHostalcha() {
        return hostalcha;
    }

    public void setHostalcha(String hostalcha) {
        this.hostalcha = hostalcha;
    }

    public String getNetfe() {
        return netfe;
    }

    public void setNetfe(String netfe) {
        this.netfe = netfe;
    }

    public String getPefe() {
        return pefe;
    }

    public void setPefe(String pefe) {
        this.pefe = pefe;
    }

    public String getBlfe() {
        return blfe;
    }

    public void setBlfe(String blfe) {
        this.blfe = blfe;
    }

    public String getPementtype() {
        return pementtype;
    }

    public void setPementtype(String pementtype) {
        this.pementtype = pementtype;
    }
}
