package com.example.ugotthis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        Button btn_login = (Button) findViewById(R.id.login_btn);

        //direct to main activity
        btn_login.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });

        Button dir_register = (Button) findViewById(R.id.dir_register);

        //direct to register activity
        dir_register.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(numbersIntent);
            }
        });
    }
}
