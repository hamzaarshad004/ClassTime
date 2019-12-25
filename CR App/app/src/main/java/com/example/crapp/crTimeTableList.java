package com.example.crapp;


import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class crTimeTableList extends Fragment {

    ArrayList<TimeTableItem> Items;
    ListView listView;
    int DayCheck;

    public crTimeTableList(int DayCheck) {
        this.DayCheck = DayCheck;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cr_time_table_list, container, false);

        setItems();
        TimeTableAdapter timeTableAdapter = new TimeTableAdapter(getActivity(), Items);
        listView = (ListView) view.findViewById(R.id.crTimeTableListView);
        listView.setAdapter(timeTableAdapter);
        return view;
    }

    private void setItems(){
        if (DayCheck == 0){
            TimeTableItem timeTableItem = new TimeTableItem("09: 00 AM", "Physics");
            TimeTableItem timeTableItem1 = new TimeTableItem("10: 00 AM", "Chemistry");
            TimeTableItem timeTableItem2 = new TimeTableItem("11: 00 AM", "Maths");
            TimeTableItem timeTableItem3 = new TimeTableItem("12: 00 AM", "Books");
            TimeTableItem timeTableItem4 = new TimeTableItem("13: 00 AM", "CA");

            Items = new ArrayList<TimeTableItem>();

            Items.add(timeTableItem);
            Items.add(timeTableItem1);
            Items.add(timeTableItem2);
            Items.add(timeTableItem3);
            Items.add(timeTableItem4);
        }
        else if (DayCheck == 1){
            TimeTableItem timeTableItem = new TimeTableItem("09: 00 AM", "CV");
            TimeTableItem timeTableItem1 = new TimeTableItem("10: 00 AM", "DM");
            TimeTableItem timeTableItem2 = new TimeTableItem("11: 00 AM", "MAD");
            TimeTableItem timeTableItem3 = new TimeTableItem("12: 00 AM", "EBM");
            TimeTableItem timeTableItem4 = new TimeTableItem("13: 00 AM", "FYP");

            Items = new ArrayList<TimeTableItem>();

            Items.add(timeTableItem);
            Items.add(timeTableItem1);
            Items.add(timeTableItem2);
            Items.add(timeTableItem3);
            Items.add(timeTableItem4);
        }

    }

}
