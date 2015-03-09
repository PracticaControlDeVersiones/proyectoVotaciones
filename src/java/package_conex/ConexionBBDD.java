/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package_conex;

/**
 *
 * @author daniel
 */
import java.sql.*;

public class ConexionBBDD {
    private static ConexionBBDD UnicaConexion=null; 
    private Connection Conex;
    private ConexionBBDD() throws ClassNotFoundException, SQLException{
                Class.forName("com.mysql.jdbc.Driver");
                String connectionUrl = "jdbc:mysql://localhost:3306/votantes";
               Conex = DriverManager.getConnection(connectionUrl,"root","root");
                
                //Práctica subida a jelastic
                //String connectionUrl =  "jdbc:mysql://mysql15768-proVotaciones.jelastic.lunacloud.com/votantes";
                //Conex = DriverManager.getConnection(connectionUrl, "root", "CWSymyEhDE");
                
    }
    public synchronized static ConexionBBDD GetConexion() throws ClassNotFoundException, SQLException{

       if(UnicaConexion == null){
           UnicaConexion = new ConexionBBDD();
       }
       return UnicaConexion;
    }
    public Connection GetCon(){
           return Conex;
    }
    public void Destroy() throws SQLException{
           Conex.close();
    }
}

