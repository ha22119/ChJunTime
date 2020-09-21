package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class DuringRecordActivity extends AppCompatActivity {
    TextView date, subject_name, study_place;
    Button stopButton,restartButton, resetButton;
    ImageView off_light, on_light;
    Chronometer timer;
    ConstraintLayout under_bar;
    public long timeWhenStopped = 0;
    boolean stopClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_record);

        date = findViewById(R.id.date);
        timer = findViewById(R.id.timer);
        subject_name = findViewById(R.id.subject_name);
        study_place = findViewById(R.id.study_place);
        stopButton = findViewById(R.id.stopButton);
        timer = findViewById(R.id.timer);
        restartButton = findViewById(R.id.restartButton);
        resetButton = findViewById(R.id.resetButton);
        off_light = findViewById(R.id.off_light);
        on_light = findViewById(R.id.on_light);
        under_bar = findViewById(R.id.under_bar);

        //맨 위 달력 오늘 날짜 나타내기
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
        String today = format1.format (System.currentTimeMillis());
        date.setText(today);

        Intent studyInfoIntent = getIntent();
        String studyInfo_subject = studyInfoIntent.getStringExtra("subjectName");
        String studyInfo_place = studyInfoIntent.getStringExtra("studyPlaceName");
        subject_name.setText(studyInfo_subject);
        study_place.setText(studyInfo_place);


        timer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        timer.start();
        stopClicked = false;

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer timer) {
                long time = SystemClock.elapsedRealtime() - timer.getBase();
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+ ":" +(m < 10 ? "0"+m: m)+ ":" + (s < 10 ? "0"+s: s);
                timer.setText(t);
            }
        });
        timer.setBase(SystemClock.elapsedRealtime());
        timer.setText("00:00:00");

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!stopClicked) {
                    timeWhenStopped = timer.getBase() - SystemClock.elapsedRealtime();
                    timer.stop();
                    stopClicked = true;

                    on_light.setVisibility(View.INVISIBLE);
                    stopButton.setVisibility(View.GONE);

                    off_light.setVisibility(View.VISIBLE);
                    resetButton.setVisibility(View.VISIBLE);
                    restartButton.setVisibility(View.VISIBLE);
                    under_bar.setVisibility(View.VISIBLE);

                }
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopClicked = false;
                timer.start();

                on_light.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.VISIBLE);

                off_light.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.GONE);
                restartButton.setVisibility(View.GONE);
                under_bar.setVisibility(View.GONE);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(getApplicationContext(),RecordActivity.class);
                startActivity(stopIntent);
                overridePendingTransition(0,0);
                finish();
            }
        });


    }

    // 하단바 버튼 함수
    public void todayClick(View view) {
        Intent todayIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(todayIntent);
        overridePendingTransition(0, 0);
        finish();
    }

    public void monthlyClick(View view) {
        //Intent monthlyIntent = new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(monthlyIntent);
        Toast.makeText(this, "아직 없는 액티비티", Toast.LENGTH_SHORT).show();
    }

    public void recordClick(View view) {
        Toast.makeText(this, "공부시간 측정하기", Toast.LENGTH_SHORT).show();
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
