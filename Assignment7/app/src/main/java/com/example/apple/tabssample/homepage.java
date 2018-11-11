package com.example.apple.tabssample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class homepage extends AppCompatActivity {
    Button login,signup,facebook;
    public ArrayList<User_db>users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        login=findViewById(R.id.loginButton);
        facebook=findViewById(R.id.fbButton);
        signup=findViewById(R.id.emailButton);
        users=new ArrayList<User_db>();

    }

    public void loginclick(View v){
        if(v==login){
            Intent i=new Intent(this,login.class);
            startActivity(i);
        }

    }

    public void signupClick(View v){
        if(v==signup){
            Intent i=new Intent(this,signup.class);
            startActivity(i);
        }
    }


}
