package com.rijalkun.drivethruclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import com.rijalkun.drivethruclient.viewmodel.MenuViewModel;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {
    private ImageView imgMenuBtn;
    private MenuViewModel makananViewModel;
    private Connection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMenuBtn = findViewById(R.id.imgMenuBtn);
        imgMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keMenu();
            }
        });

    }
    public void keMenu() {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
    }

}