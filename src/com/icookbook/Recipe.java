package com.icookbook;

import java.util.List;

public class Recipe {
	
	private int id;
	private String name;
	private List<Step> steps;
	private String category;
	
	public Recipe(int id, String name, String category, List<Step> steps) {
		this.id= id;
		this.name = name;
		this.category = category;
		this.steps = steps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Recipe))
			return false;
		Recipe r = (Recipe)obj;
		return id == r.id && name.equals(r.name) && steps.equals(r.steps);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		if (category == null)
			throw new IllegalArgumentException();
		this.category = category;
	}
}
