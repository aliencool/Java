package org.grade.graph;

import org.grade.bean.Get_Excel_twice;
import org.grade.bean.Save_command;
import org.grade.bean.Save_twice;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionSupport;

public class two_graph_zhu extends ActionSupport{
	
	
	private  JFreeChart chart;   
	
	    public  JFreeChart getChart() {   
	        return  chart;   
	    }   
	  
	    public   void  setChart(JFreeChart chart) {   
	        this.chart = chart;   
	    }   
	  
	    @Override    
	   public  String execute()  throws  Exception {   
	       // ���÷���    
	       this.chart = show_column();   
	       return  SUCCESS;   
	   }   


	
	
	public JFreeChart  show_column()
	{
		//��һֵ,������:����
 
    	DefaultCategoryDataset categoryDataset=new DefaultCategoryDataset();
			for (int i = 1; i <=Get_Excel_twice.getA_row(); i++) {
				categoryDataset.addValue(Save_twice.getY1()[i], "�б�", 1+"-"+i+"");
				
			}
			for (int i = 1; i <=Get_Excel_twice.getB_row(); i++) {
				categoryDataset.addValue(Save_twice.getY2()[i], "�б�",  2+"-"+i+"");
				
			}
			for (int i = 1; i <=Get_Excel_twice.getC_row(); i++) {
				categoryDataset.addValue(Save_twice.getY3()[i], "�б�",  3+"-"+i+"");
				
			}
			
			
			
			JFreeChart jFreeChart= ChartFactory.createBarChart3D("�����б�", "A:1- B:2-", "��ֵ", categoryDataset,  PlotOrientation.VERTICAL, false, false, false);
	
		return jFreeChart;
		
		
	}
}
