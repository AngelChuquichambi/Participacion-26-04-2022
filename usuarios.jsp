<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.usuario"%>
<%@page import="java.util.List"%>
<%
    List<usuario> lista = (List<usuario>) request.getAttribute("lista");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>
        <div class="container"> 
        <h1>USUARIOS</h1>
        <p><a href="usuariocontroller?op=nuevo"><input type="submit" value="Nuevo" class="btn btn-primary"></a></p>
        <table class="table table-striped">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Correo</td>
                <td>Clave</td>
                <td>Opción</td>
                <td>Opción</td>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.correo}</td>
                    <td>${item.clave}</td>
                    <td><a href="usuariocontroller?op=eliminar&id=${item.id}"><input type="submit" value="Eliminar" class="btn btn-primary"></a></td>
                    <td><a href="usuariocontroller?op=editar&id=${item.id}"><input type="submit" value="Editar" class="btn btn-primary"></a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
