package com.example.user.garbarinotest.models

data class PostItem(val id:Int,val description:String,val imageUrl:String,
                    val price:Float,val list_price:Float, val discount:Float) {

    val hasDiscount = fun ():Boolean{

        return (discount > 0 && list_price != price)
    }
}