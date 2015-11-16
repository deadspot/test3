package com.newboston.test3;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by velievvm on 13.11.2015.
 */
public class Prefs extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
