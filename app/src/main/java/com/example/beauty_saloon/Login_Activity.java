package com.example.beauty_saloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    EditText Loginemail , Loginpassword;
    Button Login;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Loginemail = (EditText) findViewById(R.id.LoginEmail);
        Loginpassword = (EditText) findViewById(R.id.LoginPassword);
        Login = (Button) findViewById(R.id.Login);
        dbHelper = new DbHelper(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginemail = Loginemail.getText().toString();
                String loginpassword = Loginpassword.getText().toString();

                boolean logincheck= dbHelper.Logincheck(loginemail , loginpassword);

                if (logincheck == true){
                    Intent intent = new Intent(Login_Activity.this , Home_Activity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(Login_Activity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}