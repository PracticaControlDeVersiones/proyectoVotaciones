<%@page import="package_votar.partidos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votaciones 2015</title>
        <script type="text/javascript">
            function inicio () {
                location.href = 'index.jsp';
            }
        </script>
        <style type="text/css">
            table,tr,td{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Votaciones</h1>
        <%
            ArrayList Listado = (ArrayList) session.getAttribute("ListadoPartidos");
        %>
        <table>
            <tr>
                <td></td>
                <td>Partido</td>
                <td>Número Total Votos</td>
            </tr>
            <%
                for(int i=0;i<Listado.size();i++){
            %>
            <tr>
                <td>
                 <image src="<%=((partidos)Listado.get(i)).getIcono() %>">
                </td>
                <td><%=((partidos)Listado.get(i)).getPartido() %></td>
                <td><%=((partidos)Listado.get(i)).getNumVotos() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <button onclick="inicio()">Volver al inicio</button>
    </body>
</html>
