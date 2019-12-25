package com.example.crapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TimeTableAdapter extends ArrayAdapter<TimeTableItem> {
    public TimeTableAdapter(Context context, ArrayList<TimeTableItem> TimeTableItems) {
        super(context, 0, TimeTableItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TimeTableItem timeTableItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.time_table_item_cr, parent, false);
        }
        // Lookup view for data population
        TextView Time = (TextView) convertView.findViewById(R.id.lblTime);
        TextView subjectName = (TextView) convertView.findViewById(R.id.lblSubject);
        // Populate the data into the template view using the data object
        Time.setText(timeTableItem.Time);
        subjectName.setText(timeTableItem.SubjectName);
        // Return the completed view to render on screen
        return convertView;
    }
}
