<%@page import="java.sql.Connection"%>
<%@page import="package_conex.ConexionBBDD"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            h1{
                font-family: verdana;
                font-style: italic;
            }
            #contenido{
                width: 400px;
                height: 400px;
                margin: 0 auto;
                background-color: gray;
            }
        </style>
        <title>Votaciones 2015</title>
    </head>
    <body>
        <div id="contenido">
            <h1>Elecciones</h1>

            <form action="Servlet_login" method="get">
                <input type="text" name="user"/></br>
                <input type="password" name="passwd"/></br>
                </br><input  type="submit" value="Entrar"/></br>
            </form>

            <form action="Servlet_escrutinio" method="get">
                <input type="submit" value="Cerrar escrutinio"/></br>
            </form>
            <form action="Servlet_listado" method="get">
                <input type="submit" value="Listado"/>
            </form>
        </div>
        
        <%!ConexionBBDD ConexionBD;
        Connection conex;%>
        <%!public void jspInit(){
            try{
                ConexionBD=ConexionBBDD.GetConexion();
                conex=ConexionBD.GetCon();
            }catch(ClassNotFoundException cnfe){}
            catch(SQLException sqle){}
        }            
        %>
    </body>
</html>
