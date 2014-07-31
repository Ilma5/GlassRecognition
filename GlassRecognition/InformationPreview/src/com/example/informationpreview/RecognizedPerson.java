package com.example.informationpreview;

import java.io.Serializable;
import java.util.Date;

public class RecognizedPerson implements Serializable{

	//String IdFriend; //This is not used
	String Birthdate;
	String Name;
	String Surname;
	String Relationship;
	String Hometown;
	String Photo;
	
	//Constructor for -RecognizedPerson-
	//Accepts all the parameters from service
	public RecognizedPerson () {}
	public RecognizedPerson (String name, String surname, String photo, String date, String place, String status) {
		Name=name;
		Surname=surname;
		Photo=photo;
		Hometown=place;
		Birthdate=date;
		Relationship=status;
	}
//Getters and setters ------ NEED GETTER AND SETTER FOR DATE, PLACE, AND RELSSTATUS
	public void setName (String name) {
		this.Name=name;
	}
	public String getName () {
		return Name;
	}
	public void setSurname (String surname) {
		this.Surname=surname;
	}
	public String getSurname () {
		return Surname;
	}
	public void setPhoto (String photo) {
		this.Photo=photo;
	}
	public String getPhoto () {
		return Photo;
	}
	public void setHometown (String place) {
		this.Hometown=place;
	}
	public String getHometown () {
		return Hometown;
	}
	public void setBithDate (String date) {
		this.Birthdate=date;
	}
	public String getBithDate () {
		return Birthdate;
	}
	public void setRelationship (String status) {
		this.Relationship=status;
	}
	public String getRelationship() {
		return Relationship;
	}
//G&S	


	
	
}
