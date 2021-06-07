package com.example.pos_version2.Category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Item.updateItem;
import com.example.pos_version2.Item.updateRecyclerViewAdapter;
import com.example.pos_version2.Login.adminMenu;
import com.example.pos_version2.R;

import java.util.List;

public class Fruits extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button b1;
    List<itemModel> fruitList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        b1=findViewById(R.id.btn1);
        DBHelperItem dbHelper = new DBHelperItem(Fruits.this);
        fruitList=dbHelper.viewFruit();
        recyclerView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new cartRecyclerViewAdapter(fruitList,Fruits.this) {
        };
        recyclerView.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fruits.this, adminMenu.class);
                startActivity(i);
            }
        });
    }
}
