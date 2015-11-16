package com.newboston.test3;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by velievvm on 05.11.2015.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "TextPlay", "Email", "Camera", "Data", "GFX", "GFXSurface",
            "Slider", "Tabs", "Web", "SQLite", "Maps"};


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutUs:
                Intent i = new Intent("com.newboston.test3.ABOUT");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent p = new Intent("com.newboston.test3.PREFS");
                startActivity(p);
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   /*     requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String activity = classes[position];
        try {
            String activityClass = "com.newboston.test3." + activity;
            Class intentClass = Class.forName(activityClass);
            System.out.println(activityClass);
            Intent chosenIntent = new Intent(Menu.this, intentClass);
            startActivity(chosenIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
