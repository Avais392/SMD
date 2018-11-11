package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity implements LoginView {
    Button login, forgot_password, signup;
    EditText email, password;
    private LoginPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.LoginButton);
        forgot_password = findViewById(R.id.forgot_passwordButton);
        signup = findViewById(R.id.redirectSignup);
        email = findViewById(R.id.emailET);
        password = findViewById(R.id.usernameET);
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        String username = "avais";
//        DatabaseReference myRef = database.getReference("avais");
//        myRef.setValue("pass");
        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    public void login(View v) {
        if (TextUtils.isEmpty(email.getText())) {
            Toast.makeText(getApplicationContext(), "Please enter email or username to log in", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password.getText())) {
            Toast.makeText(getApplicationContext(), "Please enter valid password to log in", Toast.LENGTH_LONG).show();
        } else {
            //check valid password and email
            //else
            //take to main screen
            Intent i = new Intent(this, PostActivity.class);
            startActivity(i);
        }
    }

    public void forgotPassword(View v) {
        Intent i = new Intent(this, forgotPassword.class);
        startActivity(i);
    }

    public void createAccount(View v) {
        Intent i = new Intent(this, signup.class);
        startActivity(i);
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

        email.setError("Username Error");
    }

    @Override
    public void setPasswordError() {

        password.setError("Password Error");
    }

    @Override
    public void navigateToHome() {
        Intent i = new Intent(this, PostActivity.class);
        startActivity(i);
        finish();
    }

    public void validateCredentials(View v) {
        presenter.validateCredentials(email.getText().toString(), password.getText().toString());
    }
}
