package com.example.reg_17mca049l;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.reg_17mca049l.databinding.ActivityMainBinding;
import com.example.reg_17mca049l.databinding.ActivityMainBindingImpl;
import com.example.reg_17mca049l.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        binding= DataBindingUtil.setContentView(this , R.layout.activity_second);

        Intent data = getIntent();

        binding.secName.setText("Name : " + data.getStringExtra("name"));
        binding.secRollNum.setText("Roll Number : " + data.getStringExtra("rollNumber"));
        binding.secMail.setText("Email Id : " + data.getStringExtra("emailId"));
        binding.secPhoneNumber.setText("Phone Number : " + data.getStringExtra("phoneNumber"));
        binding.secPassword.setText("Password : " + data.getStringExtra("password"));
        binding.secGender.setText("Gender : " + data.getStringExtra("gender"));
        binding.secBranch.setText("Branch : " + data.getStringExtra("branch"));

    }
}