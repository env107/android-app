package com.example.env107.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button1)).setOnClickListener(this);
        ((Button)findViewById(R.id.button2)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:{
                startActivity(
                        new Intent(MainActivity.this,ListviewActivity.class)
                );
                break;
            }

            case R.id.button2:{
                startActivity(
                        new Intent(MainActivity.this, RecyclerViewActivity.class)
                );
                break;
            }
        }
    }
}
