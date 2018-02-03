package com.example.env107.msgdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewCache> {

    private  List<Msg> msgList = null;
    private int resourceId = 0;

    static  class ViewCache extends RecyclerView.ViewHolder {
        LinearLayout    layout_get = null,
                        layout_send = null;

        TextView get_textView = null;
        TextView send_textView = null;

        public ViewCache(View view) {
            super(view);
            get_textView = (TextView) view.findViewById(R.id.msg_get_text);
            send_textView = (TextView) view.findViewById(R.id.msg_send_text);
            layout_get = (LinearLayout) view.findViewById(R.id.msg_layout_get);
            layout_send = (LinearLayout) view.findViewById(R.id.msg_layout_send);

        }
    }

    MsgAdapter(List<Msg> msgList,int resourceId){
        this.msgList = msgList;
        this.resourceId = resourceId;
    }

    @Override
    public MsgAdapter.ViewCache onCreateViewHolder(ViewGroup parent, int viewType) {
      View view  = LayoutInflater.from(parent.getContext()).inflate(resourceId,parent,false);
      ViewCache cache = new ViewCache(view);
      return cache;
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewCache cache, int position) {
        Msg msg = msgList.get(position);
        if(msg.getType() == Msg.MSG_SNED){
            cache.layout_send.setVisibility(View.VISIBLE);
            cache.send_textView.setText(msg.getText());
        }else if(msg.getType() == Msg.MSG_GET){
            cache.layout_get.setVisibility(View.VISIBLE);
            cache.get_textView.setText(msg.getText());
        }

    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


}
