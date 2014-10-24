package com.example.kelly.servicecontenttest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;

import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconConsumer;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.RangeNotifier;
import com.radiusnetworks.ibeacon.Region;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by kelly on 2014/10/23.
 */
class MyManage
{
    private static Context context;
    private static MyManage myManage;
    private IBeaconConsumer ibconsumer;
    private MyService myService;
    private IBeaconManager ibeaconmanager  = IBeaconManager.getInstanceForApplication(ibconsumer.getApplicationContext()); ;
    public void bind(IBeaconConsumer consumer)
    {
        this.ibconsumer = consumer;
        ibeaconmanager  = IBeaconManager.getInstanceForApplication(ibconsumer.getApplicationContext());
       ibeaconmanager.bind(consumer);
    }

   public void start()
   {
       ibeaconmanager.setRangeNotifier(new RangeNotifier()
       {
           @Override
           public void didRangeBeaconsInRegion(Collection<IBeacon> iBeacons, Region region)
           {

           }
       });
       try
       {
           ibeaconmanager.startRangingBeaconsInRegion(new Region("mymonitor", "d26d197e-4a1c-44ae-b504-dd7768870564", null, null));
       } catch (RemoteException e)
       {
           e.printStackTrace();
       }
   }
}
