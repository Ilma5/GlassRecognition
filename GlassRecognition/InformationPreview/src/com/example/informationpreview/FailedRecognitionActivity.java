package com.example.informationpreview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.google.android.glass.app.Card;
import com.google.android.glass.sample.camera.MainActivity;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

public class FailedRecognitionActivity extends Activity implements GestureDetector.BaseListener{

	private List<Card> Cards; 
	private CardScrollView CardScrollViewOne; 
	private  ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
	private GestureDetector mDetector;
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_one);
		
		mDetector = new GestureDetector(this).setBaseListener(this);
		
		try {
			Cards=new ArrayList<Card>();

			
			Card card = new Card(this);
			card.setText("SORRY,\n\nWE DID NOT RECOGNISE ANYBODY.");
			card.setTimestamp("LONG PRESS for options menu");
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
    		Intent intent = new Intent(FailedRecognitionActivity.this, MainManuActivity.class);
    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);		
    		startActivity(intent);
    		finish();
        	return true;
        }
        return false;
    }
	
	
	
}
