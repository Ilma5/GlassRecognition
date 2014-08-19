package com.example.fbattributes;

import java.io.Serializable;

public class Language implements Serializable{
	String name;
	public Language () {}
	public Language(String language)
	{
		name=language;
	}
	public void setName(String language)
	{
		this.name=language;
	}
	public String getName () {
		return name;
	}
	
}
