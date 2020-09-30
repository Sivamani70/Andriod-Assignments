package com.example.taskswitch;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Switch mobileData = findViewById(R.id.switchOne);
        mobileData.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mobileData.setChecked(isChecked);
                final String state = isChecked ? "Turned On" : "Turned Off";
                Toast.makeText(MainActivity.this, "Mobile Data : " + state, Toast.LENGTH_SHORT).show();
            }
        });

        final Switch bluetooth = findViewById(R.id.switchTwo);


        bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bluetooth.setChecked(isChecked);
                final String state = isChecked ? "Turned On" : "Turned Off";
                Toast.makeText(MainActivity.this, "Bluetooth : " + state, Toast.LENGTH_SHORT).show();
            }
        });

        final SwitchCompat materialSwitch = findViewById(R.id.materialSwitch);
        materialSwitch.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        "Material Switch : " + (isChecked ? "Turned On" : "Turned Off"),
                        Toast.LENGTH_SHORT).show();
            }
        }));

    }
}