package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Ingredient;


public interface IngredientService {

	
	public List<Ingredient> getAllIngredients();

	public void save(Ingredient ing1);
}
