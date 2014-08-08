package com.example.informationpreview;

import java.util.ArrayList;
import java.util.List;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;


public class CardScrollActivityOne extends Activity{
	//*****************************************************************
	//Accepts the person, make live cards for information preview
	//*****************************************************************
	private List<Card> CardsOne; 
	private  RecognizedPerson Person;
	private CardScrollView CardScrollViewOne; 
	private  ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_one);
		
		try {
			//Get the bundle object
			Bundle bundleObject=getIntent().getExtras();
			//Get Recognized Person Bundle
			Person = (RecognizedPerson) bundleObject.getSerializable("key");
			
			//Conversion
			byte[] decodedString = Base64.decode(
					Person.getPicture(),
					Base64.DEFAULT);
			Bitmap decodedByte = BitmapFactory.decodeByteArray(
					decodedString, 0, decodedString.length);
			
			//Cards making (need other function)
			CardsOne=new ArrayList<Card>();
			
			
			if (Person.getRelationship()==null) Person.setRelationship("-");
			if (Person.getFirstName()==null && Person.getLastName()==null) {Person.setFirstName("No name available..");}
			else {
				if (Person.getFirstName()==null) Person.setFirstName("");
				if (Person.getLastName()==null) Person.setLastName("");
			}
			Card card1 = new Card(this);
			card1.setText(Person.getFirstName()+" "+Person.getLastName()+
					"\n"+"\n"+"Relationship status: "+Person.getRelationship());
			//card1.setFootnote("Relationship status: "+Person.getRelationSStatusRecPer());
			card1.setImageLayout(Card.ImageLayout.LEFT);
			card1.addImage(decodedByte);
			View card1View = card1.getView();
			
			if (Person.getCity()==null) Person.setCity("-");
			if (Person.getBithday()==null) Person.setBithday("-");
			Card card2 = new Card(this);
			card2.setText("Born: "+Person.getBithday()+"\n"+"City: "+Person.getCity());
			//card2.setImageLayout(Card.ImageLayout.LEFT);
			//card2.addImage(decodedByte);
			//card2.addImage(R.drawable.black_transparent);
			card2.setImageLayout(Card.ImageLayout.FULL);
			View card2View = card2.getView();
			
			if (Person.getInterests()==null) Person.setInterests("-");
			if (Person.getMusic()==null) Person.setMusic("-");
			Card card3 = new Card(this);
			card2.setText("Interests: "+Person.getInterests()+"\n"+
						  "Music: "+Person.getMusic());
			//card2.setImageLayout(Card.ImageLayout.LEFT);
			//card2.addImage(decodedByte);
			//card2.addImage(R.drawable.black_transparent);
			card2.setImageLayout(Card.ImageLayout.FULL);
			View card3View = card2.getView();
			
			
						
			CardsOne.add(card1);
			CardsOne.add(card2);
			CardsOne.add(card3);
						
		} catch(Exception e) {
			e.printStackTrace();
		}

		//Card Scroll View making
		CardScrollViewOne = new CardScrollView(this);
        CardScrollViewOne.setAdapter(adapter);
        CardScrollViewOne.activate();
        setContentView(CardScrollViewOne);
	
	}
	
	private class ExampleCardScrollAdapter extends CardScrollAdapter {

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
	
}
