package com.example.dished;

//http://www.ezzylearning.com/tutorial.aspx?tid=1763429 for Custom ListView

public class DishList {
	public int icon;
	public String title;
	public String rating;
	
	public DishList(){
		super();
	}
	
	public DishList(int icon, String title, String rating){	//object with img & title & txt
		super();
		this.icon = icon;
		this.title = title;
		this.rating = rating;
	}

}
