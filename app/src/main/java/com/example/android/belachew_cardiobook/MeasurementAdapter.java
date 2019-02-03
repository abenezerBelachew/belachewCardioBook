package com.example.android.belachew_cardiobook;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;


class MeasurementAdapter extends ArrayAdapter<Measurement> {

    private static final String TAG = "MeasurementsAdapter";

    private Context mContext;
    int mResource;

    /**
     * Default constructor for the MeasurementsAdapter
     * @param context
     * @param resource
     * @param objects
     * */
    public MeasurementAdapter(Context context, int resource, ArrayList<Measurement> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the persons information
        UUID ID = getItem(position).getID();
        String date = getItem(position).getDate();
        String time = getItem(position).getTime();
        String systolicPressure = getItem(position).getSystolicPressure();
        String diastolicPressure = getItem(position).getDiastolicPressure();
        String heartRate = getItem(position).getHeartRate();
        String comment = getItem(position).getComment();

        // Create the Measurement object with the information
        Measurement measurement = new Measurement(date, time, systolicPressure, diastolicPressure, heartRate, comment);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvDate = (TextView) convertView.findViewById(R.id.date_text_view);
        TextView tvSystolicPressure = (TextView) convertView.findViewById(R.id.systolic_text_view);
        TextView tvDiastolicPressure = (TextView) convertView.findViewById(R.id.diastolic_text_view);
        TextView tvHeartRate = (TextView) convertView.findViewById(R.id.heart_rate_text_view);

        tvDate.setText(date);
        tvSystolicPressure.setText(systolicPressure);
        tvDiastolicPressure.setText(diastolicPressure);
        tvHeartRate.setText(heartRate);




        return convertView;

    }


}
