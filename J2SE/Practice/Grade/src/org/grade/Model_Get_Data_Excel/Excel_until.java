package org.grade.Model_Get_Data_Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.ServletActionContext;
import org.grade.bean.Get_Excel_command;
import org.grade.bean.Get_Excel_twice;

public class Excel_until {
	//�ȵõ�excel�ļ�
	private static File f;
	private static int colunm_count=0;
	private OutputStream outputStream;
	
	private static InputStream inputStream;

	public static File getF() {
		return f;
	}

	public static void setF(File f) {
		Excel_until.f = f;
	}	
	
	public static void getExcel()
	{
		//excel poi ssȫ�������
		try {
			//����������:
			inputStream=new FileInputStream(f);
			//����excel����
			
			Workbook workbook = WorkbookFactory.create(inputStream);
			//�õ���N��excel 	int count=workbook.getNumberOfSheets();
		    //�õ�sheet
			Sheet sheet=workbook.getSheetAt(0);
			//�õ�����(ͨ������ӳ��ģ���㷨?)

			
			//�õ�A�м��л���B�м��� 0��˵����ɾ��
			for (int i = 1; i <=3; i++) {
				//�ȵõ���һ��
				Row row=sheet.getRow(i);
				
				
				//0������Ϊ�� 2������ΪA ����Ҫ
				//�õ���getcell
				Cell cell=row.getCell(2);
				//����A��
				if(i==1)
				{int A_row=(int) cell.getNumericCellValue();
				Get_Excel_twice.setA_row(A_row);}
				else if(i==2)
				{
					int B_row=(int) cell.getNumericCellValue();
				
					Get_Excel_twice.setB_row(B_row);
				}else if(i==3)
				{
					int C_row=(int) cell.getNumericCellValue();
					
					Get_Excel_twice.setC_row(C_row);
				}
			
			}
			
		
		//�������A ����:��0��ʼû�м�
		double[][] X1=new double[Get_Excel_twice.getA_row()+1][4];
		 for(int i=0;i<Get_Excel_twice.getA_row();i++)
		 {
			 //�õ����ݵ�һ��
			 Row row=sheet.getRow(4+i);
			 //�õ��и���
			 colunm_count=row.getPhysicalNumberOfCells();
			 System.out.println("column"+colunm_count);
			 //�޳���
			 for (int j = 1; j <colunm_count; j++) {
				Cell cell=row.getCell(j);
			
				//�ӵ�0 ���㷨�ǵ�һ�У����ԣ�Ҫ��
				X1[i+1][j]=cell.getNumericCellValue();
				
			}
			 
		 }
		 Get_Excel_twice.setX1(X1);
		 
		//�������B
		 double[][] X2=new double[Get_Excel_twice.getB_row()+1][4];
		 for(int i=0;i<Get_Excel_twice.getB_row();i++)
		 {
			 //�õ����ݴ�a��ʼ��
			 Row row=sheet.getRow(4+Get_Excel_twice.getA_row()+i);
			 //�õ���
			 colunm_count=row.getPhysicalNumberOfCells();
			 //�޳���
			 for (int j = 1; j <colunm_count; j++) {
				Cell cell=row.getCell(j);
				//�ӵ�0 ���㷨�ǵ�һ�У����ԣ�Ҫ��
				X2[i+1][j]=cell.getNumericCellValue();
				
			}
			 
		 }
		 Get_Excel_twice.setX2(X2);
		 
			//�������C
		 double[][] X3=new double[Get_Excel_twice.getC_row()+1][4];
		 for(int i=0;i<Get_Excel_twice.getC_row();i++)
		 {
			 //�õ����ݴ�a��ʼ��
			 Row row=sheet.getRow(4+Get_Excel_twice.getA_row()+Get_Excel_twice.getB_row()+i);
			 //�õ���
			 colunm_count=row.getPhysicalNumberOfCells();
			 //�޳���
			 for (int j = 1; j <colunm_count; j++) {
				Cell cell=row.getCell(j);
				//�ӵ�0 ���㷨�ǵ�һ�У����ԣ�Ҫ��
				X3[i+1][j]=cell.getNumericCellValue();
				
			}
			 
		 }
		 Get_Excel_twice.setX3(X3);
		 
		 
		 
		 //�ر�
		 closestream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void getExcel_command()
	{
		try{
			//����������:
			inputStream=new FileInputStream(f);
			//����excel����
			
			Workbook workbook = WorkbookFactory.create(inputStream);
			//�õ���N��excel 	int count=workbook.getNumberOfSheets();
		    //�õ�sheet
			Sheet sheet=workbook.getSheetAt(0);
			
			//�õ�����
			int row_count=sheet.getPhysicalNumberOfRows();
			
			//��������
			Get_Excel_command.setIntRow(row_count);
			//�������õ�xy
			double[][] xy=null;
			//����   0������,������
			
			
			//������� ��ȳ�������
			for (int i = 1; i <row_count; i++) {
				//�õ�row 
				Row row=sheet.getRow(i);
				
				//�õ���ǰ�и���
				int colunm_count=row.getPhysicalNumberOfCells();
				
				//ֻ�õ�һ������
				//����������������������
				if(i==1){	
					Get_Excel_command.setIntCol(colunm_count);
					xy=new double[Get_Excel_command.getIntRow()+1][Get_Excel_command.getIntCol()+1];
				}
				
				for (int j = 1; j <colunm_count; j++) {
					//�õ�ÿһ������
					xy[i][j]=row.getCell(j).getNumericCellValue();
					
				}
				
			}
			//����ֵ
			
			Get_Excel_command.setXY(xy);
			
			
		}
		catch(Exception e)
		{
			System.out.println("error:"+e);
		}
	}
	
	
	
	
	
	
	
	public static void closestream()
	{
			try {
				if(inputStream!=null)
					inputStream.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


	
	
	
	
}
