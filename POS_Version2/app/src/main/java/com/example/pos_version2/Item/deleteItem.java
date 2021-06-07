package com.example.pos_version2.Item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Login.adminMenu;
import com.example.pos_version2.R;

import java.util.List;

public class deleteItem extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button b1;
    List<itemModel> itemList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);
        b1=findViewById(R.id.btn1);
        DBHelperItem dbHelper = new DBHelperItem(deleteItem.this);
        itemList=dbHelper.viewItem();
        recyclerView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new deleteRecyclerViewAdapter(itemList,deleteItem.this) {
        };
        recyclerView.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(deleteItem.this, adminMenu.class);
                startActivity(i);
            }
        });
    }
}