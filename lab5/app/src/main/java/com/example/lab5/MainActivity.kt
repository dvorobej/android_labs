package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.example.lab5.dao.database.AppDatabase
import com.example.lab5.dao.entity.User
import com.example.lab5.dao.interfaces.UserDao
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var userDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getInstance(this.applicationContext)
        userDao = db?.userDao()
    }

    fun insert(view: View) {
        val user: User = User()
        user.firstName = firstName.text.toString()
        user.lastName = lastName.text.toString()
        user.birthday = birthday.text.toString()

        userDao?.insert(user)
    }

    fun getByFilter(view: View) {
        val firstName = firstName.text.toString()
        val lastName = lastName.text.toString()
        if (firstName.isEmpty() and lastName.isNotEmpty()) {
            textView.text = userDao?.getByFilter(lastName).toString()
        } else if(firstName.isNotEmpty() and lastName.isNotEmpty()) {
            textView.text = userDao?.getByFilter(firstName, lastName).toString()
        } else {
            textView.text = ""
        }
    }
}
