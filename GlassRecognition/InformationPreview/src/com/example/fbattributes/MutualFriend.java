package com.example.fbattributes;

import java.io.Serializable;

public class MutualFriend implements Serializable{
	String name;
	String id;
	public MutualFriend () {}
	public MutualFriend(String fullname, String ident)
	{
		name=fullname;
		id=ident;
	}
	public void setName(String fullname)
	{
		this.name=fullname;
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
