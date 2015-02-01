package com.Bean;

public class NavigationBean {
	private String category_name;
	private String category_son_name;
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String categoryName) {
		category_name = categoryName;
	}

	public NavigationBean(String categoryName) {
		super();
		category_name = categoryName;
	}
	
	
	
	public String getCategory_son_name() {
		return category_son_name;
	}

	public void setCategory_son_name(String categorySonName) {
		category_son_name = categorySonName;
	}

	public NavigationBean() {
	
	}

	public NavigationBean(String categoryName, String categorySonName) {
		super();
		category_name = categoryName;
		category_son_name = categorySonName;
	}
	
}
