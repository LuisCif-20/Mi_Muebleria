<%-- 
    Document   : editar-pieza
    Created on : 6/09/2021, 10:45:53
    Author     : nroda
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="editar_tabla.Pieza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <%Pieza pieza = new Pieza();
        ResultSet resultado = pieza.read();
    %>
    <body>
        <h1 class="bg-success text-white text-center">Area de Fabrica</h1>
        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                ¿Que deseas hacer?
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Pieza/crear-pieza.jsp">Agregar pieza</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Pieza/eliminar-pieza.jsp">Eliminar pieza</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Pieza/editar-pieza.jsp">Actualizar Piezas</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Pieza/leer-pieza.jsp">Desplegar piezas</a></li>
            </ul>
        </div>
        <br>
        <br>
        <br>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Tipo</th>
                    <th scope="col">Costo</th>
                    <th scope="col">Existencia</th>
                    <th scope="col">¿Editar?</th>
                </tr>
            </thead>
            <tbody>
                <%while (resultado.next()) {%>
                <tr>
                    <td><%out.print(resultado.getString(1));%></td>
                    <td><%out.print(resultado.getDouble(2));%></td>
                    <td><%out.print(resultado.getInt(3));%></td>
                    <td>
                        <form action="actualizar.jsp">
                            <button type="submit" class="btn btn-success">Editar</button>
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <script src="../js/jquery-3.6.0.min.js"></script>
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
