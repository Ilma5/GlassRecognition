package com.example.fbattributes;

import java.io.Serializable;

public class MutualFriend implements Serializable{
	String name;
	public MutualFriend () {}
	public MutualFriend(String fullname)
	{
		name=fullname;
	}
	public void setName(String fullname)
	{
		this.name=fullname;
	}
	public String getName () {
		return name;
	}



}
