package com.example.apple.tabssample;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class FollowersAndFollowing extends AppCompatActivity {


    private ListView listView;
    private FollowingUsersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers_and_following);

        listView = (ListView) findViewById(R.id.FollowingFollowersList);
        ArrayList<FollowingUsers> UserList = new ArrayList<>();
        UserList.add(new FollowingUsers(R.drawable.final_image, "User1" , "Follower"));
        UserList.add(new FollowingUsers(R.drawable.images, "User2" , "Following"));
        UserList.add(new FollowingUsers(R.drawable.images, "User3" , "Following"));
        UserList.add(new FollowingUsers(R.drawable.final_image, "User4" , "Follower"));
        UserList.add(new FollowingUsers(R.drawable.final_image, "User5" , "Follower"));
        UserList.add(new FollowingUsers(R.drawable.images, "User6" , "Following"));
        UserList.add(new FollowingUsers(R.drawable.images, "User7" , "Following"));
        UserList.add(new FollowingUsers(R.drawable.images, "User8" , "Following"));

        mAdapter = new FollowingUsersAdapter(this,UserList);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent (getApplicationContext(), userprofile.class);
                startActivity(i);
            }
        } );


    }
}
