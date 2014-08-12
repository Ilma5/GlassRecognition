package com.example.informationpreview;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.github.barcodeeye.scan.CaptureActivity;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class MainManuActivity extends Activity 
{
	TextView textView;
    public Boolean menucreated = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		textView =(TextView)findViewById(R.id.textView1);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		
		 StringBuilder loginData = new StringBuilder();
	 
		// Inflate the menu; this adds items to the action bar if it is present.
		
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.first_menu, menu);
		
	       try
	        {
	        	
	        	File f =  new File(getCacheDir(),"LoginData.txt");
	            if (f.exists())
	            {
	        	    BufferedReader br = new BufferedReader(new FileReader(f));
	        	    String line;

	        	    while ((line = br.readLine()) != null) {
	        	    	loginData.append(line);
	        	    }
	        	    
	        	    if (!loginData.toString().isEmpty())
	        	    {
	        	    	menu.getItem(1).setVisible(false);
	        	    }
	            }
	        	}
	        	catch (IOException e) {
	        	    //You'll need to add proper error handling here
	        	}
	        
	        if (loginData.toString().isEmpty())
   	    {
   	    	menu.getItem(2).setVisible(false);
   	    	menu.getItem(3).setVisible(false);
   	    }
	        
		return true;
	}
	
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
    	menucreated = false;
    	
        // Handle item selection. Menu items typically start another
        // activity, start a service, or broadcast another intent.
        switch (item.getItemId()) 
        {
            case R.id.menu_item_1:
            case R.id.menu_item_2:
            	
            {
            	LogIn();
            	 //openOptionsMenu();
            	finish();
                return true;
            }
            case R.id.menu_item_3:
            {
            	LogOut();
            	 //openOptionsMenu();
            	finish();
            	return true;
            }
            case R.id.menu_item_4:
            {
            	LogOut();       	
            	LogIn();
            	 //openOptionsMenu();
            	finish();
            	return true;
            }
            default:
            {
            	 openOptionsMenu();
                return super.onOptionsItemSelected(item);
            }
        }
    }

	private void LogIn() {
		Intent intent = new Intent(MainManuActivity.this, CaptureActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);		
		startActivity(intent);
	}

	private void LogOut() {
		File f =  new File(getCacheDir(),"LoginData.txt");
		
		FileOutputStream fos = null;
		  try {
			if(!f.exists()) {
		        f.createNewFile();
		      } 
				
			  fos = new FileOutputStream(f,false);
			  fos.write("".getBytes());
		      fos.close();
		       
   }
   catch (IOException e) {
		   
		  }
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocusFlag) {
		super.onWindowFocusChanged(hasFocusFlag); 
	    System.out.println("!!!!!!++ "+hasFocusFlag+" ++!!!!!!!"); 
	    if(hasFocusFlag)
	    {
	    	
	        openOptionsMenu();
	    }
	  
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		if (menucreated)
			finish();
	}
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menucreated = true;
	        return true;
	    }
    
}
