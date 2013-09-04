package com.example.dished;

import com.example.dished.database.DbConnector;
import com.example.dished.database.DishedTable;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.text.GetChars;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DishOptions extends Activity {

	TextView title;

	DbConnector db = new DbConnector(this);
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishoptions);
        title = (TextView) findViewById(R.id.newdish_lblDishName);
        db.open();
	}
		
	
	public void saveDish(View v)
	{
//		Bundle extras = getIntent().getExtras();
//		String fn = extras.getString("first_name");
//        Toast.makeText(this, fn + " has been saved to your dishes.", Toast.LENGTH_LONG).show();
        
		ContentValues newdish = new ContentValues();
		
		RatingBar spicy = (RatingBar) findViewById(R.id.newdish_SweetRating);
		RatingBar sweet = (RatingBar) findViewById(R.id.newdish_SweetRating);
		RatingBar overall = (RatingBar) findViewById(R.id.newdish_OverallRating);
		
		EditText dishName = (EditText) findViewById(R.id.newdish_txtDishName);
		EditText resName = (EditText) findViewById(R.id.newdish_txtRestaurantNames);
		EditText costPrice = (EditText) findViewById(R.id.newdish_txtPrice);
		EditText prepTime = (EditText) findViewById(R.id.newdish_txtPrepTime);
		
		newdish.put(DishedTable.COL_DISH, dishName.getText().toString());
		newdish.put(DishedTable.COL_RESTAURANT, resName.getText().toString());
		newdish.put(DishedTable.COL_PRICE, costPrice.getText().toString());
		newdish.put(DishedTable.COL_TIME, prepTime.getText().toString());
		Log.e("db", "working");
		//newdish.put(DishedTable.COL_SWEET, (int) sweet);
		db.insertRecord(newdish);

		 Intent in = new Intent(getApplicationContext(), DishListActivity.class);
         startActivity(in);
		// finish();
	}


	  @Override
	  protected void onPause() {
		db.close();
	    super.onPause();
	    finish();
	  }

}


