package com.example.hong.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    //将广播注册到这个activity中去
    private ForceOfflineReceiver forceOfflineReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }


    //activity生命周期  在栈顶可以显示页面
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.hong.broadcastbestpractice.FORCE_OFFLINE");
        forceOfflineReceiver = new ForceOfflineReceiver();
        registerReceiver(forceOfflineReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (forceOfflineReceiver != null){
            unregisterReceiver(forceOfflineReceiver);
        }
    }

    private class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            //
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning...")
                    .setMessage("You are forcing the application")
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCollector.finishAll();
                            Intent intent1 = new Intent(context, LoginActivity.class);
                            startActivity(intent1);
                        }
                    });
            builder.show();
        }
    }
}
