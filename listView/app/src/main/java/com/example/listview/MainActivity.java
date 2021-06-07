package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> friendList;
    ArrayAdapter<String> friendAdapter;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myList);
        friendList = new ArrayList<String>();
        friendList.add("Agha");
        friendList.add("Basit");
        friendList.add("Khan");
        friendList.add("Agha");
        friendList.add("Basit");
        friendList.add("Khan");

        friendAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendList);
        listView.setAdapter(friendAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("you clicked", friendList.get(position));


            }
        });



    }

    public void addName(View view) {
        editText = findViewById(R.id.txt);
        friendList.add(editText.getText().toString());
        friendAdapter.notifyDataSetChanged();
        Collections.sort(friendList);

    }
}











