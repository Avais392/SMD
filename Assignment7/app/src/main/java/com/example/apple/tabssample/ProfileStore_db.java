package com.example.apple.tabssample;

public class ProfileStore_db {

    String fullname;
    String username;
    String email;
    String password;
    String description;

    ProfileStore_db(){
        fullname=null;
        username=null;
        email=null;
        password=null;
    }

    ProfileStore_db(String name, String email, String pass, String username){
        this.fullname=name;
        this.username=username;
        this.email=email;
        this.password=pass;
        if(pass==null){
            this.password="123";
        }
    }



}
