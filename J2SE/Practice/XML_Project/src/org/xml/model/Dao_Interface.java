package org.xml.model;

import org.xml.bean.Data_Bean;

public interface  Dao_Interface {
	public abstract  Data_Bean getData_Name();
	public abstract  Data_Bean getColumn_Name(String T_name);
	public abstract  void Insert(String []values);
}
