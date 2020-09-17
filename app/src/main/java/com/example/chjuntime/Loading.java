package com.example.chjuntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Loading extends AppCompatActivity {

    ImageView icon_on;
    TextView sulmyung, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        icon_on = findViewById(R.id.icon_on);
        sulmyung = findViewById(R.id.sulmyung);
        title = findViewById(R.id.title);

            sulmyung.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

        Handler mHandler = new Handler();

        Runnable mTask = new Runnable() {
            @Override
            public void run() {
                sulmyung.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
            }
        };

        mHandler.postDelayed(mTask,1500);

            Toast.makeText(this, "실행", Toast.LENGTH_SHORT).show();
    }
}
