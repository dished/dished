package com.example.dished.database;

import android.provider.BaseColumns;

public class DishedTable implements BaseColumns {

	protected static final String TABLE_NAME = "Dishes_Table";
	
	protected static final String COL_DISH = "Dish_Name";
	protected static final String COL_RESTAURANT = "Restaurant_Name";
	protected static final String COL_PRICE = "Price";
	protected static final String COL_OVERALL = "Overall_Rating";
	protected static final String COL_HEAT = "Heat";
	protected static final String COL_SWEET = "Sweetness";
	protected static final String COL_TIME = "PrepTime";
	protected static final String COL_SIZE = "PortionSize";
	protected static final String COL_EXTRA = "Comments";
	
	protected static final String INT_TYPE = "INTEGER";
	protected static final String TEXT_TYPE = "TEXT";
	protected static final String DOUBLE_TYPE = "REAL";
	
	private DishedTable() { // empty constructor (we dont want this to be called ever)
	}
	
}
