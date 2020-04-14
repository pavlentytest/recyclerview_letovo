package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> locallist;
    private LayoutInflater layoutInflater;

    public MyRecyclerViewAdapter(Context c, List<String> locallist) {
        this.locallist = locallist;
        this.layoutInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    // Подключение view для каждой строки
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    // Вставляем данные в каждую строку RV
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        String city = locallist.get(position);
        holder.cityTextView.setText(city);
    }

    @Override
    // Общее количество элементов в RV
    public int getItemCount() {
        return locallist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView cityTextView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.itemText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),cityTextView.getText()+"; "+getAdapterPosition(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
