package com.example.crapp;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentListTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new crTimeTableList(0);
            case 1:
                return new crTimeTableList(1);
            case 2:
                return new crTimeTableList(1);
            case 3:
                return new crTimeTableList(1);
            case 4:
                return new crTimeTableList(0);
            case 5:
                return new crTimeTableList(1);
            case 6:
                return new crTimeTableList(1);
            default:
                return new crTimeTableList(0);
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }

    public void AddFragment(Fragment fragment, String Title){
        fragmentList.add(fragment);
        fragmentListTitles.add(Title);
    }
}
