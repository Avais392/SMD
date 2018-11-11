package com.example.apple.tabssample;

import java.util.Date;

public class Event_db {

    String name,location,information;
    Date eventDate;

    Event_db(String name, String location, String info, Date date){
        this.name=name;
        this.eventDate=date;
        this.location=location;
        this.information=info;
    }
}
