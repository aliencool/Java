<%@ page contentType="text/html;charset=GBK"%>  
    <%@ page import="com.bean.MapPieChart"%>  
    <%@ page import="java.io.PrintWriter"%>  
    <HTML>  
        <HEAD>  
           <META http-equiv=Content-Type content="text/html; charset=GBK">  
        </HEAD>  
       <BODY>  
          <%  
             String filename = MapPieChart.createPieChart(MapPieChart  
                      .getDataset(), "水果产量图",480, 350, session, new PrintWriter(out),  
                       "imgMap", true);  
             String file = request.getContextPath()  
                     + "/servlet/DisplayChart?filename=" + filename;  
   
              String filename1 = MapPieChart.createPieChart(MapPieChart  
                       .getDataset(), "水果产量图",480, 350, session, new PrintWriter(out),  
                       "imgMap1", true);  
              String file1 = request.getContextPath()  
                    + "/servlet/DisplayChart?filename=" + filename1;  
       %>  
   
           <P ALIGN="CENTER">  
               <img src="<%=file%>" border=0 usemap="#imgMap">  
        </P>  
          <P ALIGN="CENTER">  
             <img src="<%=file1%>" border=0 usemap="#imgMap1">  
         </P>  
   
      </BODY>  
  </HTML>