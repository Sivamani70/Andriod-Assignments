package com.example.recycler_17mca049l;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<DataProvider> providers = new ArrayList<>();
        int[] resImages = {
                R.drawable.bongsoon,
                R.drawable.chen,
                R.drawable.fbi,
                R.drawable.fbimg,
                R.drawable.fun,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.imgq,
                R.drawable.js,
                R.drawable.quote,
                R.drawable.quotea,
                R.drawable.quotealb,
                R.drawable.siva,
                R.drawable.tree,
        };
        for (int i = 0; i < resImages.length; i++) {
            providers.add(new DataProvider(resImages[i], "Image Item " + (i + 1)));
        }

        DataAdapter adapter = new DataAdapter(this , providers);
        recyclerView.setAdapter(adapter);
    }
}