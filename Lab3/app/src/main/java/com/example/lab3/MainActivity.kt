package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_activity.*


class MainActivity : AppCompatActivity() {

    private lateinit var fragment: MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        buttonMain.setOnClickListener {
//            val intent = Intent(this, AnswerActivity::class.java)
//            intent.putExtra("question", editTextMain.text.toString())
//            startActivityForResult(intent, 12)
//        }
        this.fragment = supportFragmentManager.findFragmentById(R.id.first) as MyFragment
        fragment.button.setOnClickListener {
            val intent = Intent(this, AnswerActivity::class.java).apply {
                putExtra("question", fragment.editText.text.toString())
            }
            startActivityForResult(intent, 12)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 12) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getStringExtra("endgame").equals("endgame")) {
                    finish()
                }
                textViewMain.text = data?.getStringExtra("answer")
            }
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

}
