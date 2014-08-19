package com.example.fbattributes;

import java.io.Serializable;

public class Favorite_athlete implements Serializable{
	String name;
	String id;	public Favorite_athlete () {}
	public Favorite_athlete(String firstname)
	{
		name=firstname;
		
	}
	public void setName(String firstname)
	{
		this.name=firstname;
	}
	public String getName () {
		return name;
	}


}
