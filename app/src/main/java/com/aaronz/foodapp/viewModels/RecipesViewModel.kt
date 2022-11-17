package com.aaronz.foodapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.aaronz.foodapp.util.Constants
import com.aaronz.foodapp.util.Constants.Companion.API_KEY
import com.aaronz.foodapp.util.Constants.Companion.Query_ADDRECIPEINFORMATION
import com.aaronz.foodapp.util.Constants.Companion.Query_APIKEY
import com.aaronz.foodapp.util.Constants.Companion.Query_DIET
import com.aaronz.foodapp.util.Constants.Companion.Query_FILLINGREDIENTS
import com.aaronz.foodapp.util.Constants.Companion.Query_NUMBER
import com.aaronz.foodapp.util.Constants.Companion.Query_TYPE


class RecipesViewModel(application: Application):AndroidViewModel(application) {
 fun applyQueries():HashMap<String,String>{
        val queries:HashMap<String,String> = HashMap()
        queries[Query_NUMBER] = "50"
        queries[Query_APIKEY] = API_KEY
        queries[Query_TYPE] = "snack"
        queries[Query_DIET] = "vegan"
        queries[Query_FILLINGREDIENTS] = "true"
        queries[Query_ADDRECIPEINFORMATION] = "true"
        return queries
    }


}