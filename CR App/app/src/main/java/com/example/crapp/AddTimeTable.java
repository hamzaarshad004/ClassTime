package com.example.crapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;
import android.widget.TimePicker;

public class AddTimeTable extends AppCompatActivity {

    TimePickerDialog startTimePicker;
    TimePickerDialog endTimePicker;
    EditText startTime;
    EditText endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_table);

        startTime = (EditText) this.findViewById(R.id.startTime);
        endTime = (EditText) this.findViewById(R.id.endTime);
        startTime.setInputType(InputType.TYPE_NULL);
        endTime.setInputType(InputType.TYPE_NULL);

        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                startTimePicker = new TimePickerDialog(AddTimeTable.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                startTime.setText(sHour + ":" + sMinute);

                            }
                        }, hour, minutes, true);
                startTimePicker.show();
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                endTimePicker = new TimePickerDialog(AddTimeTable.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                endTime.setText(sHour + ":" + sMinute);

                            }
                        }, hour, minutes, true);
                endTimePicker.show();
            }
        });
    }
}
