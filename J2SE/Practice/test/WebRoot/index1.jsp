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
  dataset.addValue(1, "����", "ƻ��");//   ����,ÿ���Ӳ�Ʒ,�ܷ���
  dataset.addValue(2, "�Ϻ�", "ƻ��");
  dataset.addValue(3, "����", "ƻ��");
  dataset.addValue(4, "����", "����");
  dataset.addValue(5, "�Ϻ�", "����");
  dataset.addValue(1, "����", "����");
  dataset.addValue(2, "����", "����");
  dataset.addValue(3, "�Ϻ�", "����");
  dataset.addValue(4, "����", "����");
  dataset.addValue(5, "����", "�㽶");
  dataset.addValue(1, "�Ϻ�", "�㽶");
  dataset.addValue(2, "����", "�㽶");
  dataset.addValue(3, "����", "��֦");
  dataset.addValue(4, "�Ϻ�", "��֦");
  dataset.addValue(5, "����", "��֦");
  
JFreeChart chart = ChartFactory.createBarChart3D("ˮ������ͳ��ͼ",   
                  "ˮ��",  
                  "����",  
                  dataset,  
                  PlotOrientation.VERTICAL,  
                  false,  
                  false,  
                  false);  

    ChartUtilities.writeChartAsJPEG(response.getOutputStream(),chart,640,400);
%>