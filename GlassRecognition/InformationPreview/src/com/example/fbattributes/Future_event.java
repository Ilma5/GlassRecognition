package com.example.fbattributes;

import java.io.Serializable;

public class Future_event implements Serializable{

	String name;
	String locationCountry;
    String locationCity;
    String locationStreet;
    String date ;
    String time ;
	public Future_event() {}
	public Future_event(String eventname, String country, String City, String Street, String _date, String Time)
	{
		name=eventname;
		locationCountry=country;
		locationCity=City;
		locationStreet=Street;
		date=_date;
		time=Time;

	}
	public void setName(String eventname)
	{
		this.name=eventname;
	}
	public String getName () {
		return name;
	}
	public void setLocationCountry(String country)
	{
		this.locationCountry=country;
	}
	public String getLocationCountry () {
		return locationCountry;
	}
	public void setLocationCity(String City)
	{
		this.locationCity=City;
	}
	public String getLocationCity () {
		return locationCity;
	}
	public void setLocationStreet(String Street)
	{
		this.locationStreet=Street;
	}
	public String getLocatioStreet () {
		return locationStreet;
	}
	public void setTime(String _time)
	{
		this.time=_time;
	}
	public String getTime () {
		return time;
	}
	public void setDate(String _date)
	{
		this.date=_date;
	}
	public String getDate () {
		return date;
	}


}
