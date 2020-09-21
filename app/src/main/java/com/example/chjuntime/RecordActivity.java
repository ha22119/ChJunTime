package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

public class RecordActivity extends AppCompatActivity {
    TextView date, subject_name, study_place,timer;
    EditText subject_editText, studyPlace_editText;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        date = findViewById(R.id.date);
        timer = findViewById(R.id.timer);
        subject_name = findViewById(R.id.subject_name);
        study_place = findViewById(R.id.study_place);
        subject_editText = findViewById(R.id.subject_editText);
        studyPlace_editText = findViewById(R.id.studyPlace_editText);
        startButton = findViewById(R.id.startButton);

        //맨 위 달력 오늘 날짜 나타내기
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
        String today = format1.format (System.currentTimeMillis());
        date.setText(today);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recordStartIntent = new Intent(getApplicationContext(),DuringRecordActivity.class);
                String subjectName = subject_editText.getText().toString();
                String studyPlaceName = studyPlace_editText.getText().toString();
                recordStartIntent.putExtra("subjectName",subjectName);
                recordStartIntent.putExtra("studyPlaceName",studyPlaceName);
                subject_name.setText(subjectName);
                study_place.setText(studyPlaceName);
                startActivity(recordStartIntent);
                overridePendingTransition(0, 0);
                finish();
            }
        });

    }
    // 하단바 버튼 함수
    public void todayClick(View view) {
        Intent todayIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(todayIntent);
        overridePendingTransition(0,0);
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
        overridePendingTransition(0,0);
        finish();
    }

    public void myClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),MyInfoActivity.class);
        startActivity(myIntent);
        overridePendingTransition(0,0);
        finish();
    }
    // 하단바 버튼 함수
}
