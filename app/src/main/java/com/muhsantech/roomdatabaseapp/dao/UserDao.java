package com.muhsantech.roomdatabaseapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.muhsantech.roomdatabaseapp.Models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User... users);

    @Query("SELECT * FROM USER")
    public List<User> getAllUser();

    @Delete
    public void Delete(User user);

    @Update
    public void Update(User user);

}
