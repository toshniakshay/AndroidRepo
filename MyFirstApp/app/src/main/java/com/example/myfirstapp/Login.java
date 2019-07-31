package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button btn_submit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_submit = findViewById(R.id.btn_login);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_username.getText().toString().trim().length() == 0 && et_password.getText().toString().trim().length() == 0) {
                    Toast.makeText(Login.this, "Invalid username/password or username or password not entered", Toast.LENGTH_SHORT).show(); //Check whether edittext is Empty or not
                } else {
                    Toast toast = Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent i = new Intent(Login.this, Counter.class);
                    startActivity(i);
                }
            }
        });

    }
}
