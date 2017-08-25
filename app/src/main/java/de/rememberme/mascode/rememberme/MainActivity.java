package de.rememberme.mascode.rememberme;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("APP", "START");
    }


    public void checkService(View view) {
        Context context = getApplicationContext();
        if (isMyServiceRunning(BootService.class)) {
            Toast.makeText(context, "Sercice läuft bereits!", Toast.LENGTH_LONG).show();
        } else {
            Intent serviceIntent = new Intent(context, BootService.class);
            context.startService(serviceIntent);
            Toast.makeText(context, "Service wurde manuell gestartet!", Toast.LENGTH_LONG).show();
        }
    }

    // Prüft ob Serive bereits läuft
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
