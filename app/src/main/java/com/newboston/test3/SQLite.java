package com.newboston.test3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by boss on 16.11.2015.
 */
public class SQLite extends Activity implements View.OnClickListener {

    Button bUpdate, bView;
    TextView tvName, tvHot;
    EditText etName, etHot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);

        bUpdate = (Button) findViewById(R.id.bUpdate);
        bView = (Button) findViewById(R.id.bView);
        bUpdate.setOnClickListener(this);
        bView.setOnClickListener(this);

        tvName = (TextView) findViewById(R.id.tvName);
        tvHot = (TextView) findViewById(R.id.tvHot);

        etName = (EditText) findViewById(R.id.etName);
        etHot = (EditText) findViewById(R.id.etHot);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bUpdate:
                boolean done = true;
                try {
                    String name = etName.getText().toString();
                    String hot = etHot.getText().toString();
                    HotOrNot entry = new HotOrNot(this);
                    entry.open();
                    entry.createEntry(name, hot);
                    entry.close();
                }catch (Exception e){
                    done = false;
                    Dialog d = new Dialog(this);
                    d.setTitle("Dang");
                    TextView tv = new TextView(this);
                    tv.setText(e.getMessage());
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if(done){
                        Dialog d = new Dialog(this);
                        d.setTitle("Yeas");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }

                break;
            case R.id.bView:
                Intent i = new Intent("com.newboston.test3.SQLVIEW");
                startActivity(i);
                break;
        }
    }
}
