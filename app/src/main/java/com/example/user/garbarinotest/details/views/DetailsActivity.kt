package com.example.user.garbarinotest.details.views

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.user.garbarinotest.R
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.item_product.view.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        intent?.extras?.let {

            val imageUrl:String = it.getString("imageUrl")
            val description:String = it.getString("title")
            val price:Int = it.getInt("price", 0)
            val hasDiscount:Boolean = it.getBoolean("price", false)
            val oldPrice:Int = it.getInt("oldPrice", 0)
            val discount:Int = it.getInt("discount",0)


            txtDetailTitle.text = description
            txtDetailPrice.text = "$ $price"

            Glide.with(this)
                .load("https:${imageUrl}")
                .into(imageDetailHeader)

            if (hasDiscount){
                txtDetailOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                txtDetailOldPrice.text = "$ $oldPrice"
                txtDetailDiscount.text = "${discount}% OFF"
            }
            else{
                detailDiscountLayout.visibility = View.GONE
            }

            detailTagLayout.visibility = View.GONE
        }
    }
}
