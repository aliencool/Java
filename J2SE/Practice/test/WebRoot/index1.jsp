<%@page contentType="text/html; charset=GB2312"%>

<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>

<%@page import="java.io.IOException"%>

<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.data.category.CategoryDataset"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="org.jfree.data.*"%>
<%@page import="java.awt.Color"%>
<%@page import="org.jfree.chart.renderer.category.*"%>
<%@page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator"%>
<%@page import="org.jfree.chart.axis.*"%>
<%@page import="org.jfree.chart.plot.CategoryPlot"%>

<%
  DefaultCategoryDataset dataset    = new DefaultCategoryDataset();
  dataset.addValue(1, "北京", "苹果");//   数据,每个子产品,总分类
  dataset.addValue(2, "上海", "苹果");
  dataset.addValue(3, "广州", "苹果");
  dataset.addValue(4, "北京", "梨子");
  dataset.addValue(5, "上海", "梨子");
  dataset.addValue(1, "广州", "梨子");
  dataset.addValue(2, "北京", "葡萄");
  dataset.addValue(3, "上海", "葡萄");
  dataset.addValue(4, "广州", "葡萄");
  dataset.addValue(5, "北京", "香蕉");
  dataset.addValue(1, "上海", "香蕉");
  dataset.addValue(2, "广州", "香蕉");
  dataset.addValue(3, "北京", "荔枝");
  dataset.addValue(4, "上海", "荔枝");
  dataset.addValue(5, "广州", "荔枝");
  
JFreeChart chart = ChartFactory.createBarChart3D("水果销量统计图",   
                  "水果",  
                  "销量",  
                  dataset,  
                  PlotOrientation.VERTICAL,  
                  false,  
                  false,  
                  false);  

    ChartUtilities.writeChartAsJPEG(response.getOutputStream(),chart,640,400);
%>