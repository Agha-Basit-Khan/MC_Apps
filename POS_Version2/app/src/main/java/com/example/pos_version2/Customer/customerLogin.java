package com.example.pos_version2.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pos_version2.HelperItem.DBHelperCustomer;
import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.customerModel;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Item.addItem;
import com.example.pos_version2.Login.adminMenu;
import com.example.pos_version2.MainActivity;
import com.example.pos_version2.R;

public class customerLogin extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;
    DBHelperCustomer dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        final customerModel[] customerModel = new customerModel[1];

        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1=findViewById(R.id.name);
                ed2=findViewById(R.id.address);
                ed3=findViewById(R.id.email);
                ed4=findViewById(R.id.phone);

                String name = ed1.getText().toString();
                String address = ed2.getText().toString();
                String email = ed3.getText().toString();
                String phone = ed4.getText().toString();
                customerModel[0] = new customerModel(name,address,email,phone);

                dbHelper = new DBHelperCustomer(customerLogin.this);
                dbHelper.addCustomer(customerModel[0]);
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed1.requestFocus();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(customerLogin.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}