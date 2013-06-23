package com.example.dished;

//http://www.ezzylearning.com/tutorial.aspx?tid=1763429 for Custom ListView

public class DishList {
	public int icon;
	public String name;
	public String rating;
	
	public DishList(){
		super();
	}
	
	public DishList(int icon, String name, String rating){	//object with img & title & txt
		super();
		this.icon = icon;
		this.name = name;
		this.rating = rating;
	}

}
