package com.newboston.test3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by velievvm on 12.11.2015.
 */
public class TextPlay extends Activity implements View.OnClickListener {

    Button chkCmd;
    ToggleButton passTog;
    EditText input;
    TextView display;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.text);

        createView();

        chkCmd.setOnClickListener(this);
        passTog.setOnClickListener(this);
    }

    private void createView() {
        chkCmd = (Button) findViewById(R.id.bResults);
        passTog = (ToggleButton) findViewById(R.id.toggleButton);
        input = (EditText) findViewById(R.id.etCommands);
        display = (TextView) findViewById(R.id.tvResults);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bResults:
                String check = input.getText().toString();
                if (check.contentEquals("left")) {
                    display.setGravity(Gravity.LEFT);
                } else if (check.contentEquals("right")) {
                    display.setGravity(Gravity.RIGHT);
                } else if (check.contentEquals("centr")) {
                    display.setGravity(Gravity.CENTER);
                } else if (check.contentEquals("blue")) {
                    display.setTextColor(Color.BLUE);
                }
                break;

            case R.id.toggleButton:
                if (passTog.isChecked()) {
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;

            case R.id.tvResults:

                break;
        }
    }
}
