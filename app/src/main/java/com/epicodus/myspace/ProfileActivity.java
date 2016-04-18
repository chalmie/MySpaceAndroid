package com.epicodus.myspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private TextView mUsernameTextView;
    private ListView mFriendListListView;
    private EditText mNewFriendEditText;
    private Button mSubmitNewFriendButton;
    private ArrayList<String> mFriends = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, mFriends);
        mFriendListListView.setAdapter(adapter);
        mNewFriendEditText = (EditText) findViewById(R.id.newFriendEditText);
        mSubmitNewFriendButton = (Button) findViewById(R.id.submitNewFriendButton);
        mFriendListListView = (ListView) findViewById(R.id.friendListListView);


        mSubmitNewFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String friend = mNewFriendEditText.getText().toString();
                mFriends.add(friend);
                adapter.notifyDataSetChanged();
                mNewFriendEditText.setText("");
            }
        });


    mUsernameTextView = (TextView) findViewById(R.id.usernameTextView);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText(username);
    }

}
