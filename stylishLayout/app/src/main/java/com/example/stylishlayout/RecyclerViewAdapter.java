package com.example.stylishlayout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    List<itemModel> friendsList;
    Activity mAct;

    public RecyclerViewAdapter(List<itemModel> friendsList, Activity mAct) {
        this.friendsList = friendsList;
        this.mAct = mAct;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mAct.getApplicationContext())
                .inflate(R.layout.list_view, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyHolder holder, int position) {
        holder.data=friendsList.get(position);
        holder.t1.setText("Name : " + holder.data.getName());
        holder.t2.setText("Amount : " + String.valueOf(holder.data.getAmount()));
        holder.t3.setText("Quantity : " + String.valueOf(holder.data.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        itemModel data;
        TextView t1,t2,t3;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.num1);
            t2=itemView.findViewById(R.id.num2);
            t3=itemView.findViewById(R.id.num3);
        }
    }
}
