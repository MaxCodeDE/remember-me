package de.rememberme.mascode.rememberme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Service von Maxs App wurde gestartet! :3", Toast.LENGTH_LONG).show();
        AlarmManager alarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, i, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1800000, pendingIntent);
    }
}
