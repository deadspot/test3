package com.newboston.test3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by velievvm on 13.11.2015.
 */
public class GFX extends Activity {

    MyBringBack ourView;
    PowerManager.WakeLock wl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "tag");

        super.onCreate(savedInstanceState);
        wl.acquire();
        ourView = new MyBringBack(this);
        setContentView(ourView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wl.release();
        System.out.println("release");
    }

    @Override
    protected void onResume() {
        super.onResume();
        wl.acquire();
        System.out.println("acquire");
    }
}
