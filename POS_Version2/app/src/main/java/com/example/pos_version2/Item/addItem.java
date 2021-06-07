package com.example.pos_version2.Item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Login.adminMenu;
import com.example.pos_version2.MainActivity;
import com.example.pos_version2.R;

public class addItem extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;
    DBHelperItem dbHelper;
    String name=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final itemModel[] customerModel = new itemModel[1];

        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1=findViewById(R.id.name);
                ed2=findViewById(R.id.des);
                ed3=findViewById(R.id.amount);
                ed4=findViewById(R.id.quantity);

                name = ed1.getText().toString();
                String description = ed2.getText().toString();
                String amount = ed3.getText().toString();
                String quantity = ed4.getText().toString();
                customerModel[0] = new itemModel(name,description,amount,quantity);

                dbHelper = new DBHelperItem(addItem.this);
                dbHelper.addItem(customerModel[0]);
                //ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed1.requestFocus();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addItem.this, adminMenu.class);
                startActivity(i);
            }
        });
    }
}