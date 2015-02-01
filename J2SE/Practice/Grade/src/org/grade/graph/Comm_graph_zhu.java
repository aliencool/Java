package org.grade.graph;

import org.grade.bean.Get_Excel_command;
import org.grade.bean.Get_Excel_twice;
import org.grade.bean.Save_command;
import org.grade.bean.Save_twice;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionSupport;

public class Comm_graph_zhu extends ActionSupport{
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
		       //��ת����Ӧ��ҳ��
		       return  SUCCESS;   
		   }   
	    
	    
	    public JFreeChart  show_column()
		{
	    	
		
				DefaultCategoryDataset categoryDataset=new DefaultCategoryDataset();
				//��һֵ,������:����
				for (int i = 1; i <Get_Excel_command.getIntRow(); i++) {
					
				
					categoryDataset.addValue(Save_command.getNew_Sort()[i][3], "�б�", i+"��");
					
				}
				
				JFreeChart jFreeChart= ChartFactory.createBarChart3D("���б�", "����:1-2-3", "��ֵ", categoryDataset,  PlotOrientation.VERTICAL, true, false, false);
				
				
				
			return jFreeChart;
			
			
		}
	
}
