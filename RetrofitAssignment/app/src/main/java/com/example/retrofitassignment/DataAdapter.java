package com.example.retrofitassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.img_text_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(providers.get(position).getContent());
        Picasso.get()
                .load(providers.get(position).getImgUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.responseImage);
            textView = itemView.findViewById(R.id.responseText);

        }
    }
}
