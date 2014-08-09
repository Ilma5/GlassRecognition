package com.example.informationpreview;

import java.util.ArrayList;
import java.util.List;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class CardScrollActivityOne extends Activity{
	//*****************************************************************
	//Accepts the person, make live cards for information preview
	//*****************************************************************
	private List<Card> CardsOne; 
	private  RecognizedPerson Person;
	private CardScrollView CardScrollViewOne; 
	private  ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
	Bitmap decodedByte;
	Context context2; 
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_one);
		context2=this;
		try {
			//Get the bundle object
			Bundle bundleObject=getIntent().getExtras();
			//Get Recognized Person Bundle
			Person = (RecognizedPerson) bundleObject.getSerializable("key");
			
			//Conversion
			byte[] decodedString = Base64.decode(
					Person.getPicture(),
					Base64.DEFAULT);
			decodedByte = BitmapFactory.decodeByteArray(
					decodedString, 0, decodedString.length);
			
			//Making cards:
			CardsOne=new ArrayList<Card>();	
			makeListOfCards();
						
		} catch(Exception e) {
			e.printStackTrace();
		}

		//Card Scroll View making:
		CardScrollViewOne = new CardScrollView(this);
        CardScrollViewOne.setAdapter(adapter);
        CardScrollViewOne.activate();
        setContentView(CardScrollViewOne);
	
	}
	
	protected class ExampleCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return CardsOne.indexOf(item);
        }

        @Override
        public int getCount() {
            return CardsOne.size();
        }

        @Override
        public Object getItem(int position) {
            return CardsOne.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return Card.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position){
            return CardsOne.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return  CardsOne.get(position).getView(convertView, parent);
        }
    }
	
	public void makeListOfCards() {
		if (Person.getFirstName()==null && Person.getLastName()==null) {Person.setFirstName("No name available.."); Person.setLastName("");}
		else {
			if (Person.getFirstName()==null) Person.setFirstName("");
			if (Person.getLastName()==null) Person.setLastName("");
		}
		Card card1 = new Card(this);
		card1.setText(Person.getFirstName()+" "+Person.getLastName());
		//card1.setFootnote("Relationship status: "+Person.getRelationSStatusRecPer());
		card1.setImageLayout(Card.ImageLayout.LEFT);
		card1.addImage(decodedByte);
		View card1View = card1.getView();
		CardsOne.add(card1);
		
		List<String> ListOfAttributes=new ArrayList<String>();
	
		if (Person.getBirthday()!=null) ListOfAttributes.add("Birthday: "+Person.getBirthday());
		if (Person.getCity()!=null) ListOfAttributes.add("City: "+Person.getCity());
		if (Person.getRelationship()!=null) ListOfAttributes.add("Relationship: "+Person.getRelationship());
		if (Person.getEducation()!=null) ListOfAttributes.add("Education: "+Person.getEducation());
		if (Person.getWork()!=null) ListOfAttributes.add("Work: "+Person.getWork());
		if (Person.getLanguages()!=null) ListOfAttributes.add("Languages: "+Person.getLanguages());
		if (Person.getReligion()!=null) ListOfAttributes.add("Religion: "+Person.getReligion());
		if (Person.getPolitical()!=null) ListOfAttributes.add("Political: "+Person.getPolitical());
		
		if (Person.getEvents()!=null) ListOfAttributes.add("Events: "+Person.getEvents());
		if (Person.getLast_checkins()!=null) ListOfAttributes.add("Last_checkins: "+Person.getLast_checkins());
		if (Person.getFuture_events()!=null) ListOfAttributes.add("Future events: "+Person.getFuture_events());
		if (Person.getMutual_friends()!=null) ListOfAttributes.add("Mutual friends: "+Person.getMutual_friends());
		if (Person.getGroups()!=null) ListOfAttributes.add("Groups: "+Person.getGroups());
		if (Person.getLikes()!=null) ListOfAttributes.add("Likes: "+Person.getLikes());
		if (Person.getFBusername()!=null) ListOfAttributes.add("facebook: "+Person.getFBusername());
		
		if (Person.getAbout_me()!=null) ListOfAttributes.add("About me: "+Person.getAbout_me());
		if (Person.getInterests()!=null) ListOfAttributes.add("Interests: "+Person.getInterests());
		if (Person.getInspirational_people()!=null) ListOfAttributes.add("Inspirational people: "+Person.getInspirational_people());
		
		if (Person.getSports()!=null) ListOfAttributes.add("Sports: "+Person.getSports());
		if (Person.getFavourite_teams()!=null) ListOfAttributes.add("Favourite teams: "+Person.getFavourite_teams());
		if (Person.getFavourite_athletes()!=null) ListOfAttributes.add("Favourite athletes: "+Person.getFavourite_athletes());
		if (Person.getTV()!=null) ListOfAttributes.add("TV: "+Person.getTV());	
		if (Person.getMovies()!=null) ListOfAttributes.add("Movies: "+Person.getMovies());
		if (Person.getBooks()!=null) ListOfAttributes.add("Books: "+Person.getBooks());
		if (Person.getMusic()!=null) ListOfAttributes.add("Music: "+Person.getMusic());
		if (Person.getTelevision()!=null) ListOfAttributes.add("Television: "+Person.getTelevision());
			
		if (Person.getQuotes()!=null) ListOfAttributes.add("Quotes: "+Person.getQuotes());	
		if (Person.getBio()!=null) ListOfAttributes.add("Bio: "+Person.getBio());
// Showing 3 attributes per Card
		int k=ListOfAttributes.size();
		int numOfCards;
		if (k%3==0) numOfCards=k/3; else numOfCards=k/3+1;
		int x=0;
		for (int i=0; i<numOfCards; i++) {
			Card c=new Card(context2);
			String aa=ListOfAttributes.get(i+x);
			String bb;
			if ((i+1+x)==k) bb=""; else bb=ListOfAttributes.get(i+x+1);
			String cc;
			if ((i+2+x)==k || (i+2+x)>k) cc=""; else cc=ListOfAttributes.get(i+x+2);
			c.setText(aa+"\n"+bb+"\n"+cc);
			c.setImageLayout(Card.ImageLayout.FULL);
			View cView=c.getView();
			x=x+2;
			CardsOne.add(c);
			
		}
		
	}
}
