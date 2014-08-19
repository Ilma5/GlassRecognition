package com.example.fbattributes;

import java.io.Serializable;

public class Group implements Serializable{
	String name;
	String id;
	public Group () {}
	public Group(String groupname, String ident)
	{
		name=groupname;
		id=ident;
	}
	public void setName(String groupname)
	{
		this.name=groupname;
	}
	public String getName () {
		return name;
	}
	public void setSchoolName(String ident)
	{
		this.id=ident;
	}
	public String getId () {
		return id;
	}
}
