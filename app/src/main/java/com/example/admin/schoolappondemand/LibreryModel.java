package com.example.admin.schoolappondemand;

import java.io.Serializable;

/**
 * Created by admin on 3/29/2017.
 */

public class LibreryModel implements Serializable {


    private String acsnno;
    private String title;
    private String subtitle;
    private String bookedition;
    private String issuedat;
    private String returndat;
    private String duedat;

    public String getAcsnno() {
        return acsnno;
    }

    public void setAcsnno(String acsnno) {
        this.acsnno = acsnno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getBookedition() {
        return bookedition;
    }

    public void setBookedition(String bookedition) {
        this.bookedition = bookedition;
    }

    public String getIssuedat() {
        return issuedat;
    }

    public void setIssuedat(String issuedat) {
        this.issuedat = issuedat;
    }

    public String getReturndat() {
        return returndat;
    }

    public void setReturndat(String returndat) {
        this.returndat = returndat;
    }

    public String getDuedat() {
        return duedat;
    }

    public void setDuedat(String duedat) {
        this.duedat = duedat;
    }
}
