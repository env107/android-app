package com.example.env107.listview;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.ViewCache>{

    private List<User> userList ;
    private int resid = 0;



    static class ViewCache extends RecyclerView.ViewHolder{
        View view;
        ImageView img;
        TextView title;
        //装载每一个item
        public ViewCache(View itemView) {
            super(itemView);
            view = itemView;
            img = (ImageView) itemView.findViewById(R.id.img);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public ViewCache onCreateViewHolder(final ViewGroup parent, int viewType) {
        //视图填充器
        View view = LayoutInflater.from(parent.getContext()).inflate(resid,parent,false);
        //放进去缓存
        final ViewCache cache = new ViewCache(view);
        cache.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取视图位置
                int position = cache.getAdapterPosition();
                User user = userList.get(position);
                Toast.makeText(v.getContext(),"选择用户:"+user.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        cache.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = cache.getAdapterPosition();
                User user = userList.get(position);
                Toast.makeText(v.getContext(),"图片地址:"+user.getImg(),Toast.LENGTH_SHORT).show();
            }
        });
        return cache;
    }

    @Override
    public void onBindViewHolder(ViewCache cache, int position) {
        //返回的holder设置每一项的值
        User user = userList.get(position);
        if(user.getImg()!=null){
            cache.img.setImageURI(Uri.parse(user.getImg()));
        }else{
            cache.img.setImageResource(R.drawable.ic_launcher_foreground);
        }
        cache.title.setText(user.getTitle());
    }



    @Override
    public int getItemCount() {
        return userList.size();
    }

    public UserViewAdapter(List<User> data,int resourceid) {
        super();
        userList = data;
        resid = resourceid;
    }


}


