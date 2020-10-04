package com.example.googlebooksapi_17mca049l;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<DataProvider> dataProviders = new ArrayList<>();

        RetroFitInstance.NetworkEndPoint endPoint = RetroFitInstance.getRetrofit().create(RetroFitInstance.NetworkEndPoint.class);

        Call<String> endPointData = endPoint.getData();

        endPointData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    JSONObject rootObject = new JSONObject(response.body());
                    JSONArray itemsArray = rootObject.getJSONArray("items");


                    Log.d("Response Data", "onResponse: " + itemsArray.length());
                    /*
                     *API is having only proper values for the 3 array
                     * From there some of the fields are missing the authors and description items
                     * so that is why taking count < 3
                     * */
                    for (int i = 0; i < 3; i++) {
                        final JSONObject jsonObject = itemsArray.getJSONObject(i);
                        final JSONObject volumeObj = jsonObject.getJSONObject("volumeInfo");
                        final String title = volumeObj.getString("title");
                        Log.d("Response Data", "onResponse: title " + title);
                        final String description = volumeObj.getString("description");
                        final JSONArray authors = volumeObj.getJSONArray("authors");
                        Log.d("Response Data", "onResponse: authors " + authors);
                        dataProviders.add(new DataProvider(description, title, authors.toString()));
                    }


                    DataAdapter adapter = new DataAdapter(MainActivity.this, dataProviders);
                    recyclerView.setAdapter(adapter);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Something went Wrong" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("Response Data", "onResponse: " + "No author Found");

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}