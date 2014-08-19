package com.example.fbattributes;

import java.io.Serializable;

public class Future_event implements Serializable{
	String name;
	String id;
	public Future_event() {}
	public Future_event(String eventname, String ident)
	{
		name=eventname;
		id=ident;
	}
	public void setName(String eventname)
	{
		this.name=eventname;
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
