package com.example.lenovo.assignment;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

public class Alarm extends WakefulBroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent)
    {

        Fragment1 inst = Fragment1.instance();
        inst.setAlarmText("Alarm Time is up");


        Uri alarmuri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmuri == null)
        {
            alarmuri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        }
        Ringtone ringtone = RingtoneManager.getRingtone(context,alarmuri);
        ringtone.play();




    }
}
