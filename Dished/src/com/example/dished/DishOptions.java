package com.example.dished;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.dished.R.string;
import com.example.dished.database.DbConnector;
import com.example.dished.database.DishedDbHelper;
import com.example.dished.database.DishedTable;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DishOptions extends Activity {

	TextView title;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishoptions);
        
        title = (TextView) findViewById(R.id.newdish_lblDishName);
     
	}

	public void saveDish(View v)
	{
		Log.i("database", "executeddddd");
		Bundle extras = getIntent().getExtras();
		String fn = extras.getString("first_name");
        Toast.makeText(this, fn + " has been saved to your dishes.", Toast.LENGTH_LONG).show();
        
		DbConnector db = new DbConnector();
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
		
		//newdish.put(DishedTable.COL_SWEET, (int) sweet);
		db.insertRecord(newdish);
		
		Log.i("database", "executed");
		
		 Intent in = new Intent(getApplicationContext(), DishListActivity.class);
         startActivity(in);
		
	}
	
	
}


