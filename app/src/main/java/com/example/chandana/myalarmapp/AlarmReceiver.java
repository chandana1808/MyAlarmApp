package com.example.chandana.myalarmapp;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by chandana on 07/01/16.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {

    private static Ringtone ringtone  = null;


    public static void stopRingtone() {
        ringtone.stop();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmActivity inst = AlarmActivity.instance();
        inst.setAlarmText("Wake up!!!!");
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();


    }
}
