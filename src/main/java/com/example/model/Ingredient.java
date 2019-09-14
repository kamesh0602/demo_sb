package com.example.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private long oid;
	@NotNull
	private String name;
	@NotNull
	private int amount;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@NotNull
	private Recipe recipe;
}
