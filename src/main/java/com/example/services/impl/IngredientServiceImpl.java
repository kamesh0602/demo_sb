package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Ingredient;
import com.example.repositry.IngredientCrud;
import com.example.services.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService{

	@Autowired
	private IngredientCrud ingredientCrud;
	
	@Override
	public List<Ingredient> getAllIngredients() {
		return (List<Ingredient>) ingredientCrud.findAll();
	}

	@Override
	public void save(Ingredient ing1) {
		ingredientCrud.save(ing1);
		
	}
	
}
