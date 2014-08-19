package com.example.fbattributes;

import java.io.Serializable;

public class Favorite_athlete implements Serializable{
	String name;
	String id;
	public Favorite_athlete () {}
	public Favorite_athlete(String firstname, String ident)
	{
		name=firstname;
		id=ident;
	}
	public void setName(String firstname)
	{
		this.name=firstname;
	}
	public String getName () {
		return name;
	}
	public void setId(String ident)
	{
		this.id=ident;
	}
	public String getId () {
		return id;
	}

}
