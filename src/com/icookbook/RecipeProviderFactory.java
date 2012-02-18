package com.icookbook;

import android.content.Context;

public class RecipeProviderFactory {
	
	public static RecipeProvider getProvider(String name, Context context) {
		return new ResourceRecipeProvider(context);
	}
}
