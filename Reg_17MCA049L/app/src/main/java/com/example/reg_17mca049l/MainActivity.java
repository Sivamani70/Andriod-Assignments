package com.example.reg_17mca049l;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.reg_17mca049l.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.sendData.setOnClickListener(v -> {


            final String name = binding.personName.getText().toString();
            final String rollNumber = binding.rollNum.getText().toString();
            final String emailId = binding.eMailId.getText().toString();
            final String phoneNumber = binding.phoneNumber.getText().toString();
            final String password = binding.password.getText().toString();

            if (name.isEmpty() || rollNumber.isEmpty() || emailId.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please Fill All the fields", Toast.LENGTH_SHORT).show();
                return;
            }

            final String gender = ((RadioButton) findViewById(binding.genderGroup.getCheckedRadioButtonId())).getText().toString();
            final String branch = ((RadioButton) findViewById(binding.selectBranch.getCheckedRadioButtonId())).getText().toString();
            final String data = name + rollNumber + emailId + phoneNumber + password + gender + branch;

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("rollNumber", rollNumber);
            intent.putExtra("emailId", emailId);
            intent.putExtra("phoneNumber", phoneNumber);
            intent.putExtra("password", password);
            intent.putExtra("gender", gender);
            intent.putExtra("branch", branch);

            startActivity(intent);
            binding.rollNum.setText("");
            binding.personName.setText("");
            binding.eMailId.setText("");
            binding.phoneNumber.setText("");
            binding.password.setText("");

        });

    }
}