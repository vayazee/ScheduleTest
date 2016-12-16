package com.sds.study.scheduletest;

import android.app.Dialog;
import android.app.TimePickerDialog;

import java.util.Calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TimePicker timePicker;
    TextView timeDisplay, dayNight;
    private int myHour, myMinute;
    ImageView add_alarm;
    boolean isAlarm=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

        timeDisplay = (TextView) findViewById(R.id.timeDisplay);
        dayNight = (TextView) findViewById(R.id.dayNight);
        add_alarm=(ImageView)findViewById(R.id.add_alarm);

        timeDisplay.setOnClickListener(this);
        add_alarm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        final Calendar c = Calendar.getInstance();

        switch (view.getId()) {
            //timeDisplay를 눌렀을때 TimePicker가 뜨도록 설정
            case R.id.timeDisplay:
                myHour = c.get(Calendar.HOUR_OF_DAY);
                myMinute = c.get(Calendar.MINUTE);
                Toast.makeText(MainActivity.this,
                        "- onCreateDialog(ID_TIMEPICKER) -", Toast.LENGTH_LONG)
                        .show();
                Dialog dlgTime = new TimePickerDialog(this, myTimeSetListener,
                        myHour, myMinute, false);
                dlgTime.show();
                break;

            default:
                break;

            case R.id.add_alarm:
                if(isAlarm==true) {
                    isAlarm=false;
                    add_alarm.setImageResource(R.drawable.alarm_off);
                }else{
                    isAlarm=true;
                    add_alarm.setImageResource(R.drawable.alarm);
                }
        }

    }

    //이곳에서 시간이 넘어온다
    private TimePickerDialog.OnTimeSetListener myTimeSetListener
            = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String time = "Hour: " + String.valueOf(hourOfDay) + "\n"
                    + "Minute: " + String.valueOf(minute);
            Toast.makeText(MainActivity.this, time, Toast.LENGTH_LONG).show();
            if (hourOfDay <12) {
                timeDisplay.setText(hourOfDay + ":" + minute);
                dayNight.setText("am");
            }else if(hourOfDay==12){
                timeDisplay.setText(hourOfDay+ ":" + minute);
                dayNight.setText("pm");
            }else if(hourOfDay>12){
                timeDisplay.setText(hourOfDay-12 + ":" + minute);
                dayNight.setText("pm");
            }
        }
    };
}
