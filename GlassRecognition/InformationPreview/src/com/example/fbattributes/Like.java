package com.example.fbattributes;

import java.io.Serializable;

public class Like implements Serializable{
	String category;
    String name;
    String created_time;

    public Like () {}
	public Like(String cat, String _name, String created)
	{
		category=cat;
		name=_name;
		created_time=created;

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
	public String getTime()
	{
		return created_time;
	}


}
