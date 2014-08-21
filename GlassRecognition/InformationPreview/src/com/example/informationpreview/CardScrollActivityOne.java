package com.example.informationpreview;

import java.util.ArrayList;
import java.util.List;

import com.google.android.glass.app.Card;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class CardScrollActivityOne extends Activity implements GestureDetector.BaseListener{
	//*****************************************************************
	//Accepts the person, make live cards for information preview
	//*****************************************************************
	private List<Card> CardsOne; 
	private  RecognizedPerson Person;
	private CardScrollView CardScrollViewOne; 
	private  ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
	Bitmap decodedByte;
	Context context2;
	private GestureDetector mDetector;
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_one);
		context2=this;
		mDetector = new GestureDetector(this).setBaseListener(this);
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
	
	private List<String> ArrangeStrings(String string) {
		 String[] parts = string.split(",");
		 int counter=parts.length-1;
		List<String>splittedstring=new ArrayList<String>();
		
		for(int i=0; i<counter; i++)
			{	
			splittedstring.add(parts[i]+"\n");
			if (i==2) i=counter+1;
			
			}	
		return splittedstring;
			
		}
	
	
	public void makeListOfCards() {
		
//Making the FIRST and the NOTES card -------------------------------
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
		
		if (Person.getNotes()==null) {
			Card cardN = new Card(this);
			cardN.setText("There is no Notes about "+Person.getFirstName()+" "+Person.getLastName()+".\n");
			cardN.setFootnote("Scroll for more information...");
			cardN.setImageLayout(Card.ImageLayout.FULL);
			View cardNView = cardN.getView();
			CardsOne.add(cardN);
		}
		else {		
			Card cardN = new Card(this);
			cardN.setText("My notes about "+Person.getFirstName()+" "+Person.getLastName()+":\n"+Person.getNotes());
			cardN.setImageLayout(Card.ImageLayout.FULL);
			View cardNView = cardN.getView();
			CardsOne.add(cardN);
		}
		
//Making the REST of the cards -------------------------
		
		List<String> ListOfAttributes=new ArrayList<String>();
		
		fillListOfAttributes(ListOfAttributes);
		
	
// Showing 3 attributes per Card
		int k=ListOfAttributes.size();
//		int numOfCards;
//		if (k%3==0) numOfCards=k/3; else numOfCards=k/3+1;
//		int x=0;
//		for (int i=0; i<numOfCards; i++) {
//			Card c=new Card(context2);
//			String aa=ListOfAttributes.get(i+x);
//			String bb;
//			if ((i+1+x)==k) bb=""; else bb=ListOfAttributes.get(i+x+1);
//			String cc;
//			if ((i+2+x)==k || (i+2+x)>k) cc=""; else cc=ListOfAttributes.get(i+x+2);
//			c.setText(aa+"\n"+bb+"\n"+cc);
//			c.setImageLayout(Card.ImageLayout.FULL);
//			View cView=c.getView();
//			x=x+2;
//			CardsOne.add(c);
//			
//		}
		
		int j =0;
		int a = 0;
		Card c = new Card(context2);
		for (int i = 0; i< k; i++)
		{
			String atr = ListOfAttributes.get(i);
			int rowNumbers = atr.split("\n").length;
					
			if (j+rowNumbers > 7 || a == 3)
			{
				//Add filled card to the list
				c.setImageLayout(Card.ImageLayout.FULL);
				View cView=c.getView();
				CardsOne.add(c);
				
				// Create a new empty Card
				c = new Card(context2);
				
				//Set first card's attribute
				c.setText(atr+"\n");
				j= (rowNumbers +1 );
				a = 1;
			}
			else
			{   
				if (c.getText()==null) c.setText("");
				c.setText(c.getText() + atr+"\n");
				j+= (rowNumbers +1 );
				a++;
			}
			
		}
//Making individual cards -------------------------------
		
		if (!Person.getLast_checkins().isEmpty()) {
			
			Card card3 = new Card(this);
			
			int count = Person.getLast_checkins().size();
			StringBuffer sb = new StringBuffer("Last checkins:"+"\n"+"\n");
			for (int i=0; i<count; i++) {
				String s="at "+Person.getLast_checkins().get(i).getTime(); 
				if (Person.getLast_checkins().get(i).getTime()==null) s="";
				sb.append(Person.getLast_checkins().get(i).getLocation()+"\n"+s+"\n"+"\n");
				if (i==1) i=count;
			}
			
			card3.setText(sb.toString());
			card3.setImageLayout(Card.ImageLayout.FULL);
			View card3View = card3.getView();
			CardsOne.add(card3);
			
		}
		
		
		if (!Person.getFuture_events().isEmpty()) {
					
			Card card2 = new Card(this);
					
			int count = Person.getFuture_events().size();
			StringBuffer sb = new StringBuffer("Future events:"+"\n"+"\n");
			for (int i=0; i<count; i++) {
				String s="in "+Person.getFuture_events().get(i).getLocationCity(); 
				if (Person.getFuture_events().get(i).getLocationCity()==null) s="";
				sb.append(Person.getFuture_events().get(i).getName()+"\n"+
							Person.getFuture_events().get(i).getDate()+s+"\n"+"\n");
				if (i==1) i=count;
			}
					
			card2.setText(sb.toString());
			card2.setImageLayout(Card.ImageLayout.FULL);
			View card2View = card2.getView();
			CardsOne.add(card2);
				
				}		
		
		if (!Person.getEvents().isEmpty()) {
			
				Card card4 = new Card(this);
			
				int count = Person.getEvents().size();
				StringBuffer sb = new StringBuffer("Events: "+"\n"+"\n");
				for (int i=0; i<count; i++) {
					String s="at "+Person.getEvents().get(i).getLocation(); 
					if (Person.getEvents().get(i).getLocation()==null) s="";
					sb.append(Person.getEvents().get(i).getname()+"\n"+s+"\n"+"\n");
					if (i==1) i=count;
				}
			
				card4.setText(sb.toString());
				card4.setImageLayout(Card.ImageLayout.FULL);
				View card4View = card4.getView();
				CardsOne.add(card4);
			
		}
		
		if (Person.getAbout_me()!=null) {
			
			Card card5 = new Card(this);	
			card5.setText("About me ("+Person.getFirstName()+" "+Person.getLastName()+"):\n\n"+Person.getAbout_me());
			card5.setImageLayout(Card.ImageLayout.FULL);
			View card5View = card5.getView();
			CardsOne.add(card5);	
	}
		
		
	}


	private void fillListOfAttributes(List<String> ListOfAttributes) {
		
		if (Person.getBirthday()!=null) ListOfAttributes.add("Birthday: "+Person.getBirthday()+"\n");
		if (Person.getHometown_location()!=null) ListOfAttributes.add("City: "+Person.getHometown_location()+"\n");
		if (Person.getRelationship()!=null) ListOfAttributes.add("Relationship: "+Person.getRelationship()+"\n");
		if (!Person.getEducation().isEmpty()) {
			
			int count = Person.getEducation().size();
			StringBuffer sb = new StringBuffer("Education: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getEducation().get(i).getSchoolName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (!Person.getWork_places().isEmpty()) {
			
			int count = Person.getWork_places().size();
			StringBuffer sb = new StringBuffer("Work: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getWork_places().get(i).getEmployerName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
		}
		if (!Person.getLanguages().isEmpty()) {
			
			int count = Person.getLanguages().size();
			StringBuffer sb = new StringBuffer("Languages: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getLanguages().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (Person.getReligion()!=null) ListOfAttributes.add("Religion: "+Person.getReligion()+"\n");

		if (Person.getPolitical()!=null) ListOfAttributes.add("Political: "+Person.getPolitical()+"\n");
		
		if (!Person.getMutual_friends().isEmpty()) {
			
			int count = Person.getMutual_friends().size();
			StringBuffer sb = new StringBuffer("Mutual friends: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getMutual_friends().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (!Person.getGroups().isEmpty()) {
			
			int count = Person.getGroups().size();
			StringBuffer sb = new StringBuffer("Groups: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getGroups().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (!Person.getLikes().isEmpty()) {
			
			int count = Person.getLikes().size();
			StringBuffer sb = new StringBuffer("Likes: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getLikes().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		//if (Person.getFBusername()!=null) ListOfAttributes.add("facebook: "+Person.getFBusername());
		
		if (Person.getInterests()!=null){
			
			 List<String> Listofsplittedstrings=new ArrayList<String>();
			 Listofsplittedstrings.addAll(ArrangeStrings(Person.getInterests()));
			 
			 StringBuffer sb = new StringBuffer("Interests: ");
			 for (String s : Listofsplittedstrings){
				 sb.append(s);
			 }
			 ListOfAttributes.add(sb.toString());
			
			}
		if (!Person.getInspirational_people().isEmpty()) {
			
			int count = Person.getInspirational_people().size();
			StringBuffer sb = new StringBuffer("Inspirational people: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getInspirational_people().get(i)+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
		
		}
		
		if (!Person.getSports().isEmpty()) {
			
			int count = Person.getSports().size();
			StringBuffer sb = new StringBuffer("Sports: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getSports().get(i).getSport()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (!Person.getFavourite_teams().isEmpty()) {
			
			int count = Person.getFavourite_teams().size();
			StringBuffer sb = new StringBuffer("Favourite teams: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getFavourite_teams().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (!Person.getFavourite_athletes().isEmpty()) {
			
			int count = Person.getFavourite_athletes().size();
			StringBuffer sb = new StringBuffer("Favourite athletes: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getFavourite_athletes().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
		if (Person.getTV()!=null) {
			
			 List<String> Listofsplittedstrings=new ArrayList<String>();
			 Listofsplittedstrings.addAll(ArrangeStrings(Person.getTV()));
			 
			 StringBuffer sb = new StringBuffer("TV: ");
			 for (String s : Listofsplittedstrings){
				 sb.append(s);
			 }
			 ListOfAttributes.add(sb.toString());
			
			}
		if (Person.getMovies()!=null) {
			
			 List<String> Listofsplittedstrings=new ArrayList<String>();
			 Listofsplittedstrings.addAll(ArrangeStrings(Person.getMovies()));
			 
			 StringBuffer sb = new StringBuffer("Movies: ");
			 for (String s : Listofsplittedstrings){
				 sb.append(s);
			 }
			 ListOfAttributes.add(sb.toString());
			
			}
		if (Person.getBooks()!=null) 
		{
			
			 List<String> Listofsplittedstrings=new ArrayList<String>();
			 Listofsplittedstrings.addAll(ArrangeStrings(Person.getBooks()));
			 
			 StringBuffer sb = new StringBuffer("Books: ");
			 for (String s : Listofsplittedstrings){
				 sb.append(s);
			 }
			 ListOfAttributes.add(sb.toString());
			
			}
		if (Person.getMusic()!=null){
			
			 List<String> Listofsplittedstrings=new ArrayList<String>();
			 Listofsplittedstrings.addAll(ArrangeStrings(Person.getMusic()));
			 
			 StringBuffer sb = new StringBuffer("Music: ");
			 for (String s : Listofsplittedstrings){
				 sb.append(s);
			 }
			 ListOfAttributes.add(sb.toString());
			
			}
		if (!Person.getTelevisions().isEmpty()) {
			
			int count = Person.getTelevisions().size();
			StringBuffer sb = new StringBuffer("Television: ");
			for (int i=0; i<count; i++) {
				sb.append(Person.getTelevisions().get(i).getName()+"\n");
				if (i==2) i=count;
			}
			ListOfAttributes.add(sb.toString());
			
		}
			
		if (Person.getQuotes()!=null){
			
			 List<String> Listofsplittedstrings=new ArrayList<String>();
			 Listofsplittedstrings.addAll(ArrangeStrings(Person.getQuotes()));
			 
			 StringBuffer sb = new StringBuffer("Quotes: ");
			 for (String s : Listofsplittedstrings){
				 sb.append(s);
			 }
			 ListOfAttributes.add(sb.toString());
			
			}
		//if (Person.getBio()!=null) ListOfAttributes.add("Bio: "+Person.getBio()+"\n");
	}
	
	
	
	@Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mDetector.onMotionEvent(event);
    }

    @Override
    public boolean onGesture(Gesture gesture) {
        if (gesture == Gesture.TAP) {
//            mCamera.takePicture(null, null, mPictureCallback);
            return true;
        }
        if (gesture == Gesture.LONG_PRESS){
    		Intent intent = new Intent(CardScrollActivityOne.this, MainManuActivity.class);
    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);		
    		startActivity(intent);
    		finish();
        	return true;
        }
        return false;
    }
	
}
