package com.example.apple.tabssample;

import java.util.ArrayList;

public class User_db {

    ProfileStore_db userDetails;
    ArrayList<Trip_db>userTrips;
    ArrayList<Event_db>userEvents;
    ArrayList<ProfileStore_db>followers;
    ArrayList<ProfileStore_db>following;

    User_db(String name,String pass, String username, String email){
        userDetails=new ProfileStore_db(name,email,pass,username);
        userTrips=new ArrayList<Trip_db>();
        userEvents=new ArrayList<Event_db>();
        followers=new ArrayList<ProfileStore_db>();
        following=new ArrayList<ProfileStore_db>();
    }

    public int countPosts(){
        int tripCount=userTrips.size()-1;
        int eventCount=userEvents.size()-1;
        int sum=tripCount+eventCount;
        return 0;

    }

    public int countFollowers(){
        return followers.size()-1;
    }

    public int countFollowing(){
        return following.size()-1;
    }


}
