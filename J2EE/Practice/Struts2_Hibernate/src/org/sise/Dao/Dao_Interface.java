package org.sise.Dao;

import java.util.List;

import org.sise.bean.News;

public interface Dao_Interface {
	   public List All_search();
	   public List All_search_four();
	   public boolean   update(News nb,int id,String time);
	   public boolean   insert(News nb);
	   public boolean   delete(int id);
	   public News Part_search_id(String id);
	   public List Part_search_title(String title);
	   public List like_search(String condition,String text,String time_max,String time_min);
}
