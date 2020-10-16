package com.beratucgul.designexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

public class SignUp extends AppCompatActivity {

    Button dontHaveAccount, signUp, goToSignIn;
    EditText fullName, email, mobile, password;
    PopupWindow popupWindow;
    boolean click = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dontHaveAccount = findViewById(R.id.dontHaveAccount);
        signUp = findViewById(R.id.signUp);
        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        goToSignIn = findViewById(R.id.goToSignIn);


    }

    public void continueWithGuest(View view) {
    }

    public void signUp(View view) {
    }

    public void goToSignIn(View view) {
        Intent intent = new Intent(SignUp.this, MainActivity.class);
        startActivity(intent);
    }
}