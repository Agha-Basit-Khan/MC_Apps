package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        SeekBar seekBar = findViewById(R.id.seekBar);
        ArrayList<String> table = new ArrayList<String>();

        seekBar.setMax(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ArrayList<String> table = new ArrayList<String>();

                for (int x = 1; x < 10; x++){
                    table.add(Integer.toString(x*progress));
                }
                ArrayAdapter<String> tableAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,table);

                listView.setAdapter(tableAdapter);
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