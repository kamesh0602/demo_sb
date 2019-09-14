package com.example.repositry;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.model.Ingredient;

@RepositoryRestResource(path="ingredient", collectionResourceRel = "ingredient")
@Transactional
public interface IngredientCrud extends PagingAndSortingRepository<Ingredient, Long>{

}
