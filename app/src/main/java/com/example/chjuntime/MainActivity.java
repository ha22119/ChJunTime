package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    TextView date,time_record_text;
    ListView today_record_list;
    View timePieces[] = new View[144];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        time_record_text = findViewById(R.id.time_record_text);
        today_record_list = findViewById(R.id.today_record_list);

        //맨 위 달력 오늘 날짜 나타내기
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
        String today = format1.format (System.currentTimeMillis());
        date.setText(today);

        // 왼쪽 테이블 findViewById 하는 긴 코드 don't touch
        int count=-1, i = 0, j = 0;
        for (i=0;i<24;i++){
            for(j = 1;j<7;j++){
                String hour = "";
                int min = j;

                switch (i){
                    case 0:
                        hour = "zero";
                        break;
                    case 1:
                        hour = "one";
                        break;
                    case 2:
                        hour = "two";
                        break;
                    case 3:
                        hour = "three";
                        break;
                    case 4:
                        hour = "four";
                        break;
                    case 5:
                        hour = "five";
                        break;
                    case 6:
                        hour = "six";
                        break;
                    case 7:
                        hour = "seven";
                        break;
                    case 8:
                        hour = "eight";
                        break;
                    case 9:
                        hour = "nine";
                        break;
                    case 10:
                        hour = "ten";
                        break;
                    case 11:
                        hour = "eleven";
                        break;
                    case 12:
                        hour = "twelve";
                        break;
                    case 13:
                        hour = "thirteen";
                        break;
                    case 14:
                        hour = "fourteen";
                        break;
                    case 15:
                        hour = "fifteen";
                        break;
                    case 16:
                        hour = "sixteen";
                        break;
                    case 17:
                        hour = "seventeen";
                        break;
                    case 18:
                        hour = "eighteen";
                        break;
                    case 19:
                        hour = "nineteen";
                        break;
                    case 20:
                        hour = "twenty";
                        break;
                    case 21:
                        hour = "twentyOne";
                        break;
                    case 22:
                        hour = "twentyTwo";
                        break;
                    case 23:
                        hour = "twentyThree";
                        break;
                }
                count++;
                int index = getResources().getIdentifier(hour+"_"+min, "id", getPackageName());
                timePieces[count] = findViewById(index);

                //timePieces[count].setBackgroundResource(R.drawable.high_light_background); // 확인용 코드
            }
        }

        //해야할것
        //1. 오늘 한 공부 총 시간 db에서 받아서 time_record_text에 넣기
        //2. 오늘 한 공부 내용 받아서 타임테이블 옆에 ListView에 띄우기
        //3. db에서 공부한 시각 구하고 타임테이블에 그 시간에 맞게 BackgroundSource 바꾸기

    }

// 하단바 버튼 함수
    public void todayClick(View view) {
//        Intent todayIntent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(todayIntent);
        Toast.makeText(this, "오늘의 기록 보기", Toast.LENGTH_SHORT).show();
    }

    public void monthlyClick(View view) {
        Intent monthlyIntent = new Intent(getApplicationContext(),MonthlyActivity.class);
        startActivity(monthlyIntent);
//        Toast.makeText(this, "아직 없는 액티비티", Toast.LENGTH_SHORT).show();
    }

    public void recordClick(View view) {
        Intent recordIntent = new Intent(getApplicationContext(),RecordActivity.class);
        startActivity(recordIntent);
        overridePendingTransition(0, 0);
    }

    public void groupClick(View view) {
        Intent groupIntent = new Intent(getApplicationContext(),GroupActivity.class);
        startActivity(groupIntent);
        overridePendingTransition(0, 0);
    }

    public void myClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),MyInfoActivity.class);
        startActivity(myIntent);
        overridePendingTransition(0, 0);
    }
// 하단바 버튼 함수

}
