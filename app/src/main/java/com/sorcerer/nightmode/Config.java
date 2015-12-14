package com.sorcerer.nightmode;

import android.app.Application;
import android.content.SharedPreferences;

import java.security.PublicKey;

/**
 * Created by Sorcerer on 2015/12/14 0014.
 */
public class Config extends Application {
    public static SharedPreferences sPreferences;
    public static int sLaunchHour;
    public static int sLaunchMinute;
    public static int sDayHour;
    public static int sDayMinute;


    public static final String PREFERENCE_KEY = "NIGHT_MODE_KEY";
    public static final String PREFERENCE_NIGHT_HOUR_KEY = "PREFERENCE_NIGHT_HOUR_KEY";
    public static final String PREFERENCE_NIGHT_MIN_KEY = "PREFERENCE_NIGHT_MIN_KEY";
    public static final String PREFERENCE_DAY_HOUR_KEY = "PREFERENCE_DAY_HOUR_KEY";
    public static final String PREFERENCE_DAY_MINUTE_KEY = "PREFERENCE_DAY_MINUTE_KEY";

    @Override
    public void onCreate() {
        super.onCreate();

        sPreferences = getSharedPreferences(PREFERENCE_KEY, 0);
        sLaunchHour = sPreferences.getInt(PREFERENCE_NIGHT_HOUR_KEY, 23);
        sLaunchMinute = sPreferences.getInt(PREFERENCE_NIGHT_MIN_KEY, 0);
        sDayHour = sPreferences.getInt(PREFERENCE_DAY_HOUR_KEY, 6);
        sDayMinute = sPreferences.getInt(PREFERENCE_DAY_MINUTE_KEY, 30);
    }

}
