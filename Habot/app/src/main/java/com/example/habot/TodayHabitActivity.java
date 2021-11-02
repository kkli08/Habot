package com.example.habot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TodayHabitActivity extends AppCompatActivity {
    Button TodayHabitBackButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todayhabit);

        TodayHabitBackButton = findViewById(R.id.TodayHabitToMenu);

        TodayHabitBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent JumpToSignUp = new Intent();
                JumpToSignUp.setClass(TodayHabitActivity.this, MenuActivity.class);
                startActivity(JumpToSignUp);
            }
        });


    }
}
