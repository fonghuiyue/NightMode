package com.sorcerer.nightmode;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, NightService.class);
        startService(intent);
        Toast.makeText(this, "night mode start", Toast.LENGTH_SHORT);

        this.finish();
    }

    private void setAlarm() {
        Calendar time = Calendar.getInstance();

        Intent intent = new Intent(MainActivity.this, NightService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        time.setTimeInMillis(System.currentTimeMillis());
        time.set(Calendar.HOUR_OF_DAY, Config.sLaunchHour);
        time.set(Calendar.MINUTE, Config.sLaunchMinute);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent);

    }
}
