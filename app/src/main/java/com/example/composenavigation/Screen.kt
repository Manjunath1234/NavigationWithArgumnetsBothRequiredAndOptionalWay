package com.example.composenavigation

const val DETAIL_SCREEN_KEY1 = "id"
const val DETAIL_SCREEN_KEY2 = "name"

sealed class Screen(val route:String) {
    object Home:Screen("home_screen")

    object Detail:Screen("detail_screen/{id}/{name}"){
         fun passIdandName(id: Int,name: String):String{
             //required arguments with multiple values
             return "detail_screen/$id/$name"
         }
        fun passIdAndName(id:Int = 0, name:String = "ABC") :String{
            //optional arguments with multiple values
            return "detail_screen/id=$id&name=$name"
        }
    }

}