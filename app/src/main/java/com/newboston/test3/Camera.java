package com.newboston.test3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by velievvm on 12.11.2015.
 */
public class Camera extends Activity implements View.OnClickListener {

    ImageButton ib;
    Button b;
    ImageView iv;
    Bitmap bmp;
    final static int cameraData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
       /* InputStream is = getResources().openRawResource(R.drawable.splash_android);
        bmp = BitmapFactory.decodeStream(is);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibTakePic:
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;

            case R.id.bSetWall:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }

    public void initialize() {
        ib = (ImageButton) findViewById(R.id.ibTakePic);
        ib.setOnClickListener(this);

        b = (Button) findViewById(R.id.bSetWall);
        b.setOnClickListener(this);

        iv = (ImageView) findViewById(R.id.ivReturnPic);
    }

}
