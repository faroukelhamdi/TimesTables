package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableListView;

    public void generateTimeTable(int timeTablesNumber) {

        ArrayList<String> timeTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            timeTableContent.add(String.valueOf(i * timeTablesNumber));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, timeTableContent);

        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.timeTableSeekBar);

        timeTableListView = (ListView) findViewById(R.id.timeTablesListView);

        int startingPosition = 10;

        int max = 20;

        timeTableSeekBar.setMax(max);

        timeTableSeekBar.setProgress(startingPosition);

        generateTimeTable(startingPosition);



        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timeTablesNumber;

                if (progress < min) {
                    timeTablesNumber = min;
                    timeTableSeekBar.setProgress(min);
                }

                else {
                    timeTablesNumber = progress;
                }

                generateTimeTable(timeTablesNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
