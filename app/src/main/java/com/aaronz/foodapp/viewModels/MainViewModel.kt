package com.aaronz.foodapp.viewModels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.*
import com.aaronz.foodapp.data.Repository
import com.aaronz.foodapp.data.database.RecipesEntity
import com.aaronz.foodapp.models.FoodRecipe
import com.aaronz.foodapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

// in here the view should extend the viewModel but we need application
// reference so we extend AndroidViewModel
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    // create mutable data reference to check the internet work
    /**
     * Room data base
     */

    val readRecipe: LiveData<List<RecipesEntity>> = repository.local.readDatabase().asLiveData()

    private fun insertRecipes(recipesEntity: RecipesEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertRecipes(recipesEntity)
        }
    /**
     * Retrofit
     */
    var recipesResponse: MutableLiveData<NetworkResult<FoodRecipe>> = MutableLiveData()

    fun getRecipes(queries: Map<String,String>) = viewModelScope.launch {
        getRecipesSafeCall(queries)
    }

    private suspend fun getRecipesSafeCall(queries: Map<String, String>) {
        recipesResponse.value = NetworkResult.Loading()
        if(hasInternetConnection()){
            try {
                val response = repository.remote.getRecipes(queries)
                recipesResponse.value = handleFoodRecipesResponse(response)
                val foodRecipe = recipesResponse.value!!.data
                if(foodRecipe !=null){
                    offlineCacheRecipes(foodRecipe)
                }
            }catch (e:Exception){
                recipesResponse.value = NetworkResult.Error("Recipes is not found")

            }

        }else{
            recipesResponse.value = NetworkResult.Error(message = "No Internet connection")
        }

    }

    private fun offlineCacheRecipes(foodRecipe: FoodRecipe) {
        val recipesEntity =  RecipesEntity(foodRecipe)
        insertRecipes(recipesEntity)

    }

    private fun handleFoodRecipesResponse(response: Response<FoodRecipe>):
            NetworkResult<FoodRecipe>? {
        when{
            response.message().toString().contains("timeout") ->{
                return NetworkResult.Error("TimeOut")

            }
            response.code() == 402 ->{
                return NetworkResult.Error("API key Limited")
            }
            response.body()!!.results.isEmpty() ->{
                return NetworkResult.Error("Recipes not found")
            }
            response.isSuccessful -> {
                val foodRecipes = response.body()
                return NetworkResult.Success(foodRecipes!!)
            }
            else ->{
                return NetworkResult.Error(response.message())
            }
        }

    }

    // check internet  connection
    private fun hasInternetConnection():Boolean{
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        )as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?:return false

        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)?:return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ->true
            else -> false
        }
    }

}