package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class FoodRecipe(
//    @SerializedName("number")
//    var number: Int?, // 1
//    @SerializedName("offset")
//    var offset: Int?, // 0
    @SerializedName("results")
    var results: List<Result>,
//    @SerializedName("totalResults")
//    var totalResults: Int? // 3
)