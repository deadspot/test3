package com.newboston.test3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by boss on 15.11.2015.
 */
public class Tabs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        TabHost th = (TabHost) findViewById(R.id.tabHost);
        th.setup();
        TabHost.TabSpec ts1 = th.newTabSpec("tag1");
        ts1.setContent(R.id.tab1);
        ts1.setIndicator("StopWatch");
        th.addTab(ts1);
        TabHost.TabSpec ts2 = th.newTabSpec("tag2");
        ts2.setContent(R.id.tab2);
        ts2.setIndicator("Tab 2");
        th.addTab(ts2);
        TabHost.TabSpec ts3 = th.newTabSpec("tag3");
        ts3.setContent(R.id.tab3);
        ts3.setIndicator("Add a Tab");
        th.addTab(ts3);
    }
}
