package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.fragment_activity.*

class AnswerActivity : AppCompatActivity() {

    private lateinit var fragment: MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        textViewTwo.text = intent.getStringExtra("question")
//        buttonTwo.setOnClickListener {
//            val intent = Intent()
//            intent.putExtra("answer", editTextTwo.text.toString())
//            setResult(Activity.RESULT_OK, intent)
//            finish()
//        }
        this.fragment = supportFragmentManager.findFragmentById(R.id.second) as MyFragment
        fragment.button.setOnClickListener {
            val intent = Intent().apply {
                putExtra("answer", fragment.editText.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.close -> {
                val exitDialog = ExitDialog()
                exitDialog.show(supportFragmentManager, "dialog")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun finishAndRemoveTask() {
        val intent = Intent().apply {
            putExtra("endgame", "endgame")
        }
        setResult(Activity.RESULT_OK, intent)
        super.finishAndRemoveTask()
    }
}