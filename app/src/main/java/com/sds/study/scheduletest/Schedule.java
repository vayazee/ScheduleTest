package com.sds.study.scheduletest;

/**
 * Created by student on 2016-12-13.
 */

public class Schedule {
    private int schedule_id;
    private int baby_id;
    private int mom_id;
    private int sc_year;
    private int sc_month;
    private int sc_date;    //몇일
    private int sc_hour;
    private int sc_minute;
    private String sc_content;

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getBaby_id() {
        return baby_id;
    }

    public void setBaby_id(int baby_id) {
        this.baby_id = baby_id;
    }

    public int getMom_id() {
        return mom_id;
    }

    public void setMom_id(int mom_id) {
        this.mom_id = mom_id;
    }

    public int getSc_year() {
        return sc_year;
    }

    public void setSc_year(int sc_year) {
        this.sc_year = sc_year;
    }

    public int getSc_month() {
        return sc_month;
    }

    public void setSc_month(int sc_month) {
        this.sc_month = sc_month;
    }

    public int getSc_date() {
        return sc_date;
    }

    public void setSc_date(int sc_date) {
        this.sc_date = sc_date;
    }

    public String getSc_content() {
        return sc_content;
    }

    public void setSc_content(String sc_content) {
        this.sc_content = sc_content;
    }

    public int getSc_hour() {
        return sc_hour;
    }

    public void setSc_hour(int sc_hour) {
        this.sc_hour = sc_hour;
    }

    public int getSc_minute() {
        return sc_minute;
    }

    public void setSc_minute(int sc_minute) {
        this.sc_minute = sc_minute;
    }
}
