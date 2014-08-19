package com.example.fbattributes;

import java.io.Serializable;

public class Favorite_team implements Serializable{
	String name;

	public Favorite_team () {}
	public Favorite_team(String teamname)
	{
		name=teamname;

	}
	public void setName(String teamname)
	{
		this.name=teamname;
	}
	public String getName () {
		return name;
	}


}
