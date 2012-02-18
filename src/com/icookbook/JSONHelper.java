package com.icookbook;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

import android.graphics.Picture;
import android.util.Base64;

public final class JSONHelper {
	
	public static List<Recipe> parseRecipeList(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		final int bufSize = 256;
		char[] buf = new char[bufSize];
		int offset = 0;
		StringBuilder builder = new StringBuilder();
		try {
			while (reader.read(buf, offset, bufSize) != -1) {
				builder.append(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return parseRecipeList(builder.toString());
	}
	
	public static List<Recipe> parseRecipeList(String in) {
		JSONArray arr;
		ArrayList<Recipe> res;
		try {
			arr = (JSONArray)new JSONTokener(in).nextValue();
			res = new ArrayList<Recipe>(arr.length());
			for (int i = 0;i < arr.length();i++) {
				res.add(parseRecipe(arr.getJSONObject(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return res;
	}
	
	public static Recipe parseRecipe(JSONObject obj) throws JSONException {
		int id = obj.getInt("id");
		String name = obj.getString("name");
		String category = obj.getString("category");
		Picture image = parsePicture(obj.getString("image"));
		JSONArray arrSteps = obj.getJSONArray("steps");
		ArrayList<Step> steps = new ArrayList<Step>(arrSteps.length());
		for (int i = 0;i<arrSteps.length();i++) {
			steps.add(parseStep(arrSteps.getJSONObject(i)));
		}
		return new Recipe(id, name, category, image, steps);
	}
	
	public static Step parseStep(JSONObject obj) throws JSONException {
		String name = obj.getString("name");
		int seconds = obj.getInt("seconds");
		String description = obj.getString("desc");
		String temp = obj.getString("image");
		Picture image;
		if (temp == null || temp.equals("")) {
			image = null;
		} else {
			image = parsePicture(temp);
		}
		return new Step(name, description, seconds, image);
	}
	
	public static Picture parsePicture(String in) {
		byte[] pic = Base64.decode(in, Base64.DEFAULT);
		return Picture.createFromStream(new ByteArrayInputStream(pic));
	}
}
