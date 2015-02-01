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
 * JfreeChart��״ͼ
 * ���ݵ�ʹ�ó���
 * @author archie2010
 * since 2011-4-2����11:05:50
 */
public class MapPieChart {


    /**
     * ����Dataset���ݼ�
     * @return
     */
    public static DefaultPieDataset getDataset() {
        //DatasetUtilities.createPieDatasetForColumn(arg0, arg1)
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("ƻ��", 100);
        pieDataset.setValue("����", 200);
        pieDataset.setValue("����", 300);
        pieDataset.setValue("�㽶", 400);
        pieDataset.setValue("��֦", 500);

        return pieDataset;
    }
    /**
     * ����JfreeChart����
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
            plot = new PiePlot3D((DefaultPieDataset)dataset);// 3D��ͼ
        }else{
            plot = new PiePlot((DefaultPieDataset)dataset);
        }
        plot.setURLGenerator(new StandardPieURLGenerator("index1.jsp","fruit","pieIdex"));// �趨����������
        
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT,
                plot, true);
        chart.setBackgroundPaint(java.awt.Color.white);// ��ѡ������ͼƬ����ɫ
        chart.setTitle(title);// ��ѡ������ͼƬ����
        
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());
        plot.setNoDataMessage("��������ʾ"); 
        
        StandardEntityCollection sec = new StandardEntityCollection();
        ChartRenderingInfo info = new ChartRenderingInfo(sec);

        try {
            filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
                    session);
            ChartUtilities.writeImageMap(pw, useMap, info, false);// ���MAP��Ϣ
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filename;
    }
}
