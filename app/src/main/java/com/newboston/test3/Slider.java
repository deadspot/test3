package com.newboston.test3;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/**
 * Created by boss on 14.11.2015.
 */
public class Slider extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SlidingDrawer.OnDrawerOpenListener {

    Button b1, b2, b3, b4;
    SlidingDrawer sd;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);

        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button4);
        b4 = (Button) findViewById(R.id.button3);
        checkBox = (CheckBox) findViewById(R.id.sbSclidable);
        sd = (SlidingDrawer) findViewById(R.id.slidingD);
        sd.setOnDrawerOpenListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                sd.open();
                break;
            case R.id.button2:

                break;
            case R.id.button4:
                sd.toggle();
                break;
            case R.id.button3:
                sd.close();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            sd.lock();
        } else {
            sd.unlock();
        }
    }

    @Override
    public void onDrawerOpened() {
        System.out.println("drawer opened");
    }
}
