package com.example.fbattributes;

import java.io.Serializable;

public class Sport implements Serializable{
	String SportsName;
	public Sport() {}
	public Sport(String sportname)
	{
		SportsName=sportname;
	}
	public void setSport(String sportname)
	{
		this.SportsName=sportname;
	}
	public String getSport() {
		return SportsName;
	}

}
