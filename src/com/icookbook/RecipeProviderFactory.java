package com.icookbook;

import android.content.Context;

public class RecipeProviderFactory {
	
	public RecipeProvider getProvider(String name, Context context) {
		return new ResourceRecipeProvider(context);
	}
}
