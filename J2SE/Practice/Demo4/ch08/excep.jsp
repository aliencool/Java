<%@page isErrorPage="true" %>
<%
    out.println("exception.toString():");
    out.println("<br>");
    out.println(exception.toString());
    out.println("<p>");
    
    out.println("exception.getMessage():");
    out.println("<br>");
    out.println(exception.getMessage());
    
%>