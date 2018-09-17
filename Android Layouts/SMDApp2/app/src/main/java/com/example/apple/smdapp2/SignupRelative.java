package com.example.apple.smdapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignupRelative extends AppCompatActivity {


    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;
    private CheckBox termsAndConditionsCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_relative);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        termsAndConditionsCheckbox=(CheckBox)findViewById(R.id.terms);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText email=(EditText)findViewById(R.id.signupEmail);
                EditText password=(EditText)findViewById(R.id.signupPassword);

                if(email.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0){
                    Toast.makeText(SignupRelative.this,
                            "Empty Feild Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if(!isEmailValid(email.getText().toString()))
                    {
                        Toast.makeText(SignupRelative.this,
                                "Invalid Email Format", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(SignupRelative.this,
                        "Email: "+
                                email.getText()+"\nPassword: "+password.getText()+"\nGender: "+radioSexButton.getText() + "\nTerms & Conditions: "+(termsAndConditionsCheckbox.isChecked()?"Checked":"Not Checked"), Toast.LENGTH_SHORT).show();

            }

        });
    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
