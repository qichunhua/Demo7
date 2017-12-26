package com.lianxi.demo7;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//ggg
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1,bt2,bt3,bt4,bt5;
    private Intent intent1,intent2;
    MyBindService myBindService;
    ServiceConnection serviceConnection = new ServiceConnection() {
        //当启动源跟Service成功连接后将会自动调用这个方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBindService = ((MyBindService.MyBinder)service).getService();
        }

        //当启动源跟Service的连接意外丢失的时候会调用这个方法，比如当Service崩溃了，或者被强行杀死了
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                intent1 = new Intent(ServiceActivity.this,MyStartService.class);
                startService(intent1);
                break;
            case R.id.bt2:
                stopService(intent1);
                break;
            case R.id.bt3:
                intent2 = new Intent(ServiceActivity.this,MyBindService.class);
                bindService(intent2,serviceConnection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.bt4:
                myBindService.get();
                break;
            case R.id.bt5:
                unbindService(serviceConnection);
                break;
        }
    }
}
