package com.example.hong.broadcastbestpractice;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends BaseActivity {

    private EditText et_account;
    private EditText et_password;
    private Button btn_login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_account = findViewById(R.id.et_acc);
        et_password = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();

                if (account.equals("admin")  && password.equals("123456")){
                    Toast.makeText(getApplicationContext(),"账号 密码正确",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
//                    finish();
                } else {
                    et_account.setText("");
                    et_password.setText("");
                    Toast.makeText(getApplicationContext(),"账号 用户名非法！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
