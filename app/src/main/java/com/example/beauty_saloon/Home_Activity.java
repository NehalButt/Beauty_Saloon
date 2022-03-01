package com.example.beauty_saloon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class Home_Activity extends AppCompatActivity {
    CardView Hairstyle,Haircolor,Spa,Makeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Hairstyle = (CardView) findViewById(R.id.Hairstyle);
        Haircolor = (CardView) findViewById(R.id.Haircolor);
        Spa = (CardView) findViewById(R.id.Spa);
        Makeup = (CardView) findViewById(R.id.Makeup);



        Hairstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, HairStyle_Activity.class);
                startActivity(intent);
            }
        });
        Haircolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Haircolor_Activity.class);
                startActivity(intent);
            }
        });
        Spa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Spa_Activity.class);
                startActivity(intent);
            }
        });
        Makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Makeup_Activity.class);
                startActivity(intent);
            }
        });

    }
}