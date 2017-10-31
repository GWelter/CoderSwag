package com.example.guilherme.coderswag.Services

import com.example.guilherme.coderswag.Model.Category
import com.example.guilherme.coderswag.Model.Product

/**
 * Created by guilherme on 29/10/17.
 */
object DataService {

    val categories = listOf(
            Category("SHIRTS", "shirtimage"),
            Category("HOODIES", "hoodieimage"),
            Category("HATS", "hatimage"),
            Category("DIGITAL", "digitalgoodsimage")
    )

    val hats = listOf(
            Product("Devslopoes Graphic Beanie", "$18", "hat1"),
            Product("Devslopoes Hat Black", "$20", "hat2"),
            Product("Devslopoes Hat White", "$20", "hat3"),
            Product("Devslopoes Hat Snapback", "$22", "hat4")
    )

    val hoodies = listOf(
            Product("Devslopes Hoodie Gray", "$28", "hoodie1"),
            Product("Devslopes Hoodie Red", "$32", "hoodie2"),
            Product("Devslopes Gray Hoodie", "$30", "hoodie3"),
            Product("Devslopes Hoodie Black", "$25", "hoodie4")
    )

    val shirts = listOf(
            Product("Devslopes Shirt Black", "$18", "shirt1"),
            Product("Devslopes Shirt Red", "$22", "shirt2"),
            Product("Devslopes Shirt Hoodie", "$25", "shirt3"),
            Product("Devslopes Shirt Black", "$23", "shirt4"),
            Product("Kickflip Studios", "$27", "shirt5")
    )

    val digitalGood = listOf<Product>()

    fun getProducts(category: String) : List<Product> {
        return when(category){
            "SHIRTS" -> shirts
            "HOODIES" -> hoodies
            "HATS" -> hats
            else -> digitalGood
        }
    }
}