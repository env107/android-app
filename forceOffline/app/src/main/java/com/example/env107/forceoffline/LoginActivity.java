package com.example.env107.forceoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "开始", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_login);
        ((Button) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ((TextView) findViewById(R.id.username)).getText().toString();
                String password = ((TextView) findViewById(R.id.password)).getText().toString();
                if(username.equals("admin") && password.equals("123456")){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));

                }else{
                    Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
