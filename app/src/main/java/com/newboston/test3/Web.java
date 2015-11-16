package com.newboston.test3;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by boss on 15.11.2015.
 */
public class Web extends Activity {

    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        w = (WebView)findViewById(R.id.web);
        w.loadUrl("http://www.google.com");
    }
}
