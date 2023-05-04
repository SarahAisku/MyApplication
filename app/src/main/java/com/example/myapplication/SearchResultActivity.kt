package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SearchResultActivity : AppCompatActivity() {
    private lateinit var backButton: Button
    private lateinit var resetButton: Button
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private var likedNames: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        backButton = findViewById(R.id.back)
        resetButton = findViewById(R.id.reset_button)
        listView = findViewById(R.id.list_view)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, likedNames)
        listView.adapter = adapter

        val name = intent.getStringExtra("name")
        // Call API with name parameter and get country prediction

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedName = likedNames[position]
            // Open details screen with selected name
        }

        resetButton.setOnClickListener {
            likedNames.clear()
            adapter.notifyDataSetChanged()
        }

        backButton.setOnClickListener {
        }
    }

    fun addLikedName(name: String) {
        likedNames.add(name)
        adapter.notifyDataSetChanged()
    }
}