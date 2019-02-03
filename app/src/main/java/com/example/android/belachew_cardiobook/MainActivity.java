package com.example.android.belachew_cardiobook;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Measurement> arrayList;
    MeasurementAdapter arrayAdapter;
    Measurement measurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayAdapter = new MeasurementAdapter(this, R.layout.list_item, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, EditMeasurement.class);
                // problem might be here
//                intent.putExtra(Intent_Constants.INTENT_MESSAGE_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_DATE_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_TIME_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_SYSTOLIC_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_DIASTOLIC_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_HEARTRATE_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_COMMENT_DATA, arrayList.get(position).toString());


                intent.putExtra(Intent_Constants.INTENT_ITEM_POSITION, position);
                startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE_TWO);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AddOrEdit.class);
        startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE);
    }
    String mComment;
    String mHeartRate;
    String mDiastolic;
    String mSystolic;
    String mTime;
    String mDate;
    int position;




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Intent_Constants.INTENT_REQUEST_CODE) {
            mDate = data.getStringExtra(Intent_Constants.INTENT_DATE_FIELD);
            mTime = data.getStringExtra(Intent_Constants.INTENT_TIME_FIELD);
            mSystolic = data.getStringExtra(Intent_Constants.INTENT_SYSTOLIC_FIELD);
            mDiastolic = data.getStringExtra(Intent_Constants.INTENT_DIASTOLIC_FIELD);
            mHeartRate = data.getStringExtra(Intent_Constants.INTENT_HEARTRATE_FIELD);
            mComment = data.getStringExtra(Intent_Constants.INTENT_COMMENT_FIELD);

            measurement = new Measurement(mDate, mTime, mSystolic,
                    mDiastolic, mHeartRate, mComment);
            arrayList.add(measurement);
            arrayAdapter.notifyDataSetChanged();
        }

        else if(resultCode == Intent_Constants.INTENT_REQUEST_CODE_TWO) {
            mDate = data.getStringExtra(Intent_Constants.INTENT_CHANGED_DATE);
            mTime = data.getStringExtra(Intent_Constants.INTENT_CHANGED_TIME);
            mSystolic = data.getStringExtra(Intent_Constants.INTENT_CHANGED_SYSTOLIC);
            mDiastolic = data.getStringExtra(Intent_Constants.INTENT_CHANGED_DIASTOLIC);
            mHeartRate = data.getStringExtra(Intent_Constants.INTENT_CHANGED_HEARTRATE);
            mComment = data.getStringExtra(Intent_Constants.INTENT_CHANGED_COMMENT);

            measurement = new Measurement(mDate, mTime, mSystolic,
                    mDiastolic, mHeartRate, mComment);
            position = data.getIntExtra(Intent_Constants.INTENT_ITEM_POSITION, -1);

            arrayList.remove(position);
            arrayList.add(position, measurement);
            arrayAdapter.notifyDataSetChanged();
        }

    }
}
