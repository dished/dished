package com.example.dished;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * Creating a custom Adapter for ListView
 */
public class DishListAdapter extends ArrayAdapter<DishList> {
	
	Context context;
	int layoutResourceId;
	DishList data[]=null;
	
	public DishListAdapter(Context context, int layoutResourceId, DishList[] data){
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}
	
	static class DishListHolder{	//Temporary holder for efficiency
		ImageView imgIcon;
		TextView txtName;
		TextView txtRating;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
		DishListHolder holder = null;
		
		if(row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new DishListHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtName = (TextView)row.findViewById(R.id.txtName);
            holder.txtRating = (TextView)row.findViewById(R.id.txtRating);
            
            row.setTag(holder);
		}
		
		else{
			holder = (DishListHolder)row.getTag();
		}
		
		DishList dishlist = data[position];
		holder.txtName.setText(dishlist.name);
		holder.txtRating.setText(dishlist.rating);
		holder.imgIcon.setImageResource(dishlist.icon);
		
		return row;
	}

}
