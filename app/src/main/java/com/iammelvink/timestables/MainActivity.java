package com.iammelvink.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
     * genTimesTable method*/
    public void genTimesTable(int timesTableNumber) {
        /*
         * timeTablesList ListView*/
        ListView timeTablesList = (ListView) findViewById(R.id.timeTablesList);
        /*
         * ArrayList for ListView*/
        ArrayList<String> timesTableContent = new ArrayList<>();

        /*
         * Feeding the correct values to be placed in the ListView*/

        for (int i = 1; i < 21; i++) {
            timesTableContent.add(Integer.toString(timesTableNumber) + " x " +
                    Integer.toString(i) + " = " +
                    (i * timesTableNumber));
        }

        /*
         * Putting values into ListView*/
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1, timesTableContent);

        timeTablesList.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * Creating Seekbar*/
        final SeekBar timeTableSeekBar = findViewById(R.id.timeTableSeekBar);


        final int MAX = 20;
        final int STARTINGPOSITION = 1;

        timeTableSeekBar.setMax(MAX);
        timeTableSeekBar.setProgress(STARTINGPOSITION);

        /*
         * Calling genTimesTable method*/
        genTimesTable(STARTINGPOSITION);

        /*
         *OnSeekBarChangeListener for Seekbar */
        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int timesTableNumber;

                /*
                 * Calling genTimesTable method*/
//                genTimesTable(STARTINGPOSITION);

                /*
                 * Make sure min is 1*/
                if (progress < STARTINGPOSITION) {
                    timesTableNumber = STARTINGPOSITION;
                    timeTableSeekBar.setProgress(STARTINGPOSITION);
                    /*Set values according to Seekbar progress/location*/
                } else {
                    timesTableNumber = progress;
                }
                /*
                 * Test*/
                Log.i("Seekbar value", Integer.toString(timesTableNumber));
                /*
                 * Calling genTimesTable method*/
                genTimesTable(timesTableNumber);

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
