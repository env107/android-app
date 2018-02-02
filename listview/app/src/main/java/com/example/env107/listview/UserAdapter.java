package com.example.env107.listview;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
public class UserAdapter extends ArrayAdapter<User> {
    private int resourceid = 0;
    public UserAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<User> objects) {
        super(context, textViewResourceId, objects);
        resourceid = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        View view;
        ViewCache cache;
        //判断视图是否已经缓存
        if(convertView == null){
            cache = new ViewCache();
            view = LayoutInflater.from(getContext()).inflate(resourceid,parent,false);
            cache.img = (ImageView) view.findViewById(R.id.img);
            cache.title = (TextView) view.findViewById(R.id.title);
            view.setTag(cache);
        }else{
            view = convertView;
            cache = (ViewCache) view.getTag();
        }
        if(user.getImg() == null){
            cache.img.setImageResource(R.drawable.ic_launcher_background);
        }else{
            cache.img.setImageURI(Uri.parse(user.getImg()));
        }

        cache.title.setText(user.getTitle());

        return view;
    }
}
//视图缓存
class ViewCache {
    ImageView img;
    TextView title;
}
