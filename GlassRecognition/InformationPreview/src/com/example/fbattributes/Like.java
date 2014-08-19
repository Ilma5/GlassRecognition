package com.example.fbattributes;

import java.io.Serializable;

public class Like implements Serializable{
	String category;
    String name;
    String created_time;
    String id;
    public Like () {}
	public Like(String cat, String _name, String created, String ident)
	{
		category=cat;
		name=_name;
		created_time=created;
		id=ident;
	}
	public void setCategory(String cat)
	{
		this.category=cat;
	}
	public String getCategory () {
		return category;
	}
	public void setName(String _name)
	{
		this.name=_name;
	}
	public String getName () {
		return name;
	}
	public void setTime(String created)
	{
		this.created_time=created;
	}
	public void getTime()
	{
		return created_time;
	}
	public void setId(String ident)
	{
		this.id=ident;
	}
	public String getId () {
		return id;
	}

}
