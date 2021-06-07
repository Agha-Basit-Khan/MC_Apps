package com.example.pos_version2.Item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Login.adminMenu;
import com.example.pos_version2.MainActivity;
import com.example.pos_version2.R;

public class updatedMenuItem extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    TextView ed5;
    Button b1,b2;
    DBHelperItem dbHelper;
    final itemModel[] customerModel = new itemModel[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated_menu_item);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.des);
        ed3 = findViewById(R.id.amount);
        ed4 = findViewById(R.id.quantity);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        Intent i = getIntent();
        int id = i.getIntExtra("id",0);
        String name = i.getStringExtra("name");
        String description = i.getStringExtra("description");
        String amount = i.getStringExtra("amount");
        String quantity = i.getStringExtra("quantity");
        ed1.setText(name);
        ed2.setText(description);
        ed3.setText(amount);
        ed4.setText(quantity);
        //ed5.setText(id);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(id);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(updatedMenuItem.this, adminMenu.class);
                startActivity(i);
            }
        });
    }
    public void update(int id){
        String name1 = ed1.getText().toString();
        String description1 = ed2.getText().toString();
        String amount1 = ed3.getText().toString();
        String quantity1 = ed4.getText().toString();
        customerModel[0] = new itemModel(id,name1,description1,amount1,quantity1);

        dbHelper = new DBHelperItem(updatedMenuItem.this);
        dbHelper.updateItem(customerModel[0]);
        Intent i = new Intent(updatedMenuItem.this, adminMenu.class);
        startActivity(i);
    }
}