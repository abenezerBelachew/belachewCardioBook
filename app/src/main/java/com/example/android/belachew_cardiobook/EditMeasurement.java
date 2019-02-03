package com.example.android.belachew_cardiobook;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditMeasurement extends AppCompatActivity {
    Measurement measurement;
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_or_edit);
        Intent intent = getIntent();

        String mDate = intent.getStringExtra(Intent_Constants.INTENT_DATE_FIELD);
        String mTime = intent.getStringExtra(Intent_Constants.INTENT_TIME_FIELD);
        String mSystolic = intent.getStringExtra(Intent_Constants.INTENT_SYSTOLIC_FIELD);
        String mDiastolic = intent.getStringExtra(Intent_Constants.INTENT_DIASTOLIC_FIELD);
        String mHeartRate = intent.getStringExtra(Intent_Constants.INTENT_HEARTRATE_FIELD);
        String mComment = intent.getStringExtra(Intent_Constants.INTENT_COMMENT_FIELD);

        measurement = new Measurement(mDate, mTime, mSystolic,
                mDiastolic, mHeartRate, mComment);

        position = intent.getIntExtra(Intent_Constants.INTENT_ITEM_POSITION, -1);

        Button m2Date = (Button) findViewById(R.id.date_measured);
        Button m2Time = ((Button) findViewById(R.id.time_measured));
        EditText m2SystolicPressure = (EditText) findViewById(R.id.systolic_pressure_measured);
        EditText m2DiastolicPressure = (EditText) findViewById(R.id.diastolic_pressure_measured);
        EditText m2HeartRate = (EditText) findViewById(R.id.heart_rate_measured);
        EditText m2Comment = (EditText) findViewById(R.id.comment_written);

        m2Date.setText(mDate);
        m2Time.setText(mTime);
        m2SystolicPressure.setText(mSystolic);
        m2DiastolicPressure.setText(mDiastolic);
        m2HeartRate.setText(mHeartRate);
        m2Comment.setText(mComment);

    }

    public void saveButtonClick(View v) {
        String changedDate = ((Button) findViewById(R.id.date_measured)).getText().toString();
        String changedTime = ((Button) findViewById(R.id.time_measured)).getText().toString();
        String changedSystolicPressure = ((EditText) findViewById(R.id.systolic_pressure_measured)).getText().toString();
        String changedDiastolicPressure = ((EditText) findViewById(R.id.diastolic_pressure_measured)).getText().toString();
        String changedHeartRate = ((EditText) findViewById(R.id.heart_rate_measured)).getText().toString();
        String changedComment = ((EditText) findViewById(R.id.comment_written)).getText().toString();

        Intent intent = new Intent();
        intent.putExtra(Intent_Constants.INTENT_CHANGED_DATE, changedDate);
        intent.putExtra(Intent_Constants.INTENT_CHANGED_TIME, changedTime);
        intent.putExtra(Intent_Constants.INTENT_CHANGED_SYSTOLIC, changedSystolicPressure);
        intent.putExtra(Intent_Constants.INTENT_CHANGED_DIASTOLIC, changedDiastolicPressure);
        intent.putExtra(Intent_Constants.INTENT_CHANGED_HEARTRATE, changedHeartRate);
        intent.putExtra(Intent_Constants.INTENT_CHANGED_COMMENT, changedComment);

        intent.putExtra(Intent_Constants.INTENT_ITEM_POSITION, position);
        setResult(Intent_Constants.INTENT_RESULT_CODE_TWO, intent);
        finish();
    }
}
