package com.lianxi.demo7;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/12/22.
 */

public class MyBindService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("service","onCreate");
    }

    public class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("service","onBind");
        return new MyBinder();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        Log.i("service","unbindService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("service","onDestroy");

    }

    public void get(){
        Log.i("service","get");
    }
}
