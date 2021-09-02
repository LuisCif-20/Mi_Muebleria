<%-- 
    Document   : pagina-principal
    Created on : 2/09/2021, 11:25:33
    Author     : nroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRABAJO</title>
        <link href="EstiloPP.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% if (request.getAttribute("Cargo").equals(1)) {%>
        <h1 id="AF">Area de Fabrica</h1>   
        <%} else if (request.getAttribute("Cargo").equals(2)) {%>
        <h1 id="AV">Area de Ventas</h1>   
        <%} else if (request.getAttribute("Cargo").equals(3)) {%>
        <h1 id="AA">Area de Administración</h1>   
        <%} else {%>
        <h1 id="NN">Has ingresado mal tus datos, no se ha encontrado el usuario</h1>
        <%}%>

    </body>
</html>
