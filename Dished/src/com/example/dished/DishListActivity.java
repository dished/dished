package com.example.dished;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.dished.database.DbConnector;
import com.example.dished.database.DishedTable;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class DishListActivity extends Activity{
	
	private ListView dish_listview;
	DbConnector db = new DbConnector(this);;
	DishList[] dish_data;
	private Button sortName;
	private TextView sortedData;
	private Button sortRest;
	private Button sortID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dish_list);
		db.open();
		initialize();
		sortName.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//db.sortName();
				sortedData.setText(db.sortedData());
				assignSortedData();
			}
		});
		
		sortID.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				assignSortedDataID();
			}
		});
		
		sortRest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				assignSortedDataRest();
			}
		});
		
		assignData();
        
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
	
	public void assignData(){
		dish_data = new DishList[db.getTotal()];
    	//Assigning data from DB
		for(int i=0; i<db.getTotal(); i++){
			int key = i+1;
			dish_data[i] = new DishList(R.drawable.ic_launcher, db.getDish(key), db.getRestaurant(key));
		}
		//Displaying in a listrow
		DishListAdapter adapter = new DishListAdapter(this, R.layout.dish_list_row, dish_data);
		
		//Displaying listrows in a listview
		dish_listview = (ListView)findViewById(R.id.dish_listview);
        dish_listview.setAdapter(adapter);	
	}
	
	public void assignSortedData(){
		dish_data = new DishList[db.getTotal()];
    	//Assigning data from DB
		for(int i=0; i<db.getTotal(); i++){
			int key = i+1;
			dish_data[i] = new DishList(R.drawable.ic_launcher, db.getSortedDish(key), 
					db.getRestaurant(key));
		}
		//Displaying in a listrow
		DishListAdapter adapter = new DishListAdapter(this, R.layout.dish_list_row, dish_data);
		
		//Displaying listrows in a listview
		dish_listview = (ListView)findViewById(R.id.dish_listview);
        dish_listview.setAdapter(adapter);	
        adapter.notifyDataSetChanged();
	}
	
	public void assignSortedDataID(){
		dish_data = new DishList[db.getTotal()];
    	//Assigning data from DB
		for(int i=0; i<db.getTotal(); i++){
			int key = i+1;
//			dish_data[i] = new DishList(R.drawable.ic_launcher, db.getSortedDishID(key), db.getRestaurant(key));
			dish_data[i] = new DishList(R.drawable.ic_launcher, db.getSortedDishID(key), db.getRestaurant(key));
		}
		//Displaying in a listrow
		DishListAdapter adapter = new DishListAdapter(this, R.layout.dish_list_row, dish_data);
		
		//Displaying listrows in a listview
		dish_listview = (ListView)findViewById(R.id.dish_listview);
        dish_listview.setAdapter(adapter);	
        adapter.notifyDataSetChanged();
	}
	
	public void assignSortedDataRest(){
		dish_data = new DishList[db.getTotal()];
    	//Assigning data from DB
		for(int i=0; i<db.getTotal(); i++){
			int key = i+1;
//			dish_data[i] = new DishList(R.drawable.ic_launcher, db.getSortedDishRest(key), db.getSortedRest(key));
			dish_data[i] = 
			new DishList(R.drawable.ic_launcher, db.getSortedDishRest(key), db.getRestaurant(key));
		}
		//Displaying in a listrow
		DishListAdapter adapter = new DishListAdapter(this, R.layout.dish_list_row, dish_data);
		
		//Displaying listrows in a listview
		dish_listview = (ListView)findViewById(R.id.dish_listview);
        dish_listview.setAdapter(adapter);	
        adapter.notifyDataSetChanged();
	}
	
	public void initialize(){
		sortName = (Button) findViewById(R.id.bSortName);
		sortName.setText("Sort by Name");
		sortedData=(TextView) findViewById(R.id.tvResult);
 		sortRest = (Button) findViewById(R.id.bSortRest);
 		sortRest.setText("Sort by Rest");
 		sortID = (Button) findViewById(R.id.bSortID);
 		sortID.setText("Sort by ID");
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
