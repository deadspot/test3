package com.newboston.test3;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by boss on 14.11.2015.
 */
public class SoundStuff extends Activity implements View.OnClickListener {

    SoundPool sp;
    int explosion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = new View(this);
        v.setOnClickListener(this);
        setContentView(v);
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
       // explosion = sp.load(this, R.raw.explosion, 1);

    }

    @Override
    public void onClick(View v) {
        //sp.play(explosion, 1, 1, 0, 0, 1);
        System.out.println("should play music");
    }
}
