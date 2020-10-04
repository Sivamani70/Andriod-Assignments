package com.example.recycler_17mca049l;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    final Context context;
    final List<DataProvider> providers;

    public DataAdapter(Context context, List<DataProvider> providers) {
        this.context = context;
        this.providers = providers;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.images_names, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(providers.get(position).getImageAddress());
        holder.textView.setText(providers.get(position).getTextResources());

//        holder.imageView.setOnClickListener(v -> {
//            navigator(providers.get(position).getTextResources(), providers.get(position).getImageAddress());
//        });
//        holder.textView.setOnClickListener(v -> {
//            navigator(providers.get(position).getTextResources(), providers.get(position).getImageAddress());
//        });

        holder.card.setOnClickListener(v -> {
            navigator(providers.get(position).getTextResources(), providers.get(position).getImageAddress());
        });
    }


    void navigator(String res, int value) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("res", res);
        intent.putExtra("img", value);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final CardView card;
        final ImageView imageView;
        final TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.resImage);
            textView = itemView.findViewById(R.id.resText);


        }
    }
}
