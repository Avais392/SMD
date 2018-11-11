package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class editProfile extends AppCompatActivity {
    CheckBox showPassword;
    EditText pass,email,name,description;
    Button changeCover,saveChanges;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        showPassword=findViewById(R.id.showCB);
        pass=findViewById(R.id.passwordET);
        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(showPassword.isChecked()){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        saveChanges=findViewById(R.id.saveChangesButton);
        email=findViewById(R.id.emailET);
        name=findViewById(R.id.NameET);
        description=findViewById(R.id.descriptionET);


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

    public void saveChanges(View v){
        String getEmail=email.getText().toString();
        String getPassword=pass.getText().toString();
        String getname=name.getText().toString();
        String getDescription=description.getText().toString();
        //update db
        Intent i=new Intent(this,profile.class);
        i.putExtra("Extra_name",getname);
        i.putExtra("Extra_des",getDescription);
        startActivity(i);
    }

}
