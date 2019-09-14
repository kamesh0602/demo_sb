package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.model.Recipe;

public interface RecipeService {

	public void save(Recipe recipe);
	public List<Recipe> getAllRecipes();
	public void deleteRecipe(Recipe recipe);
	public Optional<Recipe> findById(long id);
	

}
