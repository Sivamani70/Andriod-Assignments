package com.example.tasktwo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView contextMenu = findViewById(R.id.contextMenu);
        registerForContextMenu(contextMenu);

        ((TextView) findViewById(R.id.dataText)).setText(getIntent().getStringExtra("data"));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contenxt_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.copy:
            case R.id.cut:
            case R.id.select: {
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

}