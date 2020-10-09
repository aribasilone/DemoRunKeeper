package com.example.runkeeperdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.runkeeperdemo.ui.main.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.runkeeperdemo.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

    }

    //button functions
    public void toastMessage(View view) {
        // Do something in response to button click
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Some Button Action for Another Time", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 20);
        toast.show();
    }

    public void go2Home(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
}