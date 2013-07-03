package com.example.dished.database;

import android.provider.BaseColumns;

public class DishedTable implements BaseColumns {

	public static final String TABLE_NAME = "Dishes_Table";
	public static final String COL_ID = BaseColumns._ID;
	public static final String COL_DISH = "Dish_Name";
	public static final String COL_RESTAURANT = "Restaurant_Name";
	public static final String COL_PRICE = "Price";
	public static final String COL_OVERALL = "Overall_Rating";
	public static final String COL_HEAT = "Heat";
	public static final String COL_SWEET = "Sweetness";
	public static final String COL_TIME = "PrepTime";
	public static final String COL_SIZE = "PortionSize";
	public static final String COL_EXTRA = "Comments";
	
	protected static final String INT_TYPE = "INTEGER";
	protected static final String TEXT_TYPE = "TEXT";
	protected static final String DOUBLE_TYPE = "REAL";
	
	private DishedTable() { // empty constructor (we dont want this to be called ever)
	}
	
}
