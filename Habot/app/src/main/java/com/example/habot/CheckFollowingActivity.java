package com.example.habot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity will check doers that user is following.
 */
public class CheckFollowingActivity extends AppCompatActivity {
    // initialize variables
    Button TodayHabitBackButton;
    Button FollowersPendingButton;
    ListView userFollowing;

    /**
     * Action after this activity is created.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.following);
        // set values to variables
        Bundle bundle = getIntent().getExtras();
        String Username = bundle.getString("UserName");
        Log.d("TAG", "----------------> Username is :"+Username);
        // connect layout file with view id
        TodayHabitBackButton = findViewById(R.id.back_buttom);
        FollowersPendingButton = findViewById(R.id.request_button);
        userFollowing = findViewById(R.id.userFollowing);
        TodayHabitBackButton.setOnClickListener(new View.OnClickListener() {
            /**
             * When back button on the top left of the screen is clicked, jump back to main menu page.
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent Jump = new Intent();
                // jump from check following activity to menu activity
                Jump.setClass(CheckFollowingActivity.this, MenuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserName", Username);
                Jump.putExtras(bundle);
                // initiate the jump
                startActivity(Jump);
            }
        });

        FollowersPendingButton.setOnClickListener(new View.OnClickListener() {
            /**
             * When followers pending button is clicked, jump to pending list activity.
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent JumpToRequest = new Intent();
                // jump from check follower activity to pending list activity
                JumpToRequest.setClass(CheckFollowingActivity.this,CheckRequestNameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserName", Username);
                JumpToRequest.putExtras(bundle);
                // initiate the jump
                startActivity(JumpToRequest);
            }
        });

        userFollowing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Check doer who is following user
             * @param adapterView
             * @param view
             * @param i
             * @param l
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
            }
        });

    }
}
