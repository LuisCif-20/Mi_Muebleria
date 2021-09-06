<%-- 
    Document   : actualizar
    Created on : 6/09/2021, 10:59:02
    Author     : nroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%
        out.print(request.getParameter("tipo"));
        out.print(request.getParameter("costo"));
        out.print(request.getParameter("existencias"));
        %>
    </body>
</html>
