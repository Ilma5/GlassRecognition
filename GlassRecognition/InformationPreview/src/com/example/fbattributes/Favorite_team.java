package com.example.fbattributes;

import java.io.Serializable;

public class Favorite_team implements Serializable{
	String name;
	String id;
	public Favorite_team () {}
	public Favorite_team(String teamname, String ident)
	{
		name=teamname;
		id=ident;
	}
	public void setName(String teamname)
	{
		this.name=teamname;
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
