package com.example.repositry;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Recipe;

@Repository
@Transactional

public interface RecipeCrud extends PagingAndSortingRepository<Recipe, Long> {
	Recipe findByName(String name);
}
