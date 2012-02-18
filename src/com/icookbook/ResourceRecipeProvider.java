package com.icookbook;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;

public class ResourceRecipeProvider extends RecipeProvider {
	
	public List<Recipe> recipes;
	
	public ResourceRecipeProvider(Context context) {
		Resources res = context.getResources();
		recipes = JSONHelper.parseRecipeList(res.openRawResource(R.raw.recipes));
	}

	@Override
	public Recipe getRecipe(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Recipe> iterRecipes() {
		return recipes.iterator();
	}

	@Override
	public void save(Recipe r) {
		// TODO Auto-generated method stub

	}

}
