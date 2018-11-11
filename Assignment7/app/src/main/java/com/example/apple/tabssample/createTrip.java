package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createTrip extends AppCompatActivity {
Button create;
EditText tripName, tripStartDate, tripEndDate, tripStartLocation, tripEndLocation,tripDescription;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);
        create=findViewById(R.id.createTripButton);
        tripName=findViewById(R.id.tripName);
        tripStartDate=findViewById(R.id.tripStartDate);
        tripStartLocation=findViewById(R.id.tripStartLocation);
        tripEndDate=findViewById(R.id.tripEndDate);
        tripEndLocation=findViewById(R.id.tripEndLocation);
        tripDescription=findViewById(R.id.tripDescription);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.view_profile:
                startActivity(new Intent(this, profile.class));
                return true;
            case R.id.edit_profile:
                startActivity(new Intent(this, editProfile.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(this, homepage.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void create_trip(View v){
        if(TextUtils.isEmpty(tripName.getText())){
            Toast.makeText(getApplicationContext(),"PLease enter trip name to create new post", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(tripStartLocation.getText())){
            Toast.makeText(getApplicationContext(),"PLease enter trip start location to create new post", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(tripStartDate.getText())){
            Toast.makeText(getApplicationContext(),"PLease enter trip start date to create new post", Toast.LENGTH_SHORT).show();
        }
        else{
            //add trip to db
            Intent i=new Intent(this,TripPreview.class);
            startActivity(i);

        }
    }
}
