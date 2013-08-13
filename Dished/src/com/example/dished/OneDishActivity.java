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
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OneDishActivity extends Activity {

	DbConnector db = new DbConnector(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_dish);
		
        db.open();
        
		Intent in = getIntent();
		//Receiving the title and rating 
        String name = in.getStringExtra("name");
        String rating = in.getStringExtra("rating");
        int index = in.getIntExtra("index", -1);
        int key = index+1;
        
        TextView name_text = (TextView) findViewById(R.id.one_dish_name);
        TextView rest_text = (TextView) findViewById(R.id.one_dish_rest);
        
        //Setting text for the header
        TextView header = (TextView) findViewById(R.id.OneDishHeader);
        header.setText(name);
        
        //Setting the textviews to appropriate data
        name_text.setText(name);		//dish name
        rest_text.setText(db.getRestaurant(key));	//dish restaurant
        
        //Setting the image of the dish
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.ic_launcher);
        
        TextView price = (TextView) findViewById(R.id.one_dish_overall_txt);
        TextView time = (TextView) findViewById(R.id.one_dish_overall_txt1);
        //TextView overall_2 = (TextView) findViewById(R.id.one_dish_overall_txt2);
        String price_ = "<b>" + "Price: " + "</b>$" + db.getPrice(key);
        String time_ = "<b>" + "Time: " + "</b>" + db.getTime(key) + " minutes";
        price.setText(Html.fromHtml(price_)); 
        time.setText(Html.fromHtml(time_)); 
       // overall_2.setText(Html.fromHtml(_overall)); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.one_dish, menu);
		return true;
	}
	
    @Override
    protected void onResume() {
      db.open();
      super.onResume();
    }

    @Override
    protected void onPause() {
      db.close();
      super.onPause();
    }

}
