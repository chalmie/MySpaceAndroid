package com.epicodus.myspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView mUsernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    mUsernameTextView = (TextView) findViewById(R.id.usernameTextView);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText(username);
    }
}
