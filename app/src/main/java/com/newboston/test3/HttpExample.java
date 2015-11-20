package com.newboston.test3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by velievvm on 20.11.2015.
 */
public class HttpExample extends Activity {
    TextView txHttp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_example);
        txHttp = (TextView)findViewById(R.id.tvHttp);

    }
}
