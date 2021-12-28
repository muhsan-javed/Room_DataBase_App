package com.muhsantech.roomdatabaseapp.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.muhsantech.roomdatabaseapp.Models.User;
import com.muhsantech.roomdatabaseapp.dao.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class DataBaseProvider extends RoomDatabase {

    public abstract UserDao getUserDao();

    private static DataBaseProvider dataBaseProvider = null;

    public static DataBaseProvider getDbConnection(Context context){

        if (dataBaseProvider == null){
            dataBaseProvider = Room.databaseBuilder(context.getApplicationContext(), DataBaseProvider.class,"mydb")
                    .allowMainThreadQueries()
                    .build();
        }
        return dataBaseProvider;
    }

}
