package com.example.informationpreview;

import java.io.Serializable;

public class RecognizedPerson implements Serializable{

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
	String education;
	String music;
	String sports;
	String tv;
	String movies;
	String books;
	String languages;
	String work;
	String future_events;
	String last_checkins;
	String about_me;
	String favorite_athletes;
	String favorite_teams;
	String groups;
	String television;
	String bio;
	String inspirational_people;
	String likes;
	String events;
	String mutual_friends;

	
	//Constructor for -RecognizedPerson-
	public RecognizedPerson () {}
	public RecognizedPerson (String name, String surname, String FBname, String interest, String rel, String quot, String date, String place, String status, String politics, String educat, String mus, String sport, String telev, String mov, String book, String lang, String job, String futureEvents, String lastCheckins, String about, String athletes, String teams, String fbGroups, String televisio, String bio_, String inspPeople, String like, String event, String mutualFriends, String pic) {

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
		education=educat;
		music=mus;
		sports=sport;
		tv=telev;
		movies=mov;
		books=book;
		languages=lang;
		work=job;
		future_events=futureEvents;
		last_checkins=lastCheckins;
		about_me=about;
		favorite_athletes=athletes;
		favorite_teams=teams;
		groups=fbGroups;
		television=televisio;
		bio=bio_;
		inspirational_people=inspPeople;
		likes=like;
		events=event;
		mutual_friends=mutualFriends;	
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
	public void setBirthday (String date) {
		this.birthday=date;
	}
	public String getBirthday () {
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
	public void setFBusername (String fbu) {
		this.FBusername=fbu;
	}
	public String getFBusername() {
		return FBusername;
	}
	public void setReligion (String r) {
		this.religion=r;
	}
	public String getReligion() {
		return religion;
	}
	public void setQuotes (String q) {
		this.quotes=q;
	}
	public String getQuotes() {
		return quotes;
	}
	public void setPolitical (String p) {
		this.political=p;
	}
	public String getPolitical() {
		return political;
	}
	public void setTV (String t) {
		this.tv=t;
	}
	public String getTV() {
		return tv;
	}
	public void setMovies (String m) {
		this.movies=m;
	}
	public String getMovies() {
		return movies;
	}
	public void setBooks (String b) {
		this.books=b;
	}
	public String getBooks() {
		return books;
	}
	public void setAbout_me (String a) {
		this.about_me=a;
	}
	public String getAbout_me() {
		return about_me;
	}
	public void setBio (String b) {
		this.bio=b;
	}
	public String getBio() {
		return bio;
	}
	public void setInspirational_people (String ip) {
		this.inspirational_people=ip;
	}
	public String getInspirational_people() {
		return inspirational_people;
	}
	public void setEducation (String e) {
		this.education=e;
	}
	public String getEducation() {
		return education;
	}
	public void setSports (String e) {
		this.sports=e;
	}
	public String getSports() {
		return sports;
	}
	public void setLanguages (String e) {
		this.languages=e;
	}
	public String getLanguages() {
		return languages;
	}
	public void setWork (String e) {
		this.work=e;
	}
	public String getWork() {
		return work;
	}
	public void setFuture_events (String e) {
		this.future_events=e;
	}
	public String getFuture_events() {
		return future_events;
	}
	public void setLast_checkins (String e) {
		this.last_checkins=e;
	}
	public String getLast_checkins() {
		return last_checkins;
	}
	public void setFavourite_athletes (String e) {
		this.favorite_athletes=e;
	}
	public String getFavourite_athletes() {
		return favorite_athletes;
	}
	public void setFavourite_teams (String e) {
		this.favorite_teams=e;
	}
	public String getFavourite_teams() {
		return favorite_teams;
	}
	public void setGroups (String e) {
		this.groups=e;
	}
	public String getGroups() {
		return groups;
	}
	public void setTelevision (String e) {
		this.television=e;
	}
	public String getTelevision () {
		return television;
	}
	public void setLikes (String e) {
		this.likes=e;
	}
	public String getLikes() {
		return likes;
	}
	public void setEvents (String e) {
		this.events=e;
	}
	public String getEvents() {
		return events;
	}
	public void setMutual_friends (String e) {
		this.mutual_friends=e;
	}
	public String getMutual_friends() {
		return mutual_friends;
	}
//G&S	


	
	
}
