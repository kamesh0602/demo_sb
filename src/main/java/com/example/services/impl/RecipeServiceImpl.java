package com.example.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Recipe;
import com.example.repositry.RecipeCrud;
import com.example.services.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeCrud recipeCrud;

	@Override
	public void save(Recipe recipe) {
		recipeCrud.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return (List<Recipe>) recipeCrud.findAll();
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		recipeCrud.delete(recipe);		
	}

	@Override
	public Optional<Recipe> findById(long id) {
		return recipeCrud.findById(id);
		
	}


	
}
