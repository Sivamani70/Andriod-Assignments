package com.example.googlebooksapi_17mca049l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.author_details, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.author.setText("Author :"  +providers.get(position).getAuthorName());
        holder.title.setText("Titile : " + providers.get(position).getBookName());
        holder.description.setText("Description : " + providers.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView title, author, description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.bookName);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
        }
    }


}
