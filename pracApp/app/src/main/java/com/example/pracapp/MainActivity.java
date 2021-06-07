package com.example.pracapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void move(View view) {
        Uri uri = Uri.parse("https://www.google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }

    public void home(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void about(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void contact(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void skills(View view) {
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
}