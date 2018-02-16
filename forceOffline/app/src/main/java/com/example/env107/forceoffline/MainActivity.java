package com.example.env107.forceoffline;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.forceButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "强制下线", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BaseActivity.LOGIN_OFFICE);
                sendBroadcast(intent);
            }
        });
    }
}
