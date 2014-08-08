package com.example.informationpreview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecognizedPerson implements Serializable{

	//String IdFriend; //This is not used
	String birthday;
	String first_name;
	String last_name;
	String relationship_status;
	String city;
	String picture;
	
	String FBusername;
	String interests;
	String religion;
	String quotes;
	String political;
	List<String> education;
	String music;
	List<String> sports;
	String tv;
	String movies;
	String books;
	List<String> languages;
	List <String> work;
	List <String> future_events;
	List <String> last_checkins;
	String about_me;
	List<String> favorite_athletes;
	List<String> favorite_teams;
	List<String> groups;
	List<String> television;
	String bio;
	String inspirational_people;
	List<String> likes;
	List<String> events;
	List<String> mutual_friends;
	
	
	
	
	//Constructor for -RecognizedPerson-
	//Accepts all the parameters from service
	public RecognizedPerson () {}
	public RecognizedPerson (String name, String surname, String FBname, String interest, String rel, String quot, String date, String place, String status, String politics, List<String> educat, String mus, List<String> sport, String telev, String mov, String book, List<String> lang, List<String> job, List<String> futureEvents, List<String> lastCheckins, String about, List<String> athletes, List<String> teams, List<String> fbGroups, List<String> televisio, String bio_, String inspPeople, List<String> like, List<String> event, List<String> mutualFriends, String pic) {
		first_name=name;
		last_name=surname;
		picture=pic;
		city=place;
		birthday=date;
		relationship_status=status;
		
		FBusername=FBname;
		interests=interest;
		religion=rel;
		quotes=quot;
		political=politics;
		education=new ArrayList<String>(educat);
		music=mus;
		sports=new ArrayList<String>(sport);
		tv=telev;
		movies=mov;
		books=book;
		languages=new ArrayList<String>(lang);
		work=new ArrayList<String>(job);
		future_events=new ArrayList<String>(futureEvents);
		last_checkins=new ArrayList<String>(lastCheckins);
		about_me=about;
		favorite_athletes=new ArrayList<String>(athletes);
		favorite_teams=new ArrayList<String>(teams);
		groups=new ArrayList<String>(fbGroups);
		television=new ArrayList<String>(televisio);
		bio=bio_;
		inspirational_people=inspPeople;
		likes=new ArrayList<String>(like);
		events=new ArrayList<String>(event);
		mutual_friends=new ArrayList<String>(mutualFriends);
		
		
		
		
		
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
	public void setInterests (String i) {
		this.interests=i;
	}
	public String getInterests() {
		return interests;
	}
	public void setMusic (String m) {
		this.relationship_status=m;
	}
	public String getMusic() {
		return music;
	}
//G&S	


	
	
}
