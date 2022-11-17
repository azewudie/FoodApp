package com.aaronz.foodapp.util

class Constants {
   // https://api.spoonacular.com/
   // recipes/complexSearch?
   // number=1&
   // apiKey=4c665c6780604d0b9d379b539ea6f915&
   // type=fingerfood&
   // diet=vegan&
   // addRecipeNutrition=true&
   // addRecipeInformation=true
    companion object{
       const val BASE_URL = "https://api.spoonacular.com/"
       const val API_KEY = "4c665c6780604d0b9d379b539ea6f915"

       //API Query keys
       const val Query_NUMBER = "Number"
       const val Query_APIKEY = "apiKey"
       const val Query_TYPE = "type"
       const val Query_DIET = "diet"
       const val Query_FILLINGREDIENTS = "fillIngredients"
       const val Query_ADDRECIPEINFORMATION = "addRecipeInformation"

      // Room Data Base
      const val DATABASE_NAME = "recipes_database"
      const val RECIPES_TABLE = "recipes_table"



    }

}