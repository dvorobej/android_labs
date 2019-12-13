package com.example.lab5.dao.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lab5.dao.entity.User

@Dao
interface UserDao {
    @Query("SELECT id, first_name, last_name, birthday FROM user " +
            "WHERE first_name LIKE '%' || :first || '%' AND last_name LIKE '%' || :last || '%'")
    fun getByFilter(first: String, last: String): List<User>

    @Query("SELECT id, first_name, last_name, birthday FROM user WHERE last_name LIKE '%' || :last || '%' ")
    fun getByFilter(last: String): List<User>

    @Insert
    fun insert(user: User)
}