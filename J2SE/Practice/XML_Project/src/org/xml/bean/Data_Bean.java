package org.xml.bean;

import java.util.Map;

public class Data_Bean {
	//���ݿ����Ƽ���
	private String []data_name;
	//���ݿ���������  
	private Map<String,String> column_name;
	//save
	private String []xml_value;
	public String[] getData_name() {
		return data_name;
	}
	public Map<String, String> getColumn_name() {
		return column_name;
	}
	public void setData_name(String[] dataName) {
		data_name = dataName;
	}
	public void setColumn_name(Map<String, String> columnName) {
		column_name = columnName;
	}
	public String[] getXml_value() {
		return xml_value;
	}
	public void setXml_value(String[] xmlValue) {
		xml_value = xmlValue;
	}
	
	
}
