package com.example.myrecyclerview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<Item> friendsList;
    Activity mAct;

    public RecyclerViewAdapter(List<Item> friendsList, Activity mAct) {
        this.friendsList = friendsList;
        this.mAct = mAct;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data=friendsList.get(position);
        holder.t1.setText(holder.data.getName());
        holder.t2.setText(String.valueOf(holder.data.getAmount()));
        holder.t3.setText(holder.data.getDescription());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        TextView t2;
        TextView t3;
        Item data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.description);
            t3 = itemView.findViewById(R.id.amount);
        }
    }
}
