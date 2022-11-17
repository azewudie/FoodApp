package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class IngredientX(
    @SerializedName("amount")
    var amount: Double?, // 0.25
    @SerializedName("id")
    var id: Int?, // 10018029
    @SerializedName("name")
    var name: String?, // crusty bread
    @SerializedName("nutrients")
    var nutrients: List<Nutrient?>?,
    @SerializedName("unit")
    var unit: String? // loaf
)