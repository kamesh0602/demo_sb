package com.example.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.model.Ingredient;
import com.example.model.Recipe;

@Component
public class Init implements ApplicationRunner {

	@Autowired
	private RecipeService recipeService;
	@Autowired
	private IngredientService ingredientService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Hiiiiii!!!!!!!!Inside the application init--------->");

		if(recipeService.getAllRecipes().isEmpty() && ingredientService.getAllIngredients().isEmpty()) {
//			Recipe recipe = new Recipe();
//			recipe.setDescription("Tasty Pizza Recipe");
//			recipe.setImagePath("https://www.imageworld.com/chessy_pizza");
//			recipe.setName("Pizza");
//			recipe.setOid(1l);
//			recipeService.save(recipe);
//
//			Ingredient ing = new Ingredient();
//			ing.setAmount(123);
//			ing.setName("Cheese");
//			ing.setOid(2l);
//			ing.setRecipe(recipe);
//			ingredientService.save(ing);
			
		}
		
	}

}
