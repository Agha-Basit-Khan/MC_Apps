package com.example.stylishlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager layoutManager;
    Button b1;
    List<itemModel> friendsList = new ArrayList<itemModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        final itemModel[] customerModel = new itemModel[1];
        Intent i = new Intent(MainActivity.this,addItem.class);
        startActivity(i);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    customerModel[0] = new itemModel("a","abc",2,4);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelperItem dbHelper = new DBHelperItem(MainActivity.this);
                boolean b = dbHelper.addItem(customerModel[0]);
                if(b==true){
                    Toast.makeText(MainActivity.this, customerModel[0].toString(), Toast.LENGTH_SHORT).show();
                    //RefreshData();
                }

            }
        });*/
setListAdapter();

    }
    private void setListAdapter() {

        //boolean b = db.addItem(fff);
        /*itemModel f1 = new itemModel("b","Alo", 1980, 190);
        db.addItem(f1);
        itemModel f2 = new itemModel("c","Gobi", 1980, 190);
        db.addItem(f2);
        itemModel f3 = new itemModel("d","Piyaz", 1980, 190);
        db.addItem(f3);
        itemModel f4 = new itemModel("e","Tamater", 1980, 190);
        db.addItem(f4);
        itemModel f5 = new itemModel("f","Mix", 1980, 190);
        db.addItem(f5);*/

        //friendsList=db.viewItem();
        DBHelperItem dbHelper = new DBHelperItem(MainActivity.this);
        friendsList = dbHelper.viewItem();
        recyclerView = findViewById(R.id.recycleView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(friendsList,MainActivity.this) {

        };

        recyclerView.setAdapter(adapter);
    }
}