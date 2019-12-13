package com.example.lab5.dao.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab5.dao.entity.User
import com.example.lab5.dao.interfaces.UserDao


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var appDatabase: AppDatabase?= null

        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "mylab5"
                ).allowMainThreadQueries()
                    .build()
            }
            return appDatabase!!
        }

    }
}