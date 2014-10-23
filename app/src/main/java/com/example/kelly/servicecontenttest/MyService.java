package com.example.kelly.servicecontenttest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    public MyService()
    {
    }

    public int getnum()
    {
        return 3;
    }
    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO: Return the communication channel to the service.
        Log.d("MyService", "return");
        return new MyBind();
    }

    public class MyBind extends Binder
    {
        public MyService getMyService()
        {
            return MyService.this;
        }
    }
}
