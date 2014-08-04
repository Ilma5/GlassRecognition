package com.example.informationpreview;

import java.io.Serializable;
import java.util.Date;

public class RecognizedPerson implements Serializable{

	//String IdFriend; //This is not used
	String birthday;
	String first_name;
	String last_name;
	String relationship_status;
	String city;
	String picture;
	
	//Constructor for -RecognizedPerson-
	//Accepts all the parameters from service
	public RecognizedPerson () {}
	public RecognizedPerson (String name, String surname, String date, String place, String status, String pic) {
		first_name=name;
		last_name=surname;
		picture=pic;
		city=place;
		birthday=date;
		relationship_status=status;
	}
//Getters and setters ------ 
	public void setFirstName (String first_name) {
		this.first_name=first_name;
	}
	public String getFirstName () {
		return first_name;
	}
	public void setLastName (String last_name) {
		this.last_name=last_name;
	}
	public String getLastName () {
		return last_name;
	}
	public void setPicture (String picture) {
		this.picture=picture;
	}
	public String getPicture () {
		return picture;
	}
	public void setCity (String place) {
		this.city=place;
	}
	public String getCity () {
		return city;
	}
	public void setBithday (String date) {
		this.birthday=date;
	}
	public String getBithday () {
		return birthday;
	}
	public void setRelationship (String status) {
		this.relationship_status=status;
	}
	public String getRelationship() {
		return relationship_status;
	}
//G&S	


	
	
}
