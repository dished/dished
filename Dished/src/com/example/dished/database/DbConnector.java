package com.example.dished.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DbConnector {

	DishedDbHelper dbHelper;
	
	public DbConnector() {
		dbHelper = new DishedDbHelper(null);
	}
	
	public long insertRecord(ContentValues values) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		long newRowId = 0;
		newRowId = db.insert(DishedTable.TABLE_NAME, null, values);
		return newRowId;
	}
	
	public List<Map<String,Object>> readAllRecords() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {
			DishedTable.COL_ID,
			DishedTable.COL_DISH,
			DishedTable.COL_RESTAURANT,
			DishedTable.COL_PRICE,
			DishedTable.COL_OVERALL,
			DishedTable.COL_HEAT,
			DishedTable.COL_SWEET,
			DishedTable.COL_TIME,
			DishedTable.COL_SIZE,
			DishedTable.COL_EXTRA
		};
		
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, DishedTable.COL_ID + " ASC");
		List<Map<String,Object>> reviewList = new ArrayList<Map<String,Object>>();
		
		if (c.moveToFirst()) {
			String element = "";
			do {
				Map<String,Object> review = new HashMap<String,Object>();
				for (int i = 0; i < columns.length; i++) {
					element = c.getString(c.getColumnIndexOrThrow(columns[i]));
					review.put(columns[i], element);
				}
				reviewList.add(review);
			} while (c.moveToNext());
		}
		
		return reviewList;
	}
	
	public String getData(){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_ID, DishedTable.COL_DISH, DishedTable.COL_OVERALL};
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		String result = "";
		int colID = c.getColumnIndex(DishedTable.COL_ID);
		int colDish = c.getColumnIndex(DishedTable.COL_DISH);
		int colOverall= c.getColumnIndex(DishedTable.COL_OVERALL);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(colID)+" "+c.getString(colDish) +" " + c.getString(colOverall);
		}
		return result;
	}
	
	public String getDish(int pk){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_DISH}; 
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		String dish_name = "";
		int colDish = c.getColumnIndex(DishedTable.COL_DISH);
		int index = pk-1;
		Log.i("index", ""+index);
		Log.i("num_dishes", ""+c.getCount());
		if(c.moveToPosition(index)){
			dish_name = c.getString(colDish);
			Log.i("Move_name", "Successful "+c.getPosition());
		} else Log.i("Move_name", "FAIL "+c.getPosition());
		return dish_name;
	}
	
	public String getOverall(int pk){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_OVERALL};
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		String dish_overall = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_OVERALL);	
		if(c.moveToPosition(pk-1)){
			dish_overall = c.getString(colOverall);
			Log.i("Move_overall", "Successful");
		} else Log.i("Move_overall", "FAIL");
		return dish_overall;
	}
	
	public String getRestaurant(int pk){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_RESTAURANT};
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		String restaurant = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_RESTAURANT);	
		if(c.moveToPosition(pk-1)){
			restaurant = c.getString(colOverall);
			Log.i("Move_rest", "Successful");
		} else Log.i("Move_rest", "FAIL");
		return restaurant;
	}
	
	public String getPrice(int pk){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_PRICE};
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		String price = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_PRICE);	
		if(c.moveToPosition(pk-1)){
			price = c.getString(colOverall);
			Log.i("Move_rest", "Successful");
		} else Log.i("Move_rest", "FAIL");
		return price;
	}
	
	public String getTime(int pk){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_TIME};
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		String time = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_TIME);	
		if(c.moveToPosition(pk-1)){
			time = c.getString(colOverall);
			Log.i("Move_rest", "Successful");
		} else Log.i("Move_rest", "FAIL");
		return time;
	}
	
	public int getTotal(){
		int total=0;
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_ID};
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
		total = c.getCount();
		return total;
	}
}
