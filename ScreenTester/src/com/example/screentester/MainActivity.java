package com.example.screentester;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	private LinearLayout backgroundLayout;
	private Button forwardButton;
	private Button backButton;
	
	private TransitionDrawable transition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initializing backgroundLayout and both buttons for later use
		backgroundLayout = (LinearLayout)findViewById(R.id.backgroundLL);
		forwardButton = (Button)findViewById(R.id.forwardButton);
		backButton = (Button)findViewById(R.id.backButton);
		
		//Sets visibility of back button to GONE and initializes TransitionDrawable
		backButton.setVisibility(View.GONE);
		transition = (TransitionDrawable)backgroundLayout.getBackground();
		
	}
	
	/*
	 * Function executes when forward button is pressed
	 * Starts transition (duration = 2 seconds)
	 * Exchanges Visibilities of Forward and Back Button
	 */
	public void onForward(View v) {	
		transition.startTransition(2000);
		forwardButton.setVisibility(View.GONE);
		backButton.setVisibility(View.VISIBLE);
	}
	
	/*
	 * Function executes when back button is pressed
	 * Reverses transiton (duration = 2seconds)
	 * Changes Visibilities back to original
	 */
	public void onBack(View v) {
		transition.reverseTransition(2000);
		backButton.setVisibility(View.GONE);
		forwardButton.setVisibility(View.VISIBLE);
	}

	//Default Menu set by Eclipse
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
