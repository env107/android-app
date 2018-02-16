package com.example.env107.newsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NewsTitleFrag extends Fragment {

    private View view = null;

    private boolean isTwoPane = false;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_frag)!=null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view =inflater.inflate(R.layout.news_list,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_list_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        NewsTitleListAdapter newsTitleListAdapter = new NewsTitleListAdapter(getNews());
        recyclerView.setAdapter(newsTitleListAdapter);
        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("新闻标题1","新闻内容1"));
        newsList.add(new News("新闻标题2","新闻内容2"));
        newsList.add(new News("新闻标题3","新闻内容3"));
        newsList.add(new News("新闻标题4","新闻内容4"));
        newsList.add(new News("新闻标题5","新闻内容5"));
        newsList.add(new News("新闻标题6","新闻内容6"));
        newsList.add(new News("新闻标题7","新闻内容7"));
        newsList.add(new News("新闻标题8","新闻内容8"));
        newsList.add(new News("新闻标题9","新闻内容9"));
        newsList.add(new News("新闻标题10","新闻内容10"));
        return newsList;
    }

    /*适配器*/
    class NewsTitleListAdapter extends RecyclerView.Adapter<NewsTitleListAdapter.ViewHolder>{

        private List newsList = null;
        NewsTitleListAdapter(List<News> newsList){
            this.newsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.news_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = (News) newsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        //双页面模式点击处理
                        NewsContentFrag frag = (NewsContentFrag) getFragmentManager().findFragmentById(R.id.news_content_frag);
                        frag.refresh(news.getTitle(),news.getContent());
                    }else{
                        //单页面模式点击处理
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            Log.i("env107","viewType="+viewType);
            return holder;
        }



        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //填充数据
            News news = (News) newsList.get(position);
            holder.textView.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView textView = null;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.news_item_title);

            }
        }
    }
}
