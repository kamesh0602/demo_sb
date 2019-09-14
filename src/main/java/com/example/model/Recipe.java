package com.example.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long oid;
	@NotNull
	private String name, description, imagePath;
	/*
	 * This will be the owning side of the relationship... one recipe can have mulitple ingredients
	 * Similarly one ingredient can be a part of a recipe
	 * oid of this class will be stored in the column recipe_oid in the ingredient class
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "recipe_oid")
	//@JsonIgnore
	private List<Ingredient> ingredients;
}
