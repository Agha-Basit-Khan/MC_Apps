package com.example.pos_version2.Item;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.MainActivity;
import com.example.pos_version2.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    List<itemModel> friendsList;
    Activity mAct;
    DBHelperItem dbHelper;
    final itemModel[] customerModel = new itemModel[1];

    public RecyclerViewAdapter(List<itemModel> friendsList, Activity mAct) {
        this.friendsList = friendsList;
        this.mAct = mAct;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyHolder holder, int position) {
        holder.data=friendsList.get(position);
        holder.t1.setText("Name : " + holder.data.getName());
        holder.t2.setText("Amount : " + holder.data.getAmount());
        holder.t3.setText("Quantity : " + holder.data.getQuantity());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
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
