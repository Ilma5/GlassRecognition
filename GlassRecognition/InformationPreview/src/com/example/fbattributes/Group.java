package com.example.fbattributes;

import java.io.Serializable;

public class Group implements Serializable{
	String name;

	public Group () {}
	public Group(String groupname)
	{
		name=groupname;

	}
	public void setName(String groupname)
	{
		this.name=groupname;
	}
	public String getName () {
		return name;
	}


}
