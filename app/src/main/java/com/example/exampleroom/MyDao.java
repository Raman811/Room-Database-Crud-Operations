package com.example.exampleroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
     void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Query("delete from users")
    public void deleteUser();

    @Update
    public void updateUser(User user);



}
