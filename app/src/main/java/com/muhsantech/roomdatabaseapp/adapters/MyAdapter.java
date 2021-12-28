package com.muhsantech.roomdatabaseapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muhsantech.roomdatabaseapp.Models.User;
import com.muhsantech.roomdatabaseapp.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>{
    List<User> users;
    Context context;
    public MyAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_books, parent, false);
        return new viewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        User model = users.get(position);
        holder.tvID.setText("ID :"+model.getId());
        holder.tvName.setText("Name: "+model.getName());
        holder.tvPhone.setText("Phone: "+ model.getMobile());
        holder.tvEmail.setText("Email: "+model.getEmail());
        holder.tvPassword.setText("Password: "+model.getPassword());
        holder.itemView.setOnClickListener(view -> {
            // This holder.itemView --> you write code what do you went Click itmes
        });
    }
    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail, tvPhone, tvPassword,tvID;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPassword = itemView.findViewById(R.id.tvPassword);
            tvID = itemView.findViewById(R.id.tvID);
        }
    }

}
