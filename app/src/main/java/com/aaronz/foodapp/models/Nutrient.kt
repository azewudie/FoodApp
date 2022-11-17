package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("amount")
    var amount: Double?, // 0.0
    @SerializedName("name")
    var name: String?, // Vitamin B12
    @SerializedName("percentOfDailyNeeds")
    var percentOfDailyNeeds: Double?, // 0.76
    @SerializedName("unit")
    var unit: String? // µg
)