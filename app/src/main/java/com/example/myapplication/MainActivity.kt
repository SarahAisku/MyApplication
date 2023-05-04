package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var pageButton: Button
    private lateinit var searchButton: Button
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.search_button)
        pageButton = findViewById(R.id.page)
        searchEditText = findViewById(R.id.search_edit_text)

        searchButton.setOnClickListener {
            val name = searchEditText.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SearchResultActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }

        pageButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchResultActivity::class.java)
            startActivity(intent)
        }
    }
}