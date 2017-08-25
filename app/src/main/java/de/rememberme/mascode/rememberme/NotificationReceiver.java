package de.rememberme.mascode.rememberme;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    public static final int unqineNotidicationId = 213126;
    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "Notification Receiver wird ausgeführt!", Toast.LENGTH_LONG).show();
        showNotificaton(context);
    }

    public void showNotificaton(Context context) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.drawable.ic_logo);
        mBuilder.setWhen(System.currentTimeMillis());
        mBuilder.setTicker("Trinken ist wichtig!");
        mBuilder.setContentTitle("Trinken");
        mBuilder.setContentText("Hey, Trink mal wieder was! Am besten jetzt!");

        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(unqineNotidicationId, mBuilder.build());

    }
}


