package com.sds.study.scheduletest;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScheduleItem extends LinearLayout {
    private Schedule schedule;

    boolean isAlarmOn=false;
    ImageView alarm_img;

    public ScheduleItem(Context context, Schedule schedule) {
        super(context);
        this.schedule=schedule;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.schedule_item,this);

        TextView  item_txt_year=(TextView) this.findViewById(R.id.item_txt_year);
        TextView item_txt_month=(TextView) this.findViewById(R.id.item_txt_month);
        TextView item_txt_date=(TextView) this.findViewById(R.id.item_txt_date);
        TextView item_txt_hour=(TextView) this.findViewById(R.id.item_txt_hour);
        TextView item_txt_minute=(TextView) this.findViewById(R.id.item_txt_minute);


        item_txt_year.setText(schedule.getSc_year());
        item_txt_month.setText(schedule.getSc_month());
        item_txt_date.setText(schedule.getSc_date());
        item_txt_hour.setText(schedule.getSc_hour());
        item_txt_minute.setText(schedule.getSc_minute());
    }
}
