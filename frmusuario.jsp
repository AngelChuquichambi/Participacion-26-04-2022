<%@page import="com.emergentes.modelo.usuario"%>
<%
    usuario listausuario = (usuario) request.getAttribute("listausuario");
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
            <h1>Registrar Usuario</h1>

            <form action="usuariocontroller" method="post">
                <input type="hidden" name="id" value="${listausuario.id}">
                Nombre: <input type="text" name="nombre" value="${listausuario.nombre}" class="form-control"><br>
                Correo: <input type="email" name="correo" value="${listausuario.correo}" class="form-control"><br>
                Clave: <input type="text" name="clave" value="${listausuario.clave}" class="form-control"><br>
                <input type="submit" value="Registrar" class="btn btn-primary">
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
