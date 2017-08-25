package de.rememberme.mascode.rememberme;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;

public class BootService extends Service {

    public boolean serviceOnline = false;
    public static final int unqineNotidicationId = 213126;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        serviceOnline = true;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                showNotificaton();
            }
        }, 0, 7200000); // 2 Stunden (Prod) = 7200000 | 30 Sekundne (Dev) = 30000
    }

    public void showNotificaton() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_logo);
        mBuilder.setWhen(System.currentTimeMillis());
        mBuilder.setTicker("Trinken ist wichtig!");
        mBuilder.setContentTitle("Trinken");
        mBuilder.setContentText("Hey, Trink mal wieder was! Am besten jetzt!");

        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(unqineNotidicationId, mBuilder.build());
        wakeScreen();
    }

    public void wakeScreen() {
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "Tag");
        wakeLock.acquire();
        wakeLock.release();
    }
}
