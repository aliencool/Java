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
	//先得到excel文件
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
		//excel poi ss全部导入包
		try {
			//定义输入区:
			inputStream=new FileInputStream(f);
			//创建excel分析
			
			Workbook workbook = WorkbookFactory.create(inputStream);
			//得到总N个excel 	int count=workbook.getNumberOfSheets();
		    //得到sheet
			Sheet sheet=workbook.getSheetAt(0);
			//得到列数(通过数组映射模型算法?)

			
			//得到A有几行或者B有几行 0行说明行删除
			for (int i = 1; i <=3; i++) {
				//先得到这一行
				Row row=sheet.getRow(i);
				
				
				//0列数据为空 2列数组为A 均不要
				//得到列getcell
				Cell cell=row.getCell(2);
				//就是A列
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
			
		
		//存放数据A 问题:从0开始没有减
		double[][] X1=new double[Get_Excel_twice.getA_row()+1][4];
		 for(int i=0;i<Get_Excel_twice.getA_row();i++)
		 {
			 //得到数据第一行
			 Row row=sheet.getRow(4+i);
			 //得到列个数
			 colunm_count=row.getPhysicalNumberOfCells();
			 System.out.println("column"+colunm_count);
			 //剔除列
			 for (int j = 1; j <colunm_count; j++) {
				Cell cell=row.getCell(j);
			
				//从第0 而算法是第一行，所以，要加
				X1[i+1][j]=cell.getNumericCellValue();
				
			}
			 
		 }
		 Get_Excel_twice.setX1(X1);
		 
		//存放数据B
		 double[][] X2=new double[Get_Excel_twice.getB_row()+1][4];
		 for(int i=0;i<Get_Excel_twice.getB_row();i++)
		 {
			 //得到数据从a开始行
			 Row row=sheet.getRow(4+Get_Excel_twice.getA_row()+i);
			 //得到列
			 colunm_count=row.getPhysicalNumberOfCells();
			 //剔除列
			 for (int j = 1; j <colunm_count; j++) {
				Cell cell=row.getCell(j);
				//从第0 而算法是第一行，所以，要加
				X2[i+1][j]=cell.getNumericCellValue();
				
			}
			 
		 }
		 Get_Excel_twice.setX2(X2);
		 
			//存放数据C
		 double[][] X3=new double[Get_Excel_twice.getC_row()+1][4];
		 for(int i=0;i<Get_Excel_twice.getC_row();i++)
		 {
			 //得到数据从a开始行
			 Row row=sheet.getRow(4+Get_Excel_twice.getA_row()+Get_Excel_twice.getB_row()+i);
			 //得到列
			 colunm_count=row.getPhysicalNumberOfCells();
			 //剔除列
			 for (int j = 1; j <colunm_count; j++) {
				Cell cell=row.getCell(j);
				//从第0 而算法是第一行，所以，要加
				X3[i+1][j]=cell.getNumericCellValue();
				
			}
			 
		 }
		 Get_Excel_twice.setX3(X3);
		 
		 
		 
		 //关闭
		 closestream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void getExcel_command()
	{
		try{
			//定义输入区:
			inputStream=new FileInputStream(f);
			//创建excel分析
			
			Workbook workbook = WorkbookFactory.create(inputStream);
			//得到总N个excel 	int count=workbook.getNumberOfSheets();
		    //得到sheet
			Sheet sheet=workbook.getSheetAt(0);
			
			//得到行数
			int row_count=sheet.getPhysicalNumberOfRows();
			
			//设置行数
			Get_Excel_command.setIntRow(row_count);
			//创建设置的xy
			double[][] xy=null;
			//遍历   0行舍弃,无意义
			
			
			//不能相等 相等超过数据
			for (int i = 1; i <row_count; i++) {
				//得到row 
				Row row=sheet.getRow(i);
				
				//得到当前列个数
				int colunm_count=row.getPhysicalNumberOfCells();
				
				//只得到一次列数
				//根据行数与列数创建数组
				if(i==1){	
					Get_Excel_command.setIntCol(colunm_count);
					xy=new double[Get_Excel_command.getIntRow()+1][Get_Excel_command.getIntCol()+1];
				}
				
				for (int j = 1; j <colunm_count; j++) {
					//得到每一个函数
					xy[i][j]=row.getCell(j).getNumericCellValue();
					
				}
				
			}
			//设置值
			
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
