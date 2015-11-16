package com.newboston.test3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by velievvm on 12.11.2015.
 */
public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread;
    String setData;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bReturn:
                Intent person = new Intent();
                Bundle backpack = new Bundle();
                backpack.putString("answer", setData);
                person.putExtras(backpack);
                setResult(RESULT_OK, person);
                finish();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et = pref.getString("name", "Travis is ...");
        String values = pref.getString("list", "4");
        if(values.contentEquals("1")){
            question.setText(et);
        }

    }

    private void initialize() {
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvText);
        returnData = (Button) findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rCrazy:
                setData = "right!";
                break;
            case R.id.rSexy:
                setData = "difenetly!";
                break;
            case R.id.rBoth:
                setData = "Spot On!";
                break;
        }
        test.setText(setData);
    }
}
