package com.example.dished;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.dished.database.DbConnector;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class DishListActivity extends Activity {
	
	private ListView dish_listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dish_list);
		
//		DishList dish_data[] = new DishList[]	//data of items to be viewed on list
//		{
//				new DishList(R.drawable.ic_launcher, "Ribs", "Good"),
//	            new DishList(R.drawable.ic_launcher, "Android", "Bad"),
//	            new DishList(R.drawable.ic_launcher, "Food", "OK")
//		};

		DbConnector db = DishOptions.db;//MainActivity.db;
	
    	//Assigning data from DB
		DishList[] dish_data = new DishList[db.getTotal()];
		for(int i=0; i<db.getTotal(); i++){
			int key = i+1;
			dish_data[i] = new DishList(R.drawable.ic_launcher, db.getDish(key), db.getOverall(key));
		}

//		dish_data[0] = new DishList(R.drawable.ic_launcher, "Ribs", "Ribs");
		
		//Displaying in a listrow
		DishListAdapter adapter = new DishListAdapter(this, R.layout.dish_list_row, dish_data);
		
		//Displaying listrows in a listview
		dish_listview = (ListView)findViewById(R.id.dish_listview);
        dish_listview.setAdapter(adapter);		
        
        //Starting new activity when a list row is clicked
        dish_listview.setOnItemClickListener(new OnItemClickListener(){
        	
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting values from selected ListItem
            	String name = ((TextView) view.findViewById(R.id.txtName)).getText().toString();
                String description = ((TextView) view.findViewById(R.id.txtRating)).getText().toString();
                int index = position;
                // Starting new intent
                Intent in = new Intent(getApplicationContext(), OneDishActivity.class);
                in.putExtra("name", name);
                in.putExtra("rating", description);
                in.putExtra("index", index);
                startActivity(in);
            }
        });
        	
	}

}	
