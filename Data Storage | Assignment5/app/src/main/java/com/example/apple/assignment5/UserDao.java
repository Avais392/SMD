package com.example.apple.assignment5;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ishrat.fatima on 3/8/2018.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user where first_name LIKE  :firstName AND last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Query("UPDATE user SET first_name=:firstName, last_name=:lastName WHERE uid LIKE :id")
    void update(int id,String firstName,String lastName);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}