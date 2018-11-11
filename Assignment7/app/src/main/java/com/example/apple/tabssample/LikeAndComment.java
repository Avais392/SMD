package com.example.apple.tabssample;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LikeAndComment extends AppCompatActivity {


    ListView simpleList;
    ArrayList<String> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_and_comment);

        Button comment_button = (Button) findViewById(R.id.commentButton);
        comment_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(), Comment.class);
                startActivityForResult(i, 22);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==22)
        {

            String comment =data.getStringExtra("comment");


            countryList.add(comment);

            simpleList = (ListView)findViewById(R.id.listviewComments);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.textView, countryList);
            simpleList.setAdapter(arrayAdapter);

        }
    };

}
