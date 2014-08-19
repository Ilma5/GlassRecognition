package com.example.fbattributes;

import java.io.Serializable;

public class Work implements Serializable{
	String EmployerName;
	public Work () {}
	public Work(String employer)
	{
		EmployerName=employer;
	}
	public void setSchoolName(String employer)
	{
		this.EmployerName=employer;
	}
	public String getSchoolName () {
		return EmployerName;
	}
}
