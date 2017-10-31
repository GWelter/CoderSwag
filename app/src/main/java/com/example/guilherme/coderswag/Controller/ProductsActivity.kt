package com.example.guilherme.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.guilherme.coderswag.Adapters.ProductsAdapter
import com.example.guilherme.coderswag.R
import com.example.guilherme.coderswag.Services.DataService
import com.example.guilherme.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    private lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        val orientation = resources.configuration.orientation
        val spanCount = when(orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> 3
            else -> 2
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        product_listview.layoutManager = layoutManager
        product_listview.adapter = adapter
    }
}
