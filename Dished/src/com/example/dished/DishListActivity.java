package com.example.dished;

import java.io.ByteArrayOutputStream;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DishListActivity extends Activity {
	
	private ListView dish_listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dish_list);
		
		DishList dish_data[] = new DishList[]	//data of items to be viewed on list
		{
				new DishList(R.drawable.ic_launcher, "Ribs", "Good"),
	            new DishList(R.drawable.ic_launcher, "Android", "Bad"),
	            new DishList(R.drawable.ic_launcher, "Food", "OK"),
	            new DishList(R.drawable.ic_launcher, "Food_2", "Terrible"),
	            new DishList(R.drawable.ic_launcher, "Ribs", "Great"),
	            new DishList(R.drawable.ic_launcher, "VANCOUVER", "Best"),
	            new DishList(R.drawable.ic_launcher, "This is a really long line of text for testing", "meh"),
	            new DishList(R.drawable.ic_launcher, "Seattle", "Decent"),
	            new DishList(R.drawable.ic_launcher, "CANUCKS", "best")
		};
		
		DishListAdapter adapter = new DishListAdapter(this,
				R.layout.dish_list_row, dish_data);
		
		dish_listview = (ListView)findViewById(R.id.dish_listview);
        dish_listview.setAdapter(adapter);		
        
        
        //Starting new activity when a lsit row is clicked
        dish_listview.setOnItemClickListener(new OnItemClickListener(){
        	
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting values from selected ListItem
            	String name = ((TextView) view.findViewById(R.id.txtName)).getText().toString();
                String description = ((TextView) view.findViewById(R.id.txtRating)).getText().toString();
                 
                // Starting new intent
                Intent in = new Intent(getApplicationContext(), OneDishActivity.class);
                in.putExtra("name", name);
                in.putExtra("rating", description);
                startActivity(in);
            }
        });
        	
	}

}	
