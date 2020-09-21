package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateGroupActivity extends AppCompatActivity {
    EditText studyGroupName_edit, studyExplain_edit;
    Button createGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        studyGroupName_edit = findViewById(R.id.studyGroupName_edit);
        studyExplain_edit = findViewById(R.id.studyExplain_edit);
        createGroupButton = findViewById(R.id.createGroupButton);

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createCompleteIntent = new Intent(getApplicationContext(),GroupActivity.class);
                String newGroup_name = studyGroupName_edit.getText().toString();
                String newGroup_explain = studyExplain_edit.getText().toString();
                createCompleteIntent.putExtra("newGroup_name",newGroup_name);
                createCompleteIntent.putExtra("newGroup_explain",newGroup_explain);
                startActivity(createCompleteIntent);
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
