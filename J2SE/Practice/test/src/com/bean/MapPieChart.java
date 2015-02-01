package com.bean;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * JfreeChart饼状图
 * 数据点使用超链
 * @author archie2010
 * since 2011-4-2上午11:05:50
 */
public class MapPieChart {


    /**
     * 生成Dataset数据集
     * @return
     */
    public static DefaultPieDataset getDataset() {
        //DatasetUtilities.createPieDatasetForColumn(arg0, arg1)
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("苹果", 100);
        pieDataset.setValue("梨子", 200);
        pieDataset.setValue("葡萄", 300);
        pieDataset.setValue("香蕉", 400);
        pieDataset.setValue("荔枝", 500);

        return pieDataset;
    }
    /**
     * 生成JfreeChart对象
     * @param dataset
     * @param title
     * @param width
     * @param height
     * @param session
     * @param pw
     * @param useMap
     * @param is3D
     * @return
     */
    public static String createPieChart(Dataset dataset,String title, int width, int height,
            HttpSession session, PrintWriter pw,String useMap,boolean is3D) {
        String filename = "";

        PiePlot plot = null;
        if(is3D){
            plot = new PiePlot3D((DefaultPieDataset)dataset);// 3D饼图
        }else{
            plot = new PiePlot((DefaultPieDataset)dataset);
        }
        plot.setURLGenerator(new StandardPieURLGenerator("index1.jsp","fruit","pieIdex"));// 设定热区超链接
        
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT,
                plot, true);
        chart.setBackgroundPaint(java.awt.Color.white);// 可选，设置图片背景色
        chart.setTitle(title);// 可选，设置图片标题
        
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());
        plot.setNoDataMessage("无数据显示"); 
        
        StandardEntityCollection sec = new StandardEntityCollection();
        ChartRenderingInfo info = new ChartRenderingInfo(sec);

        try {
            filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
                    session);
            ChartUtilities.writeImageMap(pw, useMap, info, false);// 输出MAP信息
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filename;
    }
}
