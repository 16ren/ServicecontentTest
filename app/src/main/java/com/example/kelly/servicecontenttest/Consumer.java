package com.example.kelly.servicecontenttest;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/**
 * Created by kelly on 2014/10/23.
 */
public interface Consumer
{
    public void onServiceConnect();

    public Context getApplicationContext();

    public boolean bindService(Intent intent, ServiceConnection connection, int mode);

    public void unbindService(ServiceConnection connection);

}
