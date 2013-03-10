package com.example.dished;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DishOptions extends Activity {

	TextView title;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishoptions);
        
        title = (TextView) findViewById(R.id.largetext);
        
        Bundle extras = getIntent().getExtras();
        
        String fn = extras.getString("first_name");
        
        Toast.makeText(this, fn + " has been saved to your dishes.", Toast.LENGTH_LONG).show();
        
	}
	
}

