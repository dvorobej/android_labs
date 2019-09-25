package com.example.lab1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        textViewTwo.text=intent.getStringExtra("question")
        buttonTwo.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("answer",editTextTwo.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
