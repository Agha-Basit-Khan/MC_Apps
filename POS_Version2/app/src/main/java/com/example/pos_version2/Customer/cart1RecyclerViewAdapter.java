package com.example.pos_version2.Customer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.R;

import java.util.List;

public class cart1RecyclerViewAdapter extends RecyclerView.Adapter<cart1RecyclerViewAdapter.MyHolder> {
    List<itemModel> itemList;
    Activity mAct;
    DBHelperItem dbHelper;
    final itemModel[] customerModel = new itemModel[1];

    public cart1RecyclerViewAdapter(List<itemModel> friendsList, Activity mAct) {
        this.itemList = friendsList;
        this.mAct = mAct;
    }
    @NonNull
    @Override
    public cart1RecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_view, parent, false);
        return new cart1RecyclerViewAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull cart1RecyclerViewAdapter.MyHolder holder, int position) {
        holder.data=itemList.get(position);
        holder.t1.setText("Name : " + holder.data.getName());
        holder.t2.setText("Amount : " + holder.data.getAmount());
        holder.t3.setText("Description : " + holder.data.getDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        itemModel data;
        TextView t1,t2,t3;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.name);
            t2=itemView.findViewById(R.id.description);
            t3=itemView.findViewById(R.id.amount);
        }
    }
}
