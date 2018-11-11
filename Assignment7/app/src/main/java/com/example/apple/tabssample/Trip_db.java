package com.example.apple.tabssample;

import java.util.Date;

public class Trip_db {
    String tripName,tripDescription,startLocation,endLocation;
    Date startDate,endDate;

    Trip_db(String name, String desc, String start, Date startD){
        this.tripName=name;
        this.tripDescription=desc;
        this.startLocation=start;
        this.startDate=startD;

    }

    Trip_db(String name, String desc, String start, Date startD, String end, Date endD){
        this.tripName=name;
        this.tripDescription=desc;
        this.startLocation=start;
        this.startDate=startD;
        this.endDate=endD;
        this.endLocation=end;
    }
}
