package com.example.env107.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    private List<User> userData = new ArrayList<>();
    protected  UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listview = (ListView) findViewById(R.id.listview);
        initUser();
        adapter = new UserAdapter(ListviewActivity.this,R.layout.layout_list,userData);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                User user = userData.get(position);
                Toast.makeText(ListviewActivity.this, "你选择了 "+user.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void initUser(){
        userData.add(new User("env107"));
        userData.add(new User("哈哈哈"));
        userData.add(new User("说好的煎熬呢?","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=954763871,521695051&fm=27&gp=0.jpg"));
        userData.add(new User("煎蛋"));
        userData.add(new User("测试者"));
    }
}
