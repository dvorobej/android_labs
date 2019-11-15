package com.example.lab4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

const val MESSAGE = "com.example.lab4"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LocalBroadcastManager.getInstance(this).registerReceiver(broadCastReceiver, IntentFilter("main_activity"))
    }
    fun send(view: View) {
        val intent = Intent(this, MainIntentService::class.java)
        intent.putExtra(MESSAGE, inputNumber.text.toString().toInt())
        startService(intent)
        button.isEnabled = false
    }

    private val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {
            val quantity = intent?.getIntExtra("quantity", 0)
            val numbers = intent?.getStringExtra("finish")
            quantityNumbers.text = quantity.toString()
            scrollText.text = numbers
            button.isEnabled = true
        }
    }
}
