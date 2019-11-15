package com.example.lab4

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class MainIntentService : IntentService("MainIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        val n = intent?.getIntExtra(MESSAGE, 0)
        val numbers: ArrayList<Int> = ArrayList()
        numbers.add(0)
        for (i in 2..n!!) {
            if (isPrime(i))
                numbers.add(i)
        }

        val str = StringBuffer()
        for (i in 0 until numbers.size) {
            str.append(numbers[i])
            if (i != numbers.size - 1) {
                str.append(", ")
            }
        }

        val responseIntent = Intent("main_activity")
        responseIntent.putExtra("quantity", numbers.size)
        responseIntent.putExtra("finish",str.toString())
        LocalBroadcastManager.getInstance(this).sendBroadcast(responseIntent)
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1)
            return false
        for (i in 2 until n)
            if (n % i == 0)
                return false
        return true
    }
}