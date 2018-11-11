package com.example.apple.tabssample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Button publish_comment_button = (Button) findViewById(R.id.writeCommentButton);


        publish_comment_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                final EditText comment = (EditText) findViewById(R.id.writeComment);
                final String Get_comment = comment.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("comment",Get_comment);
                setResult(22,intent);
                finish();

            }
        });


    }
}
