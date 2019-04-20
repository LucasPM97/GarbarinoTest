package com.example.user.garbarinotest.models

data class PostItem(val id:String, val description:String, val imageUrl:String,
                    val price:Int, val list_price:Int = 0, val discount:Int = 0) {

    val hasDiscount = fun ():Boolean{

        return (discount > 0 && list_price > price)
    }
}