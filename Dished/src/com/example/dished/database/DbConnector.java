package com.example.dished.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DbConnector {

	DishedDbHelper dbHelper;
	SQLiteDatabase db;
	
	public DbConnector(Context context) {
		dbHelper = new DishedDbHelper(context);
	}
	
	public void open() throws SQLException{
		db = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public long insertRecord(ContentValues values) {
//		db = dbHelper.getWritableDatabase();
		long newRowId = 0;
		newRowId = db.insert(DishedTable.TABLE_NAME, null, values);
		return newRowId;
	}
	
	public List<Map<String,Object>> readAllRecords() {
//		db = dbHelper.getWritableDatabase();
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
//		db = dbHelper.getWritableDatabase();
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
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_DISH}; 
		Cursor c = unsortedCursor(columns);
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
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_OVERALL};
		Cursor c = unsortedCursor(columns);
		String dish_overall = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_OVERALL);	
		if(c.moveToPosition(pk-1)){
			dish_overall = c.getString(colOverall);
			Log.i("Move_overall", "Successful");
		} else Log.i("Move_overall", "FAIL");
		return dish_overall;
	}
	
	public String getRestaurant(int pk){
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_RESTAURANT};
		Cursor c = unsortedCursor(columns);
		String restaurant = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_RESTAURANT);	
		if(c.moveToPosition(pk-1)){
			restaurant = c.getString(colOverall);
			Log.i("Move_rest", "Successful");
		} else Log.i("Move_rest", "FAIL");
		return restaurant;
	}
	
	public String getPrice(int pk){
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_PRICE};
		Cursor c = unsortedCursor(columns);
		String price = "";
		int colOverall = c.getColumnIndex(DishedTable.COL_PRICE);	
		if(c.moveToPosition(pk-1)){
			price = c.getString(colOverall);
			Log.i("Move_rest", "Successful");
		} else Log.i("Move_rest", "FAIL");
		return price;
	}
	
	public String getTime(int pk){
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_TIME};
		Cursor c = unsortedCursor(columns);
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
	//	db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_ID};
		Cursor c = unsortedCursor(columns);
		total = c.getCount();
		return total;
	}

	public String getSortedDish(int pk, String sortBy){
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_DISH}; 
		Cursor c = null;
		if(sortBy.equals(DishedTable.COL_DISH)){
//			columns[0] = DishedTable.COL_DISH;
			c = sortBy(columns, DishedTable.COL_DISH);
		}else if(sortBy.equals(DishedTable.COL_RESTAURANT)){
//			columns[0] = DishedTable.COL_DISH;
			c = sortBy(columns, DishedTable.COL_RESTAURANT);
		}else if(sortBy.equals(DishedTable.COL_ID)){
//			columns[0] = DishedTable.COL_DISH;
			c = sortBy(columns, DishedTable.COL_ID);
		}
		String dish_name = null;
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
	
	public String getSortedRest(int pk, String sortBy){
//		db = dbHelper.getWritableDatabase();
		String[] columns = {DishedTable.COL_RESTAURANT}; 
		Cursor c = null;
		if(sortBy.equals(DishedTable.COL_DISH)){
			c = sortBy(columns, DishedTable.COL_DISH);
		
		}else if(sortBy.equals(DishedTable.COL_RESTAURANT)){
			c = sortBy(columns, DishedTable.COL_RESTAURANT);
		
		}else if(sortBy.equals(DishedTable.COL_ID)){
			c = sortBy(columns, DishedTable.COL_ID);
		}
		String rest_name = "";
		int colRest = c.getColumnIndex(DishedTable.COL_RESTAURANT);
		int index = pk-1;
		Log.i("index", ""+index);
		Log.i("num_dishes", ""+c.getCount());
		if(c.moveToPosition(index)){
			rest_name = c.getString(colRest);
			Log.i("Move_name", "Successful "+c.getPosition());
		} else Log.i("Move_name", "FAIL "+c.getPosition());
		return rest_name;
	}

	
//	public String getDishSortedByName(int pk){
////		db = dbHelper.getWritableDatabase();
//		String[] columns = {DishedTable.COL_DISH}; 
//		Cursor c = sortByName(columns);
//		String dish_name = "";
//		int colDish = c.getColumnIndex(DishedTable.COL_DISH);
//		int index = pk-1;
//		Log.i("index", ""+index);
//		Log.i("num_dishes", ""+c.getCount());
//		if(c.moveToPosition(index)){
//			dish_name = c.getString(colDish);
//			Log.i("Move_name", "Successful "+c.getPosition());
//		} else Log.i("Move_name", "FAIL "+c.getPosition());
//		return dish_name;
//	}
//	
//	public String getDishSortedByRest(int pk){
////		db = dbHelper.getWritableDatabase();
//		String[] columns = {DishedTable.COL_DISH}; 
//		Cursor c = sortByRest(columns);
//		String dish_name = "";
//		int colDish = c.getColumnIndex(DishedTable.COL_DISH);
//		int index = pk-1;
//		Log.i("index", ""+index);
//		Log.i("num_dishes", ""+c.getCount());
//		if(c.moveToPosition(index)){
//			dish_name = c.getString(colDish);
//			Log.i("Move_name", "Successful "+c.getPosition());
//		} else Log.i("Move_name", "FAIL "+c.getPosition());
//		return dish_name;
//	}
	
	
//	public String getRestSortedByName(int pk){
////		db = dbHelper.getWritableDatabase();
//		String[] columns = {DishedTable.COL_RESTAURANT}; 
//		Cursor c = sortByName(columns);
//		String rest_name = "";
//		int colRest = c.getColumnIndex(DishedTable.COL_RESTAURANT);
//		int index = pk-1;
//		Log.i("index", ""+index);
//		Log.i("num_dishes", ""+c.getCount());
//		if(c.moveToPosition(index)){
//			rest_name = c.getString(colRest);
//			Log.i("Move_name", "Successful "+c.getPosition());
//		} else Log.i("Move_name", "FAIL "+c.getPosition());
//		return rest_name;
//	}
//	
//	public String getRestSortedByRest(int pk){
////		db = dbHelper.getWritableDatabase();
//		String[] columns = {DishedTable.COL_RESTAURANT};
//		Cursor c = sortByRest(columns);
//		String restaurant = "";
//		int colOverall = c.getColumnIndex(DishedTable.COL_RESTAURANT);	
//		if(c.moveToPosition(pk-1)){
//			restaurant = c.getString(colOverall);
//			Log.i("Move_rest", "Successful");
//		} else Log.i("Move_rest", "FAIL");
//		return restaurant;
//	}
	
	public Cursor sortBy(String[] columns, String sortBy){
		return db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, sortBy);
	}
	
	public Cursor unsortedCursor(String[] columns){
		return db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, null);
	}
}
