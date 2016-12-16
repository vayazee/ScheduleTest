package com.sds.study.scheduletest;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class ScheduleListActivity extends AppCompatActivity implements View.OnClickListener {

    CustomViewPager viewPager;
    ScheduleAdapter scheduleAdapter;
    String TAG;
    SQLiteDatabase db;
    ScheduleHelper scheduleHelper;
    Calendar c;
    EditText add_content;
    String Hour1,minute1;
    LinearLayout layout;

    TextView timeDisplay, dayNight;
    private int myHour, myMinute;
    ImageView add_alarm;
    boolean isAlarm=true;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_main);

        viewPager=(CustomViewPager)findViewById(R.id.sc_viewPager);
        add_content=(EditText)findViewById(R.id.add_content);
        TAG=this.getClass().getName();

        layout = (LinearLayout) findViewById(R.id.sc_item_layout);

        scheduleAdapter=new ScheduleAdapter(getSupportFragmentManager());
        viewPager.setAdapter(scheduleAdapter);
    }
//------------------------------------------여기부터 시간선택 뜨게하는 곳-------------------------
    public void btnClick(View view){
        switch (view.getId()){
            case R.id.back_bt:
                viewPager.setCurrentItem(0,false);
                Toast.makeText(this, "뒤로가기눌렀어", Toast.LENGTH_SHORT).show();
                break;

            case R.id.addSch_bt:
                viewPager.setCurrentItem(1,false);
                Toast.makeText(this, "버튼눌렀어", Toast.LENGTH_SHORT).show();

                getTime();

                break;

            case R.id.add_bt:
                setDTO();
                viewPager.setCurrentItem(0,false);
                break;
        }
    }

    public void onClick(View view) {

        c = Calendar.getInstance();

        switch (view.getId()) {
            //timeDisplay를 눌렀을때 TimePicker가 뜨도록 설정
            case R.id.timeDisplay:
                myHour = c.get(Calendar.HOUR_OF_DAY);
                myMinute = c.get(Calendar.MINUTE);
                Toast.makeText(ScheduleListActivity.this,
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

    public void setDTO(){
        Schedule schedule=new Schedule();
        schedule.setSc_year(2014);
        schedule.setSc_month(2);
        schedule.setSc_date(27);
        schedule.setSc_hour(1);
        schedule.setSc_minute(2);
//        schedule.setSc_content(add_content.getText().toString());

        ScheduleItem item=new ScheduleItem(this,schedule);
        layout.addView(item);
    }


    private TimePickerDialog.OnTimeSetListener myTimeSetListener
            = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String time = "Hour: " + String.valueOf(hourOfDay) + "\n"
                    + "Minute: " + String.valueOf(minute);
            Hour1=String.valueOf(hourOfDay);
            minute1=String.valueOf(minute);
            Toast.makeText(ScheduleListActivity.this, time, Toast.LENGTH_LONG).show();
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

    public void getTime(){
        timeDisplay = (TextView) findViewById(R.id.timeDisplay);
        dayNight = (TextView) findViewById(R.id.dayNight);
        add_alarm=(ImageView)findViewById(R.id.add_alarm);

        timeDisplay.setOnClickListener(this);
        add_alarm.setOnClickListener(this);
    }
//-------------------------------여기부터 db관련----------------------------------
  /*  //데이터베이스 초기화
    public void init(){
        scheduleHelper =new ScheduleHelper(this,"iot.sqlite",null,1);
        db=scheduleHelper.getWritableDatabase();
    }

    public void regist(){
        //이 앱이 보유한 sqlite 데이터베이스에 insert..
        String sql="insert into schedule(sc_year,sc_month,sc_date,sc_hour,sc_minute,sc_content)";
        sql+=" values(?,?,?,?,?,?)";

        String sc_year=Integer.toString(c.get(Calendar.YEAR));
        String sc_month=Integer.toString(c.get(Calendar.MONTH));
        String sc_date=Integer.toString(c.get(Calendar.DATE));
        String sc_content=add_content.getText().toString();
        String hour2=Hour1;
        String minute2=minute1;


        db.execSQL(sql,new String[]{sc_year,sc_month,sc_date,hour2,minute2,sc_content});

        Log.d(TAG,"등록완료");

        //Listview갱신
        //scheduleAdapter.getList();
        scheduleAdapter.notifyDataSetChanged();
    }*/
}