package com.sds.study.scheduletest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ScheduleAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments = new Fragment[2];
    Context context;

    String TAG;
    ArrayList<Schedule> sheduleList = new ArrayList<Schedule>();

    public ScheduleAdapter(FragmentManager fm) {
        super(fm);
        fragments[0] = new ScheduleFragment();
        fragments[1] = new AddScheduleFragment();

        ScheduleListActivity scheduleListActivity = (ScheduleListActivity) context;


    }


    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }


}
