package com.example.dished;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dished.R;

public class OneDishActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_dish);
		
		Intent in = getIntent();
		//Receiving the title and rating 
        String name = in.getStringExtra("name");
        String rating = in.getStringExtra("rating");
        
        TextView name_text = (TextView) findViewById(R.id.one_dish_name);
        TextView rating_text = (TextView) findViewById(R.id.one_dish_rating);
        //Setting the textviews to appropriate data
        name_text.setText(name);
        rating_text.setText(rating);
        
        //Setting text for the header
        TextView header = (TextView) findViewById(R.id.OneDishHeader);
        header.setText(name);
        
        //Setting the image of the dish
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.ic_launcher); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.one_dish, menu);
		return true;
	}
	
	

}
