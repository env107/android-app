package com.example.env107.newsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/2/15.
 */

public class NewsContentFrag extends Fragment {

    private View view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view =  inflater.inflate(R.layout.news_content_frag,container,false);
         return view;
    }
    //刷新数据
    public void refresh(String title,String content){
        View news_content_layout = view.findViewById(R.id.news_content_layout);
        news_content_layout.setVisibility(View.VISIBLE);
        TextView news_title_text = (TextView) view.findViewById(R.id.news_title_text);
        TextView news_content_text = (TextView) view.findViewById(R.id.news_content_text);
        news_title_text.setText(title);
        news_content_text.setText(content);
    }
}
