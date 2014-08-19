package com.example.fbattributes;

import java.io.Serializable;

public class Television implements Serializable{
	String Category;
    String name;
    String created_time;

    public Television () {}
	public Television(String cat, String _name, String created)
	{
		Category=cat;
		name=_name;
		created_time=created;

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
	public String getTime()
	{
		return created_time;
	}


}
