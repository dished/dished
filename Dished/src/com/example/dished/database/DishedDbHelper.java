package com.example.dished.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DishedDbHelper extends SQLiteOpenHelper {

	public static String DATABASE_NAME = "Dished.db";
	
	public DishedDbHelper(Context context) {
		super(null, null, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(createDishTableSql());
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(deleteDishTableSql());
		onCreate(db);
	}
	
	public String createDishTableSql() {
		String createTableSql = "CREATE TABLE " + DishedTable.TABLE_NAME + "(" +
				DishedTable.COL_DISH + " " + DishedTable.TEXT_TYPE + "," +
				DishedTable.COL_RESTAURANT + " " + DishedTable.TEXT_TYPE + "," +
				DishedTable.COL_OVERALL + " " + DishedTable.DOUBLE_TYPE + "," +
				DishedTable.COL_PRICE + " " + DishedTable.DOUBLE_TYPE + "," +
				DishedTable.COL_HEAT + " " + DishedTable.DOUBLE_TYPE + "," +
				DishedTable.COL_SWEET + " " + DishedTable.DOUBLE_TYPE + "," +
				DishedTable.COL_TIME + " " + DishedTable.DOUBLE_TYPE + "," +
				DishedTable.COL_SIZE + " " + DishedTable.DOUBLE_TYPE + "," +
				DishedTable.COL_EXTRA + " " + DishedTable.TEXT_TYPE + ")";
		return createTableSql;
	}
	
	public String deleteDishTableSql() {
		String dropSql = "DELETE IF EXISTS " + DishedTable.TABLE_NAME;
		return dropSql;
	}
	
	public String insertDishRecordSql(ContentValues values) {
		String insertSql = "";
		return insertSql;
	}
	
}
