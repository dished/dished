package com.example.dished;

import java.util.List;
import java.util.Map;

import com.example.dished.database.DbConnector;
import com.example.dished.database.DishedTable;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.content.ContentValues;
import android.view.Menu;
import android.widget.TextView;

public class ListViewActivity extends Activity {
	
	private ListView dish_listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dish_list);
		
		DishList dish_data[] = new DishList[]	//data of items to be viewed on list
		{
				new DishList(R.drawable.ribs, "Ribs", "Good"),
	            new DishList(R.drawable.ic_launcher, "Android", "Bad"),
	            new DishList(R.drawable.ribs, "Food", "OK"),
	            new DishList(R.drawable.ic_launcher, "Food_2", "Terrible"),
	            new DishList(R.drawable.ribs, "Ribs", "Great"),
	            new DishList(R.drawable.ribs, "VANCOUVER", "Best"),
	            new DishList(R.drawable.burger, "This is a really long line of text for testing", "meh"),
	            new DishList(R.drawable.burger, "Seattle", "Decent"),
	            new DishList(R.drawable.ic_launcher, "CANUCKS", "best")
		};
		
		DishListAdapter adapter = new DishListAdapter(this,
				R.layout.dish_list_row, dish_data);
		
		dish_listview = (ListView)findViewById(R.id.dish_listview);
		
        View header = (View)getLayoutInflater().inflate(R.layout.dish_list_header, null);

        dish_listview.addHeaderView(header);
        dish_listview.setAdapter(adapter);		
	}
}	
