<%-- 
    Document   : fabrica
    Created on : 5/09/2021, 23:42:54
    Author     : nroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
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
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </body>
</html>
