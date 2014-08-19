package com.example.fbattributes;

import java.io.Serializable;

import com.example.informationpreview.String;

public class Education implements Serializable{
	String schoolName;
	public Education () {}
	public Education(String schoolname)
	{
		schoolName=schoolname;
	}
	public void setSchoolName(String schoolname)
	{
		this.schoolName=schoolname;
	}
	public String getSchoolName () {
		return schoolName;
	}

}
