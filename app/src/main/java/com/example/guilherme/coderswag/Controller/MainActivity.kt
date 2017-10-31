package com.example.guilherme.coderswag.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.guilherme.coderswag.Adapters.CategoryRecycleAdapter
import com.example.guilherme.coderswag.R
import com.example.guilherme.coderswag.Services.DataService
import com.example.guilherme.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adapter = CategoryAdapter(this, DataService.categories)

        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        category_listview.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        category_listview.layoutManager = layoutManager
        category_listview.setHasFixedSize(true)
    }
}
