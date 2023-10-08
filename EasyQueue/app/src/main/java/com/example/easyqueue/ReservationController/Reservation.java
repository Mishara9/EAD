package com.example.easyqueue.ReservationController;

import java.io.Serializable;

public class Reservation implements Serializable {
    private String Tid, Tname,Tnic,Train,Platform,Date,Time,Destination;

    public Reservation(){

    }

    public Reservation(String tid, String tname, String tnic, String train, String platform, String date, String time, String destination) {
        Tid = tid;
        Tname=tname;
        Tnic=tnic;
        Train = train;
        Platform = platform;
        Date = date;
        Time = time;
        Destination = destination;
    }

    public String getTid() {
        return Tid;
    }

    public void setTid(String tid) {
        Tid = tid;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTnic() {
        return Tnic;
    }

    public void setTnic(String tnic) {
        Tnic = tnic;
    }

    public String getTrain() {
        return Train;
    }

    public void setTrain(String train) {
        Train = train;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date =date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

}
