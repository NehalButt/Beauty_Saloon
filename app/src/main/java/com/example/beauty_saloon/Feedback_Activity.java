package com.example.beauty_saloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class Feedback_Activity extends AppCompatActivity {
    EditText feedback;
    TextView feedbackname;
    RatingBar ratingBar;
    Button sendfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedback = (EditText) findViewById(R.id.feedback);
        feedbackname = (TextView) findViewById(R.id.rating);
        sendfeedback = (Button) findViewById(R.id.sendfeedback);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);



        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (v == 0){
                    feedbackname.setText("Very Dissatisfied");
                }
                else if(v == 1){
                    feedbackname.setText("Dissatisfied");
                }
                else if(v == 2 || v == 3){
                    feedbackname.setText("Ok");
                }
                else if(v == 4){
                    feedbackname.setText("Satisfied");
                }
                else {
                    feedbackname.setText("Very Satisfied");
                }
            }
        });
    sendfeedback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Feedback_Activity.this , Home_Activity.class);
            startActivity(intent);
            finish();
        }
    });
    }
}