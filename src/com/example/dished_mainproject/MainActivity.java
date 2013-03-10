package com.example.dished_mainproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Activity = anything that can be displayed on phone
public class MainActivity extends Activity implements OnClickListener {

	EditText first_name;
    Button button1; 
	TextView title;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        first_name = (EditText) findViewById(R.id.firstName);
        button1 = (Button) findViewById(R.id.button1);
    	title = (TextView) findViewById(R.id.textView2);
        
        button1.setOnClickListener(this);
        
    }

    public void onClick(View v) {
    
    	if (v.getId() == R.id.button1) {
    		String fn = first_name.getText().toString();
    		
    		Intent switchPage = new Intent();
    		switchPage.putExtra("first_name", fn);
    		switchPage.setClass(this, DishOptions.class);
    		startActivity(switchPage);
    	}	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
