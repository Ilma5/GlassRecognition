package com.example.fbattributes;

import java.io.Serializable;

public class Television implements Serializable{
	String Category;
    String name;
    String created_time;
    String id;
    public Television () {}
	public Television(String cat, String _name, String created, String ident)
	{
		Category=cat;
		name=_name;
		created_time=created;
		id=ident;
	}
	public void setCategory(String cat)
	{
		this.Category=cat;
	}
	public String getCategory () {
		return Category;
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
