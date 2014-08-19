package com.example.fbattributes;

import java.io.Serializable;

public class Last_checkin implements Serializable{
	String message;
    String location;
    String time;
	public Last_checkin () {}
	public Last_checkin(String msg, String place, String _time)
	{
		message=msg;
		location=place;
		time=_time;
	}
	public void setMessage(String msg)
	{
		this.message=msg;
	}
	public String getMessage () {
		return message;
	}
	public void setLocation(String place)
	{
		this.location=place;
	}
	public String getLocation () {
		return location;
	}
	public void setTime(String _time)
	{
		this.time=_time;
	}
	public void getTime()
	{
		return time;
	}

}
