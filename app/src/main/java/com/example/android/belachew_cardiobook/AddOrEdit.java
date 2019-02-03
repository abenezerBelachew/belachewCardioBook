package com.example.android.belachew_cardiobook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class AddOrEdit extends AppCompatActivity {

    private Button mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_or_edit);

        mDisplayDate = (Button) findViewById(R.id.date_measured);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddOrEdit.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: yyyy-mm-dd: " + year + "-" + month + "-" + day);

                String monthString = Integer.toString(month);
                String date = year + "-" + String.format("%2d",month) + "-" + day;
                mDisplayDate.setText(date);

            }
        };

        /* DATE UI ends here */

    }

    public void saveButtonClick(View v) {
        String mDate = ((Button) findViewById(R.id.date_measured)).getText().toString();
        String mTime = ((Button) findViewById(R.id.time_measured)).getText().toString();
        String mSystolicPressure = ((EditText) findViewById(R.id.systolic_pressure_measured)).getText().toString();
        String mDiastolicPressure = ((EditText) findViewById(R.id.diastolic_pressure_measured)).getText().toString();
        String mHeartRate = ((EditText) findViewById(R.id.heart_rate_measured)).getText().toString();
        String mComment = ((EditText) findViewById(R.id.comment_written)).getText().toString();

        Measurement measurement = new Measurement(mDate, mTime, mSystolicPressure,
                mDiastolicPressure, mHeartRate, mComment);

          // Check for validity here and if the validifier is true send the intent
        Intent intent = new Intent();
        intent.putExtra(Intent_Constants.INTENT_DATE_FIELD, measurement.getDate());
        intent.putExtra(Intent_Constants.INTENT_TIME_FIELD, measurement.getTime());
        intent.putExtra(Intent_Constants.INTENT_SYSTOLIC_FIELD, measurement.getSystolicPressure());
        intent.putExtra(Intent_Constants.INTENT_DIASTOLIC_FIELD, measurement.getDiastolicPressure());
        intent.putExtra(Intent_Constants.INTENT_HEARTRATE_FIELD, measurement.getHeartRate());
        intent.putExtra(Intent_Constants.INTENT_COMMENT_FIELD, measurement.getComment());

        setResult(Intent_Constants.INTENT_RESULT_CODE, intent);
        finish();
    }

}
