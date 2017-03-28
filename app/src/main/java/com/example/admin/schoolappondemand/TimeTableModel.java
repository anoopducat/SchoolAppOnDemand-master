package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/28/2017.
 */

public class TimeTableModel implements Serializable {

    private String ttday;
    private String ttperiod;
    private String ttsubct;

    public String getTtday() {
        return ttday;
    }

    public void setTtday(String ttday) {
        this.ttday = ttday;
    }

    public String getTtperiod() {
        return ttperiod;
    }

    public void setTtperiod(String ttperiod) {
        this.ttperiod = ttperiod;
    }

    public String getTtsubct() {
        return ttsubct;
    }

    public void setTtsubct(String ttsubct) {
        this.ttsubct = ttsubct;
    }
}
