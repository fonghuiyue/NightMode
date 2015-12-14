package com.sorcerer.nightmode;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

/**
 * Created by Sorcerer on 2015/12/14 0014.
 */
public class LaunchReceiver extends BroadcastReceiver {

    Intent mIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
//        mIntent = new Intent(context, NightService.class);
//
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.set(Calendar.HOUR_OF_DAY, Config.sLaunchHour); // For 1 PM or 2 PM
//        calendar.set(Calendar.MINUTE, Config.sLaunchMin);
//        calendar.set(Calendar.SECOND, 0);
//        PendingIntent pi = PendingIntent.getService(context, 0,
//                new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                y                  hgbfghnbm,hgbn 67ygbn 7yuhgjnmb AlarmManager.INTERVAL_DAY, pi);
//
//        context.startService(mIntent);
        mIntent = new Intent(context, MainActivity.class);
        context.startActivity(mIntent);
    }
}
