package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotPassword extends AppCompatActivity {
    EditText email;
    Button recoveryButton;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        recoveryButton=findViewById(R.id.recoveryButton);
        email=findViewById(R.id.recoveryEmailET);
    }




    public void recoveryClick(View v){
        if(TextUtils.isEmpty(email.getText())){
            Toast.makeText(getApplicationContext(),"Email/username must be entered!",Toast.LENGTH_SHORT).show();
        }
        else{
            //fetch from db send email
        }
    }
}
