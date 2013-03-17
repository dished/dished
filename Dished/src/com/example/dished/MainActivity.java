package com.example.dished;


import java.util.List;
import java.util.Map;

import com.example.dished.R;
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
	
	EditText first_name;
    Button button1; 
	TextView title;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    // Called when user clicks "View dishes" button
    public void ListView (View view){
    	Intent intent = new Intent(this, ListViewActivity.class);
    	startActivity(intent);
    	
    }
    
    public void DbTest (View view) {
    	
    	Toast.makeText(this, "Running a DbTest", Toast.LENGTH_LONG).show();
    	DbConnector db = new DbConnector();
    	ContentValues cv = new ContentValues();
    	
    	cv.put(DishedTable.COL_DISH, "Kung Pao Chicken");
    	cv.put(DishedTable.COL_OVERALL, "Awesome");
    	db.insertRecord(cv);
    	
    	cv.put(DishedTable.COL_DISH, "Kung Pao Chicken2");
    	cv.put(DishedTable.COL_OVERALL, "Sucked");
    	db.insertRecord(cv);
    	
    	Log.i("DbTest", "Check1");
    	
    	List<Map<String,Object>> reviewList = db.readAllRecords();
    	
    	for (Map<String,Object> review : reviewList) {
    		Log.i("DbTest", review.get(DishedTable.COL_DISH).toString());
    		Log.i("DbTest", review.get(DishedTable.COL_OVERALL).toString());
    	}
    	
    	
    }
    
}
