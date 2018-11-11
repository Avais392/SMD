package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    Button followersButton,followingButton,editProfileButton, createTripButton, LogoutButton;
    TextView name, desc;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        followersButton=findViewById(R.id.viewFollowersButton);
        followingButton=findViewById(R.id.viewFollowingButton);
        editProfileButton=findViewById(R.id.editProfileButton);
        createTripButton=findViewById(R.id.createTripButton);
        LogoutButton=findViewById(R.id.LogoutButton);
        name=findViewById(R.id.nameTV);
        desc=findViewById(R.id.descTV);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.view_profile:
                startActivity(new Intent(this, profile.class));
                return true;
            case R.id.edit_profile:
                startActivity(new Intent(this, editProfile.class));
                return true;
            case R.id.view_events:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(this, homepage.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void logout(View v){
        //wipe data?
        Intent i=new Intent(this,homepage.class);
        startActivity(i);
    }

    public void followers(View v){
        //wipe data?
        Intent i=new Intent(this,FollowersAndFollowing.class);
        startActivity(i);
    }


    public void following(View v){
        //wipe data?
        Intent i=new Intent(this,FollowersAndFollowing.class);
        startActivity(i);
    }

    public void createEvent(View v){
        Intent i=new Intent(this,CreateEvent.class);
        startActivity(i);
    }

    public void editProfile(View v){
        Intent i=new Intent(this,editProfile.class);
        startActivity(i);
    }

    public void createTrip(View v){
        Intent i=new Intent(this,createTrip.class);
        startActivity(i);
    }

    //@Override
    /*protected void onResume() {
        super.onResume();
        Intent i=getIntent();
        String updatedName=i.getStringExtra("Extra_name");
        name.setText(updatedName);
        String updatedDes=i.getStringExtra("Extra_des");
        desc.setText(updatedDes);

    }*/
}
