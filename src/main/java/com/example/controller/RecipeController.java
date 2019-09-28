package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Ingredient;
import com.example.model.Recipe;
import com.example.services.IngredientService;
import com.example.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private IngredientService ingredientService;

	@GetMapping(value = "/getRecipe")
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<Recipe> getAllRecipe() {

		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes = recipeService.getAllRecipes();
		log.info("recipe size:" + recipes.size());
		recipes.stream().forEach(s -> log.info("recipe name-->" + s.getName()));
		return recipes;
	}

	@GetMapping(value = "/getIngredient")
	public List<Ingredient> getAllIngredient() {

		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients = ingredientService.getAllIngredients();
		return ingredients;
	}

	/*
	 * @PostMapping(value = "/saveRecipe", consumes = "application/json", produces =
	 * "application/json") public void saveRecipe(@RequestBody List<Recipe> recipes)
	 * { for(Recipe r:recipes) { Recipe recip =
	 * Recipe.builder().description(r.getDescription()).imagePath(r.getImagePath()).
	 * name(r.getName()) .name(r.getName()).build(); recipeService.save(recip);
	 * r.getIngredients().stream().map(i -> { i.setRecipe(recip); return i;
	 * }).forEach(ing -> ingredientService.save(ing)); } }
	 */
	
	@PutMapping(value = "/saveRecipes", consumes = "application/json", produces = "application/json")
	public void updateRecipes(@RequestBody List<Recipe> recipes) {
		for(Recipe r:recipes) {
			Recipe recip = Recipe.builder().description(r.getDescription()).imagePath(r.getImagePath()).name(r.getName())
					.name(r.getName()).build();
			recipeService.save(recip);
			r.getIngredients().stream().map(i -> {
				i.setRecipe(recip);
				return i;
			}).forEach(ing -> ingredientService.save(ing));
		}
	}
	
	@PostMapping(value = "/saveRecipe", consumes = "application/json", produces = "application/json")
	public void saveRecipe(@RequestBody Recipe r) {
		
			Recipe recip = Recipe.builder().description(r.getDescription()).imagePath(r.getImagePath()).name(r.getName())
					.name(r.getName()).build();
			recipeService.save(recip);
			r.getIngredients().stream().map(i -> {
				i.setRecipe(recip);
				return i;
			}).forEach(ing -> ingredientService.save(ing));
		
	}
	
	
	@DeleteMapping(value = "/deleteRecipe/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		log.info("inside the delete recipe");
        Recipe recipe = recipeService.findById(id).get();

        if (recipe == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        recipeService.deleteRecipe(recipe);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
