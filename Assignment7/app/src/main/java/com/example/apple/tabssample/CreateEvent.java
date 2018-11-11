package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateEvent extends AppCompatActivity {
    Button createEvent;
    EditText eventName,eventDate,eventPlace,eventInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);


    }

    public void create_event(View v){
        Intent i=new Intent(this,EventPreview.class);
        startActivity(i);
    }
}
