package com.example.crapp.ui.crTimeTable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.crapp.R;
import com.example.crapp.ViewPagerAdapter;
import com.example.crapp.crTimeTableList;
import com.google.android.material.tabs.TabLayout;

public class crTimeTable extends Fragment {

    private crTimeTableViewModel crTimeTableViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cr_time_table, container, false);
        tabLayout = (TabLayout) root.findViewById(R.id.tabLayout_Days);
        viewPager = (ViewPager) root.findViewById(R.id.viewPagerTimeTable);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}