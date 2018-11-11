package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class userprofile extends AppCompatActivity {

    CheckBox follow;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        follow=findViewById(R.id.checkBox);

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

    public void checkFollowing(View v){
        if(follow.isChecked()){
            follow.setText("Following");
            //add to follow list
        }
        else{
            follow.setText("Follow");
            //remove from following list
        }
    }
}
