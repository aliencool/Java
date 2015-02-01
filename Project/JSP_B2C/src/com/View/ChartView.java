package com.View;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;





public class ChartView {
	//图形
	private static JFreeChart chart;
	//文件路径
	private static String filename="";
	//最终显示信息
	private static String imgurl="";
	//创建数据集
	public  static  void Create_View_Chart(ResultSet resultSet,String catagory,HttpSession session,PrintWriter writer,HttpServletRequest request)
	{
		if(catagory.equals("All"))
		{
			DefaultCategoryDataset categoryDataset=new DefaultCategoryDataset();
			try {
				while(resultSet.next())
				{
					//判断是全部
						categoryDataset.addValue(resultSet.getInt(2), resultSet.getString(1),"");
					
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置图形
			chart=ChartFactory.createBarChart3D(catagory+" Top Shops",
					"商品名称",//行
					"好评度", categoryDataset,   PlotOrientation.VERTICAL, true, true, false);
		}
		else
		{
			DefaultPieDataset pieDataset=new DefaultPieDataset();
			try {
				while(resultSet.next())
				{
					
					pieDataset.setValue(resultSet.getString(1),resultSet.getInt(2));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置图形
			chart=ChartFactory.createPieChart(catagory+" Top Shops",pieDataset, true, true, false);
			
		}
		if(catagory.equals("All"))
		{
		 CategoryPlot plot = (CategoryPlot)chart.getPlot();
		 BarRenderer3D renderer1 = new BarRenderer3D();
		 renderer1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		 renderer1.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 10));
		 renderer1.setBaseItemLabelsVisible(true);
		  // 设置柱子边框颜色
		  // renderer1.setBaseOutlinePaint(Color.BLACK);
		  // 设置柱子边框可见
		  // renderer1.setDrawBarOutline(true);
		  // 设置每个地区所包含的平行柱的之间距离，数值越大则间隔越大，图片大小一定的情况下会影响柱子的宽度，可以为负数
		  renderer1.setItemMargin(0.3);
		  // 阴影颜色
		  // renderer1.setShadowPaint(Color.white);
		  plot.setRenderer(renderer1);
		}
		else
		{
			
			
		}
		
		try {
			filename=ServletUtilities.saveChartAsJPEG(chart, 500, 500,null ,session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgurl="http://172.16.142.98:8080"+request.getContextPath()+"/servlet/DisplayChart?filename="+filename;
		//设置图片地址为
		ServletUtilities.setTempFilePrefix("public-jfreechart-");
		session.setAttribute("imgurl", imgurl);	
	}
	
		
}
