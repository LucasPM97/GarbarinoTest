package com.example.user.garbarinotest.models

data class PostItem(val id:String, val description:String, val imageUrl:String,
                    val price:Double, val list_price:Double = 0.0, val discount:Float = 0f) {

    val hasDiscount = fun ():Boolean{

        return (discount > 0 && list_price < price)
    }
}