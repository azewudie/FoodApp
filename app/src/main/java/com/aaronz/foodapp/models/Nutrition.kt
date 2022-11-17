package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class Nutrition(
    @SerializedName("caloricBreakdown")
    var caloricBreakdown: CaloricBreakdown?,

    @SerializedName("ingredients")
    var ingredients: List<IngredientX>?,
    @SerializedName("weightPerServing")
    var weightPerServing: WeightPerServing?
)