package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MonthlyActivity extends AppCompatActivity {
    TextView date;
    ImageButton backMonthButton, nextMonthButton;

    private GridAdapter gridAdapter;
    private ArrayList<String> dayList;
    private GridView calendar_space;
    private Calendar mCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);

        date= findViewById(R.id.date);
        backMonthButton= findViewById(R.id.backMonthButton);
        nextMonthButton= findViewById(R.id.nextMonthButton);
        calendar_space = findViewById(R.id.calendar_space);

        //맨 위 달력 오늘 날짜 나타내기
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM");
        String today = format1.format (System.currentTimeMillis());
        date.setText(today);

        long now = System.currentTimeMillis();
        final Date date = new Date(now);

        dayList = new ArrayList<String>();

        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);

        mCal = Calendar.getInstance();

        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1); // 이번 달 1일은 무슨 요일?

        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < dayNum; i++) { // 칸 맞추기
            dayList.add("");
        }
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);

        gridAdapter = new GridAdapter(getApplicationContext(), dayList);
        calendar_space.setAdapter(gridAdapter);
    }

    private void setCalendarDate(int month) {
        mCal.set(Calendar.MONTH, month, 1);

        for (int i = 0; i < mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayList.add("" + (i + 1));
        }
    }

    // 하단바 버튼 함수
    public void todayClick(View view) {
        Intent todayIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(todayIntent);
        finish();
//        Toast.makeText(this, "오늘의 기록 보기", Toast.LENGTH_SHORT).show();
    }

    public void monthlyClick(View view) {
//        Intent monthlyIntent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(monthlyIntent);
        Toast.makeText(this, "월별 기록 확인하기", Toast.LENGTH_SHORT).show();
    }

    public void recordClick(View view) {
        Intent recordIntent = new Intent(getApplicationContext(),RecordActivity.class);
        startActivity(recordIntent);
        overridePendingTransition(0, 0);
        finish();
    }

    public void groupClick(View view) {
        Intent groupIntent = new Intent(getApplicationContext(),GroupActivity.class);
        startActivity(groupIntent);
        overridePendingTransition(0, 0);
        finish();
    }

    public void myClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),MyInfoActivity.class);
        startActivity(myIntent);
        overridePendingTransition(0, 0);
        finish();
    }
// 하단바 버튼 함수


    class GridAdapter extends BaseAdapter {

        private ArrayList<String> daylist;
        private Context context;
        private LayoutInflater inflater;


        public GridAdapter(Context context, ArrayList<String> daylist) {
            this.daylist = daylist;
            this.context = context;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return daylist.size();

        }

        @Override
        public Object getItem(int position) {
            return daylist.get(position);

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent) {

            if (convertView == null)
                convertView = inflater.inflate(R.layout.calendar_day_layout, parent, false);

            TextView date = convertView.findViewById(R.id.day_text);

            date.setText(daylist.get(position) + "");

            return convertView;
        }
    }
}
