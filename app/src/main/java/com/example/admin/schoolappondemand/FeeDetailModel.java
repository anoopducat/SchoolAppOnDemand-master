package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/9/2017.
 */

public class FeeDetailModel implements Serializable {

    private String feetype;
    private String feetotal;
    private String feepaid;
    private String feedue;
    private String feedate;

    public String getFeetype() {
        return feetype;
    }

    public void setFeetype(String feetype) {
        this.feetype = feetype;
    }

    public String getFeetotal() {
        return feetotal;
    }

    public void setFeetotal(String feetotal) {
        this.feetotal = feetotal;
    }

    public String getFeepaid() {
        return feepaid;
    }

    public void setFeepaid(String feepaid) {
        this.feepaid = feepaid;
    }

    public String getFeedue() {
        return feedue;
    }

    public void setFeedue(String feedue) {
        this.feedue = feedue;
    }

    public String getFeedate() {
        return feedate;
    }

    public void setFeedate(String feedate) {
        this.feedate = feedate;
    }
}
