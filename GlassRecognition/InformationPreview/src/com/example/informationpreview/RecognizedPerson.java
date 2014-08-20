package com.example.informationpreview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import com.example.fbattributes.Education;
import com.example.fbattributes.Event;
import com.example.fbattributes.Favorite_athlete;
import com.example.fbattributes.Favorite_team;
import com.example.fbattributes.Future_event;
import com.example.fbattributes.Group;
import com.example.fbattributes.Language;
import com.example.fbattributes.Last_checkin;
import com.example.fbattributes.Like;
import com.example.fbattributes.MutualFriend;
import com.example.fbattributes.Sport;
import com.example.fbattributes.Television;
import com.example.fbattributes.Work;


public class RecognizedPerson implements Serializable{

	String notes;
	
	String birthday;
	String first_name;
	String last_name;
	String relationship_status;
	String hometown_location;
	String picture;
	
	String FBusername;
	String interests;
	String religion;
	String quotes;
	String political;
	List<Education> educations;
	String music;
	List<Sport> sports;
	String tv;
	String movies;
	String books;
	List<Language> languages;
	List<Work> work_places;
	List<Future_event> future_events;
	List<Last_checkin> last_checkins;
	String about_me;
	List<Favorite_athlete> favorite_athletes;
	List<Favorite_team> favorite_teams;
	List<Group> groups;
	List<Television> televisions;
	String bio;
	List<String> inspirational_people;
	List<Like> likes;
	List<Event> events;
	List<MutualFriend> mutual_friends;

	
	//Constructor for -RecognizedPerson-
	public RecognizedPerson () {}
	public RecognizedPerson (String not, String name, String surname, String FBname, String interest, String rel, String quot, String date, String place, String status, String politics, List<Education> educat, String mus, List<Sport> sport, String telev, String mov, String book, List<Language> lang, List<Work> job, List<Future_event> futureEvents, List<Last_checkin> lastCheckins, String about, List<Favorite_athlete> athletes, List<Favorite_team> teams, List<Group> fbGroups, List<Television> televisio, String bio_, List<String> inspPeople, List<Like> like, List<Event> event, List<MutualFriend> mutualFriends, String pic) {

		notes=not;
		
		first_name=name;
		last_name=surname;
		picture=pic;
		
		hometown_location=place;
		birthday=date;
		relationship_status=status;
		
		FBusername=FBname;
		interests=interest;
		religion=rel;
		quotes=quot;
		political=politics;
		educations=new ArrayList<Education>(educat);
		music=mus;
		sports=new ArrayList<Sport>(sport);
		tv=telev;
		movies=mov;
		books=book;
		languages=new ArrayList<Language>(lang);
		work_places=new ArrayList<Work>(job);
		future_events=new ArrayList<Future_event>(futureEvents);
		last_checkins=new ArrayList<Last_checkin>(lastCheckins);
		about_me=about;
		favorite_athletes=new ArrayList<Favorite_athlete>(athletes);
		favorite_teams=new ArrayList<Favorite_team>(teams);
		groups=new ArrayList<Group>(fbGroups);
		televisions=new ArrayList<Television>(televisio);
		bio=bio_;
		inspirational_people=new ArrayList<String>(inspPeople);
		likes=new ArrayList<Like>(like);
		events=new ArrayList<Event>(event);
		mutual_friends=new ArrayList<MutualFriend>(mutualFriends);	
	}
	
//Getters and setters ------ 
	public void setNotes (String not) {
		this.notes=not;
	}
	public String getNotes () {
		return notes;
	}
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
	public void setHometown_location (String place) {
		this.hometown_location=place;
	}
	public String getHometown_location() {
		return hometown_location;
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
	public void setInspirational_people (ArrayList<String> ip) {
		this.inspirational_people=ip;
	}
	public List<String> getInspirational_people() {
		return inspirational_people;
	}
	public void setEducation (ArrayList<Education> ed) {
		this.educations=ed;
	}
	public List<Education> getEducation() {
		return educations;
	}
	public void setSports (ArrayList<Sport> s) {
		this.sports=s;
	}
	public List<Sport> getSports() {
		return sports;
	}
	public void setLanguages (ArrayList<Language> e) {
		this.languages=e;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setWork_places (ArrayList<Work> e) {
		this.work_places=e;
	}
	public List<Work> getWork_places() {
		return work_places;
	}
	public void setFuture_events (ArrayList<Future_event> e) {
		this.future_events=e;
	}
	public List<Future_event> getFuture_events() {
		return future_events;
	}
	public void setLast_checkins (ArrayList<Last_checkin> e) {
		this.last_checkins=e;
	}
	public List<Last_checkin> getLast_checkins() {
		return last_checkins;
	}
	public void setFavourite_athletes (ArrayList<Favorite_athlete> e) {
		this.favorite_athletes=e;
	}
	public List<Favorite_athlete> getFavourite_athletes() {
		return favorite_athletes;
	}
	public void setFavourite_teams (ArrayList<Favorite_team> e) {
		this.favorite_teams=e;
	}
	public List<Favorite_team> getFavourite_teams() {
		return favorite_teams;
	}
	public void setGroups (ArrayList<Group> e) {
		this.groups=e;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setTelevisions (ArrayList<Television> t) {
		this.televisions=t;
	}
	public List<Television> getTelevisions () {
		return televisions;
	}
	public void setLikes (ArrayList<Like> e) {
		this.likes=e;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setEvents (ArrayList<Event> e) {
		this.events=e;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setMutual_friends (ArrayList<MutualFriend> e) {
		this.mutual_friends=e;
	}
	public List<MutualFriend> getMutual_friends() {
		return mutual_friends;
	}
//G&S	


	
	
}
