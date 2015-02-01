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
	//ͼ��
	private static JFreeChart chart;
	//�ļ�·��
	private static String filename="";
	//������ʾ��Ϣ
	private static String imgurl="";
	//�������ݼ�
	public  static  void Create_View_Chart(ResultSet resultSet,String catagory,HttpSession session,PrintWriter writer,HttpServletRequest request)
	{
		if(catagory.equals("All"))
		{
			DefaultCategoryDataset categoryDataset=new DefaultCategoryDataset();
			try {
				while(resultSet.next())
				{
					//�ж���ȫ��
						categoryDataset.addValue(resultSet.getInt(2), resultSet.getString(1),"");
					
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//����ͼ��
			chart=ChartFactory.createBarChart3D(catagory+" Top Shops",
					"��Ʒ����",//��
					"������", categoryDataset,   PlotOrientation.VERTICAL, true, true, false);
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
			//����ͼ��
			chart=ChartFactory.createPieChart(catagory+" Top Shops",pieDataset, true, true, false);
			
		}
		if(catagory.equals("All"))
		{
		 CategoryPlot plot = (CategoryPlot)chart.getPlot();
		 BarRenderer3D renderer1 = new BarRenderer3D();
		 renderer1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		 renderer1.setBaseItemLabelFont(new Font("����", Font.BOLD, 10));
		 renderer1.setBaseItemLabelsVisible(true);
		  // �������ӱ߿���ɫ
		  // renderer1.setBaseOutlinePaint(Color.BLACK);
		  // �������ӱ߿�ɼ�
		  // renderer1.setDrawBarOutline(true);
		  // ����ÿ��������������ƽ������֮����룬��ֵԽ������Խ��ͼƬ��Сһ��������»�Ӱ�����ӵĿ�ȣ�����Ϊ����
		  renderer1.setItemMargin(0.3);
		  // ��Ӱ��ɫ
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
		//����ͼƬ��ַΪ
		ServletUtilities.setTempFilePrefix("public-jfreechart-");
		session.setAttribute("imgurl", imgurl);	
	}
	
		
}
