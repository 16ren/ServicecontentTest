package com.example.kelly.servicecontenttest;

import android.util.Log;

import com.radiusnetworks.ibeacon.IBeaconManager;

/**
 * Created by kelly on 2014/10/23.
 */
public class TestMyManage extends ApplicationTest
{
    public void testIsNull() throws Exception
    {
        MyManage myManage = MyManage.getInstance(getContext());
        assertNotNull("myManage is null",myManage);
    }

}
