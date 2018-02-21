package com.example.env107.forceoffline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends BaseActivity {

    private TextView usernameTextview = null;
    private TextView passwordTextview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "开始", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_login);
        CheckBox remberPasswordCheckbox = (CheckBox) findViewById(R.id.remberPasswordCheckbox);
        usernameTextview = ((TextView) findViewById(R.id.username));
        passwordTextview = ((TextView) findViewById(R.id.password));
        remberPasswordActionLoader();
        boolean isRember = remberPasswordCheckbox.isChecked();
        ((Button) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTextview.getText().toString();
                String password = passwordTextview.getText().toString();
                if(username.equals("admin") && password.equals("123456")){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    remberPasswordActionSaved();
                }else{
                    Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void remberPasswordActionLoader(){
        SharedPreferences preferences = getSharedPreferences("remberPwd", MODE_PRIVATE);
        String username = preferences.getString("username","null");
        String password = preferences.getString("password","null");
        usernameTextview.setText(username);
        passwordTextview.setText(password);
    }

    protected void remberPasswordActionSaved(){
        SharedPreferences preferences = getSharedPreferences("remberPwd", MODE_PRIVATE);
        String username = usernameTextview.getText().toString();
        String password = passwordTextview.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();
    }

}
