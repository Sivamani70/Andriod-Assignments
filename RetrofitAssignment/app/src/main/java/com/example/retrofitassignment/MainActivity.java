package com.example.retrofitassignment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.NetworkEndPoint networkEndPoint = RetrofitInstance.getRetrofit().create(RetrofitInstance.NetworkEndPoint.class);
        Call<String> networkEndPointData = networkEndPoint.getData();

        networkEndPointData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    final JSONArray jsonArray = new JSONArray(response.body());
                    JSONObject jsonObject;
                    final List<DataProvider> dataProviders = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        dataProviders.add(new DataProvider(jsonObject.getString("title"), jsonObject.getString("thumbnailUrl")));
                    }
                    adapter = new DataAdapter(MainActivity.this, dataProviders);
                    recycler.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}