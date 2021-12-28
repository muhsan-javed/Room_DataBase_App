package com.muhsantech.roomdatabaseapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.muhsantech.roomdatabaseapp.Models.User;
import com.muhsantech.roomdatabaseapp.databinding.ActivityLoginBinding;
import com.muhsantech.roomdatabaseapp.entity.DataBaseProvider;

import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.btnLogin.setOnClickListener(view -> {
            String email = binding.edEmail.getText().toString();
            String password = binding.edPassword.getText().toString();
            if (email.equals("")  || password.equals("")){
                Toast.makeText(LoginActivity.this, "PLease fill the Fields", Toast.LENGTH_SHORT).show();
            }
            else {
                DataBaseProvider dataBaseProvider = DataBaseProvider.getDbConnection(getApplicationContext());
                List<User> usersList =  dataBaseProvider.getUserDao().getAllUser();
                for (User user1 : usersList) {
                    String eMail = user1.getEmail();
                    String pass = user1.getPassword();
                    if (email.equals(eMail) && password.equals(pass)) {
                        Toast.makeText(this, "WelCome to Home ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        break;
                    }
                    else {
                        Toast.makeText(this, "invalid Email or Password = ", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            }
        });
        binding.btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
    }
}