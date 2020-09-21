package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MonthlyActivity extends AppCompatActivity {
    TextView date;
    ImageButton backMonthButton, nextMonthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);

        date= findViewById(R.id.date);
        backMonthButton= findViewById(R.id.backMonthButton);
        nextMonthButton= findViewById(R.id.nextMonthButton);

        //맨 위 달력 오늘 날짜 나타내기
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM");
        String today = format1.format (System.currentTimeMillis());
        date.setText(today);
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
}
