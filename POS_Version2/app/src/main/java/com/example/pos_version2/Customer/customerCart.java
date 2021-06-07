package com.example.pos_version2.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pos_version2.HelperItem.DBHelperCart;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Login.adminMenu;
import com.example.pos_version2.R;

import java.util.List;

public class customerCart extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button b1;
    List<itemModel> itemList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_cart);

        b1=findViewById(R.id.btn1);
        DBHelperCart dbHelper = new DBHelperCart(customerCart.this);
        itemList=dbHelper.viewCart();
        recyclerView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new cart1RecyclerViewAdapter(itemList,customerCart.this) {
        };
        recyclerView.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(customerCart.this, adminMenu.class);
                startActivity(i);
            }
        });
    }
}