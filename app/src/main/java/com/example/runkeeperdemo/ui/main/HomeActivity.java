package com.example.runkeeperdemo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.runkeeperdemo.MainActivity;
import com.example.runkeeperdemo.R;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    public void go2Trophies(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
