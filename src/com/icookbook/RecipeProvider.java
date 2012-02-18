package com.icookbook;

import java.util.Iterator;

public abstract class RecipeProvider {
	
	public abstract Recipe getRecipe(int id);
	
	public abstract Iterator<Recipe> iterRecipes();
	
	public abstract void save(Recipe r);
}
