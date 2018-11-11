package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity implements SignupView{

    EditText fullname,username,email,password;
    Button register,login;
    String getname,getmail,getpass,getusername;
    private SignupPresenter presenter;
    protected void onCreate(Bundle savedInstancestate){

        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_signup);
        fullname=findViewById(R.id.fullnameET);
        email=findViewById(R.id.EmailET);
        password=findViewById(R.id.usernameET);
        username=findViewById(R.id.usernameET);
        login=findViewById(R.id.redirectLogin);
        register=findViewById(R.id.SignupButton);

        getname=fullname.getText().toString();
        getmail=email.getText().toString();
        getpass=password.getText().toString();
        getusername=username.getText().toString();

        User_db user=new User_db(getname,getpass,getusername,getmail);
        presenter = new SignupPresenter(this, new SignupInteractor());


    }

    public void redirectLogin(View v){
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }

    public void signup(View v){
        if(TextUtils.isEmpty(fullname.getText())){
            Toast.makeText(getApplicationContext(), "please enter full name to create account", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email.getText())){
            Toast.makeText(getApplicationContext(),"Please enter email to create account",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(username.getText())){
            Toast.makeText(getApplicationContext(),"Please enter username to create account",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password.getText())){
            Toast.makeText(getApplicationContext(),"Please enter password to create account",Toast.LENGTH_SHORT).show();
        }
        else{
            //create account
            Intent i=new Intent(this,profile.class);
            startActivity(i);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
//        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

//        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {

        username.setError("Username Error");
    }

    @Override
    public void setFullnameError() {

        fullname.setError("Fullname Error");
    }

    @Override
    public void setEmailError() {

        email.setError("Email Error");
    }

    @Override
    public void setPasswordError() {

        password.setError("Password Error");
    }

    @Override
    public void navigateToHome() {
        Intent i=new Intent(this,profile.class);
        startActivity(i);
        finish();
    }

    public void validateCredentials(View v) {
        presenter.validateCredentials(fullname.getText().toString(),email.getText().toString(),username.getText().toString(), password.getText().toString());
    }
}
