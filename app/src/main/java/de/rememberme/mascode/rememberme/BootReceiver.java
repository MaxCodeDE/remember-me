package de.rememberme.mascode.rememberme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Service von Maxs App wurde gestartet! :3", Toast.LENGTH_LONG).show();
        Intent serviceIntent = new Intent(context, BootService.class);
        context.startService(serviceIntent);
    }
}
