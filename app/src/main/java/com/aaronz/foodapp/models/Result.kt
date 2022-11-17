package com.aaronz.foodapp.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("aggregateLikes")
    var aggregateLikes: Int?, // 1
    @SerializedName("cheap")
    var cheap: Boolean?, // false
    @SerializedName("cuisines")
    var cuisines: List<String>?,
    @SerializedName("dairyFree")
    var dairyFree: Boolean?, // true
    @SerializedName("dishTypes")
    var dishTypes: List<String>?,
    @SerializedName("glutenFree")
    var glutenFree: Boolean?, // false
    @SerializedName("id")
    var id: Int?, // 1095745
    @SerializedName("image")
    var image: String?, // https://spoonacular.com/recipeImages/1095745-312x231.jpg
    @SerializedName("readyInMinutes")
    var readyInMinutes: Int?, // 30
    @SerializedName("sourceName")
    var sourceName: String?, // Foodista
    @SerializedName("sourceUrl")
    var sourceUrl: String?, // https://www.foodista.com/recipe/DMRJSD86/mushroom-crostini-with-harissa-hummus
    @SerializedName("summary")
    var summary: String?, // The recipe Mushroom Hummus Crostini can be made <b>in about 30 minutes</b>. For <b>$2.41 per serving</b>, this recipe <b>covers 31%</b> of your daily requirements of vitamins and minerals. One serving contains <b>468 calories</b>, <b>21g of protein</b>, and <b>10g of fat</b>. This recipe serves 4. 1 person were impressed by this recipe. It works well as a rather inexpensive hor d'oeuvre. A mixture of lemon juice, hummus, hummus, and a handful of other ingredients are all it takes to make this recipe so scrumptious. It is a good option if you're following a <b>dairy free, lacto ovo vegetarian, and vegan</b> diet. It is brought to you by Foodista. This recipe is typical of Mediterranean cuisine. All things considered, we decided this recipe <b>deserves a spoonacular score of 89%</b>. This score is super. If you like this recipe, take a look at these similar recipes: <a href="https://spoonacular.com/recipes/hummus-and-cucumber-crostini-22985">Hummus And Cucumber Crostini</a>, <a href="https://spoonacular.com/recipes/seared-tuna-with-hummus-on-crostini-386082">Seared Tuna with Hummus on Crostini</a>, and <a href="https://spoonacular.com/recipes/beet-hummus-and-caramelized-onion-crostini-703941">Beet Hummus and Caramelized Onion Crostini</a>.
    @SerializedName("sustainable")
    var sustainable: Boolean?, // false
    @SerializedName("title")
    var title: String?, // Mushroom Hummus Crostini
    @SerializedName("vegan")
    var vegan: Boolean?, // true
    @SerializedName("vegetarian")
    var vegetarian: Boolean?, // true
    @SerializedName("veryHealthy")
    var veryHealthy: Boolean?, // true

)