package com.example.env107.forceoffline;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    public static final String LOGIN_OFFICE = "com.env107.broadcast.offline";

    private ForceOfflineBroadcastReceiver forceOfflineBroadcastReceiver = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BaseActivity.LOGIN_OFFICE);
        forceOfflineBroadcastReceiver = new ForceOfflineBroadcastReceiver();
        registerReceiver(forceOfflineBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(forceOfflineBroadcastReceiver!=null){
            unregisterReceiver(forceOfflineBroadcastReceiver);
        }
        forceOfflineBroadcastReceiver  = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }

    class ForceOfflineBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, Intent intent) {
            //强制下线操作
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("提示");
            builder.setMessage("你确定要下线?");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityController.finishAll();
                    Intent newIntent = new Intent(context,LoginActivity.class);
                    context.startActivity(newIntent);
                }
            });
            builder.show();
        }
    }
}
