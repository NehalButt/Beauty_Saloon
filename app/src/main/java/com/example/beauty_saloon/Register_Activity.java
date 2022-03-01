package com.example.beauty_saloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {
    TextView gotologin;
    EditText Name , Email , Password;
    Button Register;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText) findViewById(R.id.Name);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        gotologin = (TextView) findViewById(R.id.gotologin);
        Register = (Button) findViewById(R.id.Register);
        dbHelper = new DbHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                boolean emailcheck = dbHelper.Emailcheck(email);
                if (emailcheck == true){
                    Email.requestFocus();
                    Email.setError("Email Already Exists");
                }
                else {
                    dbHelper.Registertableinsert(name, email, password);
                    Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                    Toast.makeText(Register_Activity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Activity.this , Login_Activity.class);
                startActivity(intent);
            }
        });
    }
}