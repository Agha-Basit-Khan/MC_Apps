package com.example.pos_version2.Item;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_version2.HelperItem.DBHelperItem;
import com.example.pos_version2.HelperItem.itemModel;
import com.example.pos_version2.MainActivity;
import com.example.pos_version2.R;

import java.util.List;

public class deleteRecyclerViewAdapter extends RecyclerView.Adapter<deleteRecyclerViewAdapter.MyHolder> {
    List<itemModel> friendsList;
    Activity mAct;
    DBHelperItem dbHelper;
    final itemModel[] customerModel = new itemModel[1];

    public deleteRecyclerViewAdapter(List<itemModel> friendsList, Activity mAct) {
        this.friendsList = friendsList;
        this.mAct = mAct;
    }
    @NonNull
    @Override
    public deleteRecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new deleteRecyclerViewAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull deleteRecyclerViewAdapter.MyHolder holder, int position) {
        holder.data=friendsList.get(position);
        holder.t1.setText("Name : " + holder.data.getName());
        holder.t2.setText("Amount : " + holder.data.getAmount());
        holder.t3.setText("Quantity : " + holder.data.getQuantity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerModel[0] = new itemModel();
                customerModel[0].setId(holder.data.getId());
                Log.d("Clicked", String.valueOf(holder.data.getId()));
                dbHelper = new DBHelperItem(mAct);
                dbHelper.deleteItem(customerModel[0]);
                Intent i = new Intent(mAct.getApplicationContext(), MainActivity.class);
                mAct.startActivity(i);

            }
        });
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
