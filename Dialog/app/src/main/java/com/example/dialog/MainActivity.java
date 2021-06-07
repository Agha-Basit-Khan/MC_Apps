package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn);
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //builder.setTitle("My Dialog");
        //builder.setMessage("It is the content of my dialog");
        builder.setCancelable(false);
        builder.setView(R.layout.dialog_layout);
        //LayoutInflater layoutInflater= this.getLayoutInflater();
        //builder.setView(layoutInflater.inflate(R.layout.dialog_layout,null));
        /*builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You Clicked Positive Button " + String.valueOf(which), Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You Clicked Negative Button " + String.valueOf(which), Toast.LENGTH_LONG).show();
            }
        });*/
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}