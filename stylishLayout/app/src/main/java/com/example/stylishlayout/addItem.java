package com.example.stylishlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addItem extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ed1=findViewById(R.id.name);
        ed2=findViewById(R.id.des);
        ed3=findViewById(R.id.amount);
        ed4=findViewById(R.id.quantity);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);

        final itemModel[] customerModel = new itemModel[1];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = ed1.getText().toString();
                    String description = ed2.getText().toString();
                    String amount = ed3.getText().toString();
                    String quantity = ed4.getText().toString();
                    customerModel[0] = new itemModel(name,description,Integer.parseInt(amount),Integer.parseInt(quantity));

                } catch (Exception e) {
                    Toast.makeText(addItem.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelperItem dbHelper = new DBHelperItem(addItem.this);
                boolean b = dbHelper.addItem(customerModel[0]);
                if(b==true){
                    Toast.makeText(addItem.this, customerModel[0].toString(), Toast.LENGTH_SHORT).show();
                    //RefreshData();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addItem.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}