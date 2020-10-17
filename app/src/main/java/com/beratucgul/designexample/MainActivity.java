package com.beratucgul.designexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button signIn, forgotPassword, dontHaveAccount, signinGoogle, signinApple;
    EditText username, password;
    EditText ForgotEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn = findViewById(R.id.signIn);
        forgotPassword = findViewById(R.id.forgotPassword);
        dontHaveAccount = findViewById(R.id.dontHaveAccount);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signinGoogle = findViewById(R.id.signinGoogle);
        signinApple = findViewById(R.id.signinApple);
    }

    public void signIn(View view) {

        Intent intent = new Intent(MainActivity.this, HomePageMain.class);
        startActivity(intent);
        finish();

    }

    public void forgotPassword(View view) {

       /* AlertDialog.Builder alert =     new AlertDialog.Builder(this);
        alert.setTitle("Forgot Password")
                .setMessage("No worries, let us help you out!");


        final EditText input = new EditText(this);
        input.setHint("Your Email");
        alert.setView(input);

        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
        alert.show();

        */


        ShowDialog();





    }

    public void dontHaveAccount(View view) {
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);
    }

    public void ShowDialog(){
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();

        LayoutInflater layoutInflater = this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.custom_dialog_layout, null);

        final EditText editText = dialogView.findViewById(R.id.ForgotEmailEditText);

        Button Continue = dialogView.findViewById(R.id.ForgotEmailContinueButton);

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);


            }
        });

        dialog.setView(dialogView);
        dialog.show();

    }


}