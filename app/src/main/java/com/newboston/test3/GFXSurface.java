package com.newboston.test3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by boss on 14.11.2015.
 */
public class GFXSurface extends Activity implements View.OnTouchListener {

    MySurface mySurface;
    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mySurface = new MySurface(this);
        mySurface.setOnTouchListener(this);
        x = 0;
        y = 0;
        setContentView(mySurface);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mySurface.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mySurface.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return true;
    }




    public class MySurface extends SurfaceView implements Runnable {

        SurfaceHolder holder;
        Thread thread = null;
        boolean isRunning = false;

        public MySurface(Context context) {
            super(context);
            holder = getHolder();
        }

        public void pause() {
            isRunning = false;
            while (true) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            thread = null;
        }

        public void resume() {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            while (isRunning) {
                if (!holder.getSurface().isValid()) {
                    continue;
                }
                Canvas canvas = holder.lockCanvas();
                canvas.drawRGB(02, 02, 150);
                if(x!=0 && y!=0){
                    Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.green_ball);
                    canvas.drawBitmap(b, x - b.getWidth() / 2 , y- b.getHeight() / 2 , null);
                }
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
