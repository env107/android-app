package com.example.env107.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {

    private List<User> userData = new ArrayList<>();
    protected  UserViewAdapter adapter,adapter2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initUser();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        adapter = new UserViewAdapter(userData,R.layout.layout_list);
        LinearLayoutManager manager = new LinearLayoutManager(RecyclerViewActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycleView2);
        adapter2 = new UserViewAdapter(userData,R.layout.layout_horiz_list);
        LinearLayoutManager manager2 = new LinearLayoutManager(RecyclerViewActivity.this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(manager2);
        recyclerView2.setAdapter(adapter2);
    }

    void initUser(){
        userData.add(new User("env107"));
        userData.add(new User("哈哈哈"));
        userData.add(new User("说好的煎熬呢?","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=954763871,521695051&fm=27&gp=0.jpg"));
        userData.add(new User("煎蛋"));
        userData.add(new User("测试者"));
    }

}
