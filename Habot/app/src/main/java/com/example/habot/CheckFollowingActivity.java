package com.example.habot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckFollowingActivity extends AppCompatActivity {
    Button TodayHabitBackButton;
    Button FollowersPendingButton;
    ListView userFollowing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.following);
        Bundle bundle = getIntent().getExtras();
        String Username = bundle.getString("UserName");
        Log.d("TAG", "----------------> Username is :"+Username);
        TodayHabitBackButton = findViewById(R.id.back_buttom);
        FollowersPendingButton = findViewById(R.id.request_button);
        userFollowing = findViewById(R.id.userFollowing);
        TodayHabitBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Jump = new Intent();
                Jump.setClass(CheckFollowingActivity.this, MenuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserName", Username);
                Jump.putExtras(bundle);
                startActivity(Jump);
            }
        });

        FollowersPendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent JumpToRequest = new Intent();
                JumpToRequest.setClass(CheckFollowingActivity.this,CheckRequestNameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserName", Username);
                JumpToRequest.putExtras(bundle);
                startActivity(JumpToRequest);
            }
        });

        userFollowing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
            }
        });

    }
}
