package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView label_tv;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label_tv = findViewById(R.id.tv);
        if (savedInstanceState != null && savedInstanceState.containsKey("key")) {
            count = savedInstanceState.getInt("key");
            label_tv.setText(String.valueOf(count));
        }
    }

    public void showToast(View view) {
        Toast.makeText(this, "Count is : " + label_tv.getText(), Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        count = Integer.parseInt(label_tv.getText().toString());
        count++;
        label_tv.setText(String.valueOf(count));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", count);
    }
}