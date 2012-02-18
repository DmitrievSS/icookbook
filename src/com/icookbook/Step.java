package com.icookbook;

import android.graphics.Picture;

public class Step {
	
	private String name;
	private int seconds;
	private Picture image;
	private String description;
	
	public Step(String name, String description, int seconds, Picture image) {
		this.name = name;
		this.description = description;
		this.seconds = seconds;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if (seconds < 0)
			throw new IllegalArgumentException();
		this.seconds = seconds;
	}

	public Picture getImage() {
		return image;
	}

	public void setImage(Picture image) {
		if (image == null)
			throw new IllegalArgumentException();
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null)
			throw new IllegalArgumentException();
		this.description = description;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Step))
			return false;
		Step s = (Step)obj;
		return name.equals(s.name)
				&& description.equals(s.description)
				&& seconds == s.seconds
				&& ((image == null && s.image == null)
					||( image.equals(s.image)));
	}
}
