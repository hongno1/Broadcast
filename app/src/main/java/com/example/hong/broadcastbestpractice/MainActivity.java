package com.example.hong.broadcastbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void force(View view) {
        Intent intent = new Intent("com.example.hong.broadcastbestpractice.FORCE_OFFLINE");
        sendBroadcast(intent);
    }
}
