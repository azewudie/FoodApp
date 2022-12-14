package com.aaronz.foodapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aaronz.foodapp.models.FoodRecipe
import com.aaronz.foodapp.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(var foodRecipe: FoodRecipe){
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}