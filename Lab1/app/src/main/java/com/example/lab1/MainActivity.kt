package com.example.lab1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonMain.setOnClickListener() {
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("question", editTextMain.text.toString())
            startActivityForResult(intent, 12)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 12) {
            if (resultCode == Activity.RESULT_OK) {
                if (data!=null){
                    textViewMain.text=data.getStringExtra("answer")
                }
            }
        }
    }
}
