package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class CaloricBreakdown(
    @SerializedName("percentCarbs")
    var percentCarbs: Double?, // 62.29
    @SerializedName("percentFat")
    var percentFat: Double?, // 20.04
    @SerializedName("percentProtein")
    var percentProtein: Double? // 17.67
)