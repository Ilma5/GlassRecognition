package com.example.informationpreview;

import java.util.ArrayList;
import java.util.List;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class FailedConnectionActivity extends Activity{

	private List<Card> Cards; 
	private CardScrollView CardScrollViewOne; 
	private  ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_one);
		
		try {
			Cards=new ArrayList<Card>();

			
			Card card = new Card(this);
			card.setText("CONNECTION TO SERVER FAILED.\n\nCLOSE THE APPLICATION");
			card.setImageLayout(Card.ImageLayout.FULL);
			View cardView = card.getView();
				
			Cards.add(card);

						
		} catch(Exception e) {
			e.printStackTrace();
		}

		//Card Scroll View making
		CardScrollViewOne = new CardScrollView(this);
        CardScrollViewOne.setAdapter(adapter);
        CardScrollViewOne.activate();
        setContentView(CardScrollViewOne);
	
	}
	
	protected class ExampleCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return Cards.indexOf(item);
        }

        @Override
        public int getCount() {
            return Cards.size();
        }

        @Override
        public Object getItem(int position) {
            return Cards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return Card.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position){
            return Cards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return  Cards.get(position).getView(convertView, parent);
        }
    }
	
}
