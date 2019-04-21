package com.example.user.garbarinotest.details.views

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.user.garbarinotest.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        intent?.extras?.let {

            val description:String = it.getString("title")
            val price:Int = it.getInt("price", 0)
            val hasDiscount:Boolean = it.getBoolean("price", false)
            val oldPrice:Int = it.getInt("oldPrice", 0)
            val discount:Int = it.getInt("discount",0)


            txtDetailTitle.text = description
            txtDetailPrice.text = "$ $price"

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
