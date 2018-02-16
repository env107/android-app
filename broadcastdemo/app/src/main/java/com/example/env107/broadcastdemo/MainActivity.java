package com.example.env107.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LocalBroadcastManager localBroadcastManager = null;
    private localBroadcastReceiver localBroadcastReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastReceiver = new localBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.env107.broadcast.localBroadcast");
        localBroadcastManager.registerReceiver(localBroadcastReceiver,intentFilter);
        Button send_local_receiver = findViewById(R.id.send_local_receiver);
        send_local_receiver.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
    }



    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.send_local_receiver:{
                Toast.makeText(this,"已发送广播",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.env107.broadcast.localBroadcast");
                intent.putExtra("query","name=env107&age=20&cid=1150");
                localBroadcastManager.sendBroadcast(intent);
                break;
            }
        }
    }

    class localBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String querystring = intent.getStringExtra("query");
            Toast.makeText(context,"接收到查询字符串:"+querystring,Toast.LENGTH_SHORT).show();
        }
    }
}
