package com.example.fbattributes;

import java.io.Serializable;

public class Event implements Serializable{
	 String location;
     String name;
     String start_time;
     String rsvp_status;
	public Event () {}
	public Event(String loc, String _name, String startTime, String status)

	{
		location=loc;
		name=_name;
		start_time=startTime;
		rsvp_status=status;
	}
	public void setLocation(String loc)
	{
		this.location=loc;
	}
	public String getLocation () {
		return location;
	}
	public void setname(String _name)
	{
		this.name=_name;
	}
	public String getname () {
		return name;
	}
	public void setStartTime(String startTime)
	{
		this.start_time=startTime;
	}
	public String getStartTime () {
		return start_time;
	}
	
	public void setStatus(String status)
	{
		this.rsvp_status=status;
	}
	public String getStatus () {
		return rsvp_status;
	}
	

}
