package com.example.dished;

import com.example.dished.R.drawable;
import com.example.dished.database.DbConnector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OneDishActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_dish);
		
        DbConnector db = MainActivity.db;
		
		Intent in = getIntent();
		//Receiving the title and rating 
        String name = in.getStringExtra("name");
        String rating = in.getStringExtra("rating");
        int index = in.getIntExtra("index", 0);
        
        TextView name_text = (TextView) findViewById(R.id.one_dish_name);
        TextView rating_text = (TextView) findViewById(R.id.one_dish_rating);
        
        //Setting text for the header
        TextView header = (TextView) findViewById(R.id.OneDishHeader);
        header.setText(name);
        
        //Setting the textviews to appropriate data
        name_text.setText(name);
        rating_text.setText("Mr.Panino's");
        
        //Setting the image of the dish
        ImageView image = (ImageView) findViewById(R.id.imageView1);

        image.setImageResource(R.drawable.becks23);
        
        TextView overall_ = (TextView) findViewById(R.id.one_dish_overall_txt);
        TextView overall_1 = (TextView) findViewById(R.id.one_dish_overall_txt1);
        TextView overall_2 = (TextView) findViewById(R.id.one_dish_overall_txt2);
        String _overall = "<b>" + "Overall: " + "</b>" + rating;
        overall_.setText(Html.fromHtml(_overall)); 
        overall_1.setText(Html.fromHtml(_overall)); 
        overall_2.setText(Html.fromHtml(_overall)); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.one_dish, menu);
		return true;
	}
	
	

}
