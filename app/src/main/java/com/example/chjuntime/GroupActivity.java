package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class GroupActivity extends AppCompatActivity {
    ImageButton groupPlusButton;
    ListView group_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        groupPlusButton = findViewById(R.id.groupPlusButton);
        group_list = findViewById(R.id.group_list);

        groupPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createGroupIntent = new Intent(getApplicationContext(),CreateGroupActivity.class);
                startActivity(createGroupIntent);
                overridePendingTransition(0,0);
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
        Intent recordIntent = new Intent(getApplicationContext(),RecordActivity.class);
        startActivity(recordIntent);
        overridePendingTransition(0,0);
        finish();
    }

    public void groupClick(View view) {
        Toast.makeText(this, "스터디 그룹 보기", Toast.LENGTH_SHORT).show();

    }

    public void myClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),MyInfoActivity.class);
        startActivity(myIntent);
        overridePendingTransition(0,0);
        finish();
    }
// 하단바 버튼 함수
}
