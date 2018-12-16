package com.kowalczyk.michal.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import com.kowalczyk.michal.coderswag.Adapters.CategoryAdapter
import com.kowalczyk.michal.coderswag.Adapters.CategoryRecycleAdapter
import com.kowalczyk.michal.coderswag.Model.Category
import com.kowalczyk.michal.coderswag.R
import com.kowalczyk.michal.coderswag.Services.DataService
import com.kowalczyk.michal.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this,DataService.categories){ category ->
            val productIntent=Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager=LinearLayoutManager(this)
        categoryListView.layoutManager=layoutManager

        //jesli nasze komorki w recycleView nie zmieniaja rozmiarow to dla optymalizacji linia ponizej
        categoryListView.setHasFixedSize(true)


        //Do ListView Adapter z viewHolderem
        /*categoryListView.setOnItemClickListener { parent, view, position, id ->
            val category = DataService.categories[position]
            Toast.makeText(this, "you clicked on ${category.title} cell", Toast.LENGTH_SHORT).show()
        }*/
    }
}