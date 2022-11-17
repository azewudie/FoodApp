package com.aaronz.foodapp.ui.fragments.recipes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaronz.foodapp.viewModels.MainViewModel
import com.aaronz.foodapp.R
import com.aaronz.foodapp.adapters.RecipesAdapter
import com.aaronz.foodapp.util.NetworkResult
import com.aaronz.foodapp.util.observeOnce
import com.aaronz.foodapp.viewModels.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.view.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private lateinit var recipesViewModel: RecipesViewModel

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mView: View
    private val mAdapter by lazy { RecipesAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_recipes, container, false)

        setupRecyclerView()
        readDatabase()
        return mView

    }

    private fun readDatabase() {
       lifecycleScope.launch {
           mainViewModel.readRecipe.observeOnce(viewLifecycleOwner) { database ->
               if (database.isNotEmpty()) {
                   Log.d("readRecipesFragment","read requestAPiData called!")
                   mAdapter.setData(database[0].foodRecipe)
               }else{
                   requestApiData()
               }
           }
       }
    }

    private fun requestApiData() {
        Log.d("recipesFragment","requestAPiData called!")
        mainViewModel.getRecipes(recipesViewModel.applyQueries())
        mainViewModel.recipesResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    loadDataFromCache()
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading -> {
                    showShimmerEffect()


                }

            }

        }
    }


    private fun setupRecyclerView() {
        mView.rv_recipes.adapter = mAdapter
        mView.rv_recipes.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()


    }

    private fun loadDataFromCache(){
        lifecycleScope.launch {
            mainViewModel.readRecipe.observe(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    mAdapter.setData(database[0].foodRecipe)

                }

            }
        }
    }

    private fun showShimmerEffect() {
//        mView.shimmer_view_container?.showShimmer(true)

    }

    private fun hideShimmerEffect() {
//        mView.shimmer_view_container.hideShimmer()

    }


}