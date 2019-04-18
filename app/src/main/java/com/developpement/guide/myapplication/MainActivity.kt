package com.developpement.guide.myapplication


import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.text.Editable
import android.text.TextWatcher



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOneGram = findViewById<Button>(R.id.onegram)
        val buttonTwoGram = findViewById<Button>(R.id.twogram)
        val buttonThreeGram = findViewById<Button>(R.id.threegram)
        val messageText = findViewById<EditText>(R.id.edittext)
        val dbHandler = MyDBHandler(this, null, null, 1)

        val filterTextWatcher = object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {

            }
        }

        buttonOneGram.setOnClickListener {
            var word : String
            word = messageText.text.toString()
            var word1 : String
            word1 = dbHandler.findOneGram(word).toString()
            messageText.setText(word + word1)
        }

        buttonTwoGram.setOnClickListener {

        }

        buttonThreeGram.setOnClickListener{

        }

        messageText.addTextChangedListener(filterTextWatcher)


    }
}
