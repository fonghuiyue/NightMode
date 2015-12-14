package com.sorcerer.nightmode;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;

import java.io.IOException;
import java.util.Calendar;

public class NightService extends Service {

    private Drawable mDayPaper;

    private final BroadcastReceiver mTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.TIME_TICK")) {
                //action for sms received
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                if (hour == Config.sLaunchHour && minute == Config.sLaunchMinute) {
                    actNight();
                } else if (hour == Config.sDayHour && minute == Config.sDayMinute) {
                    actDay();
                }
            }
        }
    };

    public NightService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.TIME_TICK");

        registerReceiver(mTickReceiver, filter);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mTickReceiver);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void actNight() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        mDayPaper = wallpaperManager.getDrawable();
        try {
            wallpaperManager
                    .setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.black));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actDay() {
        if (mDayPaper != null) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
            try {
                wallpaperManager.setBitmap(((BitmapDrawable) mDayPaper).getBitmap());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
