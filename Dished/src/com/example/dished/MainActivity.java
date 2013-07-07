package com.example.dished;


import java.util.List;
import java.util.Map;

import com.example.dished.database.DbConnector;
import com.example.dished.database.DishedTable;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Activity = anything that can be displayed on phone
public class MainActivity extends Activity{
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //clicking "camera" button
        Button camera = (Button) findViewById(R.id.btn_camera);
        camera.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent (android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			}
        });
        
        
        //clicking "New Dished" button
        Button new_dish = (Button) findViewById(R.id.btn_new_dish);
        new_dish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startNewDish(v);
			}
		});
        
        //Clicking "View dishes" button
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
    	Intent intent = new Intent(v.getContext(), DishOptions.class);
    	startActivity(intent);
    }
    

  //method called when user clicks "View dishes" button
    public void startDishList(View v){
    	Intent intent = new Intent(this, DishListActivity.class);
    	startActivity(intent);
    }
    
    static DbConnector db = new DbConnector();
    public void DbTest (View view) {
    	Toast.makeText(this, "Running a DbTest", Toast.LENGTH_LONG).show();
    	ContentValues cv = new ContentValues();
    	
    	cv.put(DishedTable.COL_ID, 1);
    	cv.put(DishedTable.COL_DISH, "Kung Pao Chicken1");
    	cv.put(DishedTable.COL_OVERALL, "Awesome1");
    	db.insertRecord(cv);
    	
    	cv.put(DishedTable.COL_ID, 2);
    	cv.put(DishedTable.COL_DISH, "Kung Pao Chicken2");
    	cv.put(DishedTable.COL_OVERALL, "Sucked2");
    	db.insertRecord(cv);
    	
    	cv.put(DishedTable.COL_ID, 3);
    	cv.put(DishedTable.COL_DISH, "Kung Pao Chicken3");
    	cv.put(DishedTable.COL_OVERALL, "Sucked3");
    	db.insertRecord(cv);
    	
    	Log.i("DbTest", "Check1 ");
    	
    	List<Map<String,Object>> reviewList = db.readAllRecords();
    	
    	for (Map<String,Object> review : reviewList) {
    		String key = review.get(DishedTable.COL_ID).toString();
    		Log.i("DbTest ID", ""+Integer.parseInt(key));
    		Log.i("DbTest name", review.get(DishedTable.COL_DISH).toString());
    		Log.i("DbTest overall", review.get(DishedTable.COL_OVERALL).toString());
    	}
    }
    
}
