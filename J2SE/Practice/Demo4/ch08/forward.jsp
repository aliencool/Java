<%
    String command=request.getParameter("command");
    if(command.equals("reg"))
    {
%>
        <jsp:forward page="reg.jsp"/>
<%
    }
    else if(command.equals("logout"))
    {
%>
        <jsp:forward page="logout.jsp"/>
<%
    }
    else
    {
%>
        <jsp:forward page="login.jsp"/>
<%
    }
%>