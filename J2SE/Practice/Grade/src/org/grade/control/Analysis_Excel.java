package org.grade.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.ServletActionContext;
import org.grade.Model_Get_Data_Excel.Excel_until;
import org.grade.model_command.Logic_CalCoeD2;
import org.grade.model_twice.logic;

import com.opensymphony.xwork2.ActionSupport;

public class Analysis_Excel extends ActionSupport {

	private String choice;
	

	
	
	public String getChoice() {
		return choice;
	}




	public void setChoice(String choice) {
		this.choice = choice;
	}




	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//ÉÏ´«
		
		//ÅÐ¶ÏËã·¨
		if(getChoice().equals("tw"))
		{
			return "tw";
			
		}
		else if(getChoice().equals("com"))
		{
			return "com";
		}
		System.out.println(getChoice());
		
		return INPUT;
	}

	
}
