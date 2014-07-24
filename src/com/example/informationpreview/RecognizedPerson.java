package com.example.informationpreview;

import java.io.Serializable;
import java.util.Date;

public class RecognizedPerson implements Serializable{

	int id; //This is not used
	String birthDateRecPer;
	String nameRecPer;
	String surnameRecPer;
	String relationSStatusRecPer;
	String placeRecPer;
	String photoRecPer;
	
	//Constructor for -RecognizedPerson-
	//Accepts all the parameters from service
	public RecognizedPerson () {}
	public RecognizedPerson (String name, String surname, String photo, String date, String place, String status) {
		nameRecPer=name;
		surnameRecPer=surname;
		photoRecPer=photo;
		placeRecPer=place;
		birthDateRecPer=date;
		relationSStatusRecPer=status;
	}
//Getters and setters ------ NEED GETTER AND SETTER FOR DATE, PLACE, AND RELSSTATUS
	public void setNameRecPer (String name) {
		this.nameRecPer=name;
	}
	public String getNameRecPer () {
		return nameRecPer;
	}
	public void setSurnameRecPer (String surname) {
		this.surnameRecPer=surname;
	}
	public String getSurnameRecPer () {
		return surnameRecPer;
	}
	public void setPhotoRecPer (String photo) {
		this.photoRecPer=photo;
	}
	public String getPhotoRecPer () {
		return photoRecPer;
	}
	public void setPlaceRecPer (String place) {
		this.placeRecPer=place;
	}
	public String getPlaceRecPer () {
		return placeRecPer;
	}
	public void setBithDateRecPer (String date) {
		this.birthDateRecPer=date;
	}
	public String getBithDateRecPer () {
		return birthDateRecPer;
	}
	public void setRelationSStatusRecPer (String status) {
		this.relationSStatusRecPer=status;
	}
	public String getRelationSStatusRecPer () {
		return relationSStatusRecPer;
	}
//G&S	


	
	
}
