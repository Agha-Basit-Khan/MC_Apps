package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button button;

    List<Item> friendsList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setListAdapter();

    }
    private void setListAdapter() {
        Item f0 = new Item("Asad", "Giglgit",1980 );
        Item f1 = new Item("Ahmed", "Giglgit",1980 );
        Item f2 = new Item("Zohaib", "Giglgit",1980 );
        Item f3 = new Item("Saleem", "Giglgit",1980 );
        Item f4 = new Item("Akhtar", "Giglgit",1980 );
        Item f5 = new Item("Irfan", "Giglgit",1980 );
        Item f6 = new Item("Khan", "Giglgit",1980 );
        Item f7 = new Item("Nabeel", "Giglgit",1980 );

        friendsList.addAll(Arrays.asList(new Item[]{f0,f1,f2,f3,f4,f5,f6,f7,}));
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(friendsList,MainActivity2.this);
        recyclerView.setAdapter(adapter);
    }
}