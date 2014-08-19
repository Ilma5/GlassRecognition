package com.example.fbattributes;

import java.io.Serializable;

public class Future_event implements Serializable{

	String name;
	public Future_event() {}
	public Future_event(String eventname)
	{
		name=eventname;

	}
	public void setName(String eventname)
	{
		this.name=eventname;
	}
	public String getName () {
		return name;
	}


}
