package com.example.recycler_17mca049l;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ImageView img = findViewById(R.id.imgView);
        final TextView textView = findViewById(R.id.textView);

        final Intent data = getIntent();

        img.setImageResource(data.getIntExtra("img" , R.drawable.siva));
        textView.setText(data.getStringExtra("res"));

    }
}