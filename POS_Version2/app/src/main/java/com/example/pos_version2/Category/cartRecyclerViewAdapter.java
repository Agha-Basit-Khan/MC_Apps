package com.example.pos_version2.Category;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_version2.Customer.customerCart;
import com.example.pos_version2.HelperItem.DBHelperCart;
import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.Item.deleteRecyclerViewAdapter;
import com.example.pos_version2.MainActivity;
import com.example.pos_version2.R;

import java.util.List;

public class cartRecyclerViewAdapter extends RecyclerView.Adapter<cartRecyclerViewAdapter.MyHolder> {
    List<itemModel> itemList;
    Activity mAct;
    DBHelperCart dbHelper;
    final itemModel[] itemModel = new itemModel[1];

    public cartRecyclerViewAdapter(List<itemModel> itemList, Activity mAct) {
        this.itemList = itemList;
        this.mAct = mAct;
    }
    @NonNull
    @Override
    public cartRecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_view, parent, false);
        return new cartRecyclerViewAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull cartRecyclerViewAdapter.MyHolder holder, int position) {
        holder.data=itemList.get(position);
        holder.t1.setText("Name : " + holder.data.getName());
        holder.t2.setText("Amount : " + holder.data.getAmount());
        holder.t3.setText("Category : " + holder.data.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = holder.data.getName();
                String des = holder.data.getDescription();
                String amount = holder.data.getAmount();
                itemModel[0] = new itemModel(name,des,amount);
                dbHelper = new DBHelperCart(mAct);
                dbHelper.addCart(itemModel[0]);
                Intent i = new Intent(mAct.getApplicationContext(), customerCart.class);
                mAct.startActivity(i);
            }
        });
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
