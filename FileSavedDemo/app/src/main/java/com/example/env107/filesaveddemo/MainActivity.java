package com.example.env107.filesaveddemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText contentText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentText = (EditText) findViewById(R.id.contentText);
        //读取保存文件
        String content = open("data");
        if(content != null){
            Toast.makeText(this, "读取到保存内容:"+content, Toast.LENGTH_SHORT).show();
            contentText.setText(open("data"));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //保存文本文件
        String content = contentText.getText().toString();
        if(content!=null){
            save("data",contentText.getText().toString());
            Toast.makeText(this, "文本内容已经保存!", Toast.LENGTH_SHORT).show();
        }

    }

    //保存文件
    protected  boolean save(String filename,String content){
        FileOutputStream outputStream = null;
        BufferedWriter writer = null;
        try{
            outputStream =(FileOutputStream) openFileOutput(filename, Context.MODE_PRIVATE);
            writer  = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(content);

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return true;
    }

    //读取文件
    protected String open(String filename){
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder content = new StringBuilder();
        try{
            String line = null;
            inputStream =  openFileInput(filename);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while((line = bufferedReader.readLine())!=null){
                content.append(line);
            }
            return content.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
