package com.newboston.test3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by boss on 16.11.2015.
 */
public class SQLView extends Activity {

    TextView tvSQLInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlview);

        tvSQLInfo = (TextView)findViewById(R.id.tvSQLInfo);
        HotOrNot info = new HotOrNot(this);
        try {
            info.open();
            String data = info.getData();
            tvSQLInfo.setText(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
