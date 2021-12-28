package com.muhsantech.roomdatabaseapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.muhsantech.roomdatabaseapp.Models.User;
import com.muhsantech.roomdatabaseapp.adapters.MyAdapter;
import com.muhsantech.roomdatabaseapp.databinding.ActivityHomeBinding;
import com.muhsantech.roomdatabaseapp.entity.DataBaseProvider;

import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        DataBaseProvider dataBaseProvider = DataBaseProvider.getDbConnection(getApplicationContext());
        List<User> usersList =  dataBaseProvider.getUserDao().getAllUser();

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), usersList);

        // LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        binding.recyclerView.setAdapter(myAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}