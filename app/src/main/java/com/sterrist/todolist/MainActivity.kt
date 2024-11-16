package com.sterrist.todolist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var items = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.user_input)
        val addItemButton = findViewById<Button>(R.id.add_item_button)
        val listView = findViewById<ListView>(R.id.list)
        val clearItemsButton = findViewById<Button>(R.id.clear_items_button)

        fun updateListView() {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                items
            )

            listView.adapter = adapter
        }

        addItemButton.setOnClickListener {
            val text = userInput.text

            items.add(items.size.toString() + ". " + text.toString().trim())

            updateListView()

            userInput.setText("")

            Toast.makeText(this, "Дело добавлено!", Toast.LENGTH_SHORT).show()
        }

        clearItemsButton.setOnClickListener {
            items.clear()

            updateListView()

            Toast.makeText(this, "Список дел очищен!", Toast.LENGTH_SHORT).show()
        }
    }
}