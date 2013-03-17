package com.example.dished.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
		
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String[] columns = {
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
		
		Cursor c = db.query(DishedTable.TABLE_NAME, columns, null, null, null, null, DishedTable.COL_DISH + " DESC");
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
	
}
