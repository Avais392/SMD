package com.example.apple.smdapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void constraintLayout(View view) {
        Intent intent = new Intent(this, SignupConstraint.class);
        startActivity(intent);
    }
    public void relativeLayout(View view) {
        Intent intent = new Intent(this, SignupRelative.class);
        startActivity(intent);
    }
}
