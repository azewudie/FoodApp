package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class WeightPerServing(
    @SerializedName("amount")
    var amount: Int?, // 354
    @SerializedName("unit")
    var unit: String? // g
)