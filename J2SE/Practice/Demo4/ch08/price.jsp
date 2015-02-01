<%@ page errorPage="excep.jsp" %>
<%
    String strPrice=request.getParameter("price");
    double price=Double.parseDouble(strPrice);
    
    out.println("Total price = "+price * 3);
%>