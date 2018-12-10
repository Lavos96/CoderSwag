package com.kowalczyk.michal.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.kowalczyk.michal.coderswag.Model.Category
import com.kowalczyk.michal.coderswag.R
import com.kowalczyk.michal.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter:ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,
            DataService.categories)
        categoryListView.adapter=adapter
    }
}
