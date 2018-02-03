package com.example.env107.msgdemo;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;



public class Responser{


    private List<Msg> msgList = new ArrayList<>();

    //消息回复
    public boolean reply(String text){
        if(text.isEmpty()) return false;
        msgList.add(new Msg(text,Msg.MSG_GET));
        return true;
    }
    //消息发送
    public boolean post(String text){
        if(text.isEmpty()) return false;
        msgList.add(new Msg(text,Msg.MSG_SNED));
        return true;
    }

    public boolean post(String text,ResponerSupport responerSupport){
        boolean rs = this.post(text);
        responerSupport.match(text);
        return rs;
    }

    public List<Msg> getMsgEntity(){
        return msgList;
    }


    //简单应答机器人
    static class ResponerSupport{
        private MsgAdapter adapter = null;
        private Responser responser = null;
        private RecyclerView msgView = null;
        ResponerSupport(RecyclerView msgView,Responser responer){
            this.adapter = (MsgAdapter) msgView.getAdapter();
            this.responser = responer;
            this.msgView = msgView;
        }

        private void match(String text){
            Handler handler = new Handler();
            final String matchText = text;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    if(matchText.toLowerCase().equals("hello")){
                        responser.reply("Hello ^_^!");
                    }else{
                        responser.reply("what's your name??");
                    }
                    adapter.notifyItemInserted(responser.getMsgEntity().size()-1);
                    msgView.scrollToPosition(responser.getMsgEntity().size());
                }
            };
            //延迟1.5秒应答
            handler.postDelayed(run,1500);

        }
    }

}

interface onPostText extends EventListener{
    void onPost();
}


