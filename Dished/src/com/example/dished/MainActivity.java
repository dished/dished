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
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button new_dish = (Button) findViewById(R.id.btn_new_dish);
        new_dish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startNewDish(v);
			}
		});
        
        
        Button view_dish = (Button) findViewById(R.id.btn_view_dish);
        view_dish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startDishList(v);
			}
		});
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
      
    //called when user clicks "New Dish" button
    public void startNewDish(View v){
    	Intent intent = new Intent(this, DishOptions.class);
    	startActivity(intent);
    }
    
  //Called when user clicks "View dishes" button
    public void startDishList(View v){
    	Intent intent = new Intent(this, DishListActivity.class);
    	startActivity(intent);
    }
    
}
