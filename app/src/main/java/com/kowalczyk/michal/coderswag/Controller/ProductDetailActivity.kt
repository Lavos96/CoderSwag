package com.kowalczyk.michal.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kowalczyk.michal.coderswag.Model.Product
import com.kowalczyk.michal.coderswag.R
import com.kowalczyk.michal.coderswag.Utilities.EXTRA_CATEGORY
import com.kowalczyk.michal.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productDetail=intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId=resources.getIdentifier(productDetail.image,"drawable",packageName)
        productDetailImage?.setImageResource(resourceId)
        productDetailName?.text=productDetail.title
        productDetailPrice?.text=productDetail.price
    }
}
