package com.example.taskone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.name_number);
        final Button send = findViewById(R.id.send);
        final Button call = findViewById(R.id.call);
        final Button camera = findViewById(R.id.camera);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                options(v);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                options(v);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                options(v);
            }
        });


    }


    void options(View v) {
        final String data = editText.getText().toString();
        final String errMsg = "Enter Name or Number";
        switch (v.getId()) {
            case R.id.camera: {
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                break;
            }
            case R.id.send: {
                if (!data.isEmpty()) {
                    editText.setText("");
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("data", data.toUpperCase());
                    startActivity(intent);
                    return;
                }
                editText.setError(errMsg);
                break;

            }
            case R.id.call: {
                if (!data.isEmpty()) {
                    editText.setText("");
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + data));
                    startActivity(intent);
                    return;
                }
                editText.setError(errMsg);
                break;
            }
        }

    }


}