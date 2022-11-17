package com.aaronz.foodapp.data.network

import com.aaronz.foodapp.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesAPi {

    //https://api.spoonacular.com/recipes/complexSearch
    @GET("recipes/complexSearch")
    // specify the query's
    // tow ways to do this: one : add one by one , 2: use QueryMap
    // suspend using corritun background thread
    suspend fun getRecipes(
        @QueryMap query:Map<String,String>
    ):Response<FoodRecipe> // return model class

}