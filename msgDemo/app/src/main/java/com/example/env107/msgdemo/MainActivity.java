package com.example.env107.msgdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView msgView = null;
    private Responser responser = new Responser();
    private MsgAdapter msgAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendButton = (Button) findViewById(R.id.send);
        msgView = findViewById(R.id.msgview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        msgView.setLayoutManager(manager);
        msgAdapter = new MsgAdapter(responser.getMsgEntity(),R.layout.layout_message);
        msgView.setAdapter(msgAdapter);
        sendButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.send:{
                EditText msgtext = (EditText) findViewById(R.id.msgtext);
                String text = msgtext.getText().toString();
                if(text.isEmpty()){
                    Toast.makeText(MainActivity.this,"请输入发送文本内容",Toast.LENGTH_SHORT).show();
                    return ;
                }else{
                    //发送消息
                    Toast.makeText(MainActivity.this,"消息发送成功",Toast.LENGTH_SHORT).show();
                    responser.post(text,new Responser.ResponerSupport(msgView,responser));
                    msgAdapter.notifyItemInserted(responser.getMsgEntity().size()-1);
                    msgView.scrollToPosition(responser.getMsgEntity().size());
                    msgtext.setText("");
                }

            }
        }
    }
}
