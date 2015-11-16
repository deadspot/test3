package com.newboston.test3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by velievvm on 05.11.2015.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkBox", true);
        System.out.println("Music is " + music);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    Intent mainIntent = new Intent("com.newboston.test3.Menu");
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
