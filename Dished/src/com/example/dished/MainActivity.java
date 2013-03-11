package com.example.dished;

import com.example.dished.R;

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
public class MainActivity extends Activity{
	
	EditText first_name;
    Button button1; 
	TextView title;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    //Called when user clicks "View dishes" button
    public void ListView (View view){
    	Intent intent = new Intent(this, ListViewActivity.class);
    	startActivity(intent);
    	
    	
    }
    
}
