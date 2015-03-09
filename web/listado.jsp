<%@page import="package_votar.censo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de censo 2015</title>
        <script type="text/javascript">
            function inicio () {
                location.href = 'index.jsp';
            }
        </script>
        <style type="text/css">
            table,tr,td{
                border: 2px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Listado de censo 2015</h1>
        <%
            ArrayList Listado = (ArrayList) session.getAttribute("Listado");
        %>
        <table>
            <tr>
                <td>NIF</td>
                <td>Nombre</td>
                <td>Apellidos</td>
                <td>Su Voto</td>
            </tr>
            <%
                for(int i=0;i<Listado.size();i++){
            %>
            <tr>
                <td><%=((censo)Listado.get(i)).getNif()%></td>
                <td><%=((censo)Listado.get(i)).getNombre()%></td>
                <td><%=((censo)Listado.get(i)).getApellidos()%></td>
                <td><%=((censo)Listado.get(i)).getVotoEmitido()%></td>
            </tr>
            <%
                }
            %>
        </table>
        </br>
        <button onclick="inicio()">Volver al inicio</button>
    </body>
</html>
