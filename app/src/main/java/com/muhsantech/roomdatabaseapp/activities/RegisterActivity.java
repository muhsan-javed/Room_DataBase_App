package com.muhsantech.roomdatabaseapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muhsantech.roomdatabaseapp.Models.User;
import com.muhsantech.roomdatabaseapp.databinding.ActivityRegisterBinding;
import com.muhsantech.roomdatabaseapp.entity.DataBaseProvider;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("back");

        binding.btnRegisterRA.setOnClickListener(view -> {
            String name = binding.edName.getText().toString();
            String email = binding.edEmail.getText().toString();
            String phone = binding.edNumber.getText().toString();
            String password = binding.edPassword.getText().toString();
            if (name.equals("") || email.equals("") || phone.equals("") || password.equals("")){
                Toast.makeText(RegisterActivity.this, "PLease fill the all Fields", Toast.LENGTH_SHORT).show();
            }
            else {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setMobile(phone);
                user.setPassword(password);

                DataBaseProvider dataBaseProvider = DataBaseProvider.getDbConnection(getApplicationContext());
                dataBaseProvider.getUserDao().insertUser(user);
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                Toast.makeText(getApplicationContext(), "Successful Insert DataBase", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}