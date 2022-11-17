package com.aaronz.foodapp.data

import com.aaronz.foodapp.data.network.FoodRecipesAPi
import com.aaronz.foodapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesAPi: FoodRecipesAPi
) {

    suspend fun getRecipes(queries:Map<String,String>):Response<FoodRecipe>{
        return foodRecipesAPi.getRecipes(queries)
    }
}