package com.example.guilherme.coderswag.Controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guilherme.coderswag.Adapters.CategoryAdapter
import com.example.guilherme.coderswag.R
import com.example.guilherme.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)

        category_listview.adapter = adapter
    }
}
