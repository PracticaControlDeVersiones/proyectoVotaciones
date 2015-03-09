/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_votar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class partidos {
    private int idPartido;
    private String partido;
    private int numVotos;
    private String icono;
    
    
    public partidos() {
    }

    public partidos(int idPartido, String partido, String icono) {
        this.idPartido = idPartido;
        this.partido = partido;
        this.icono = icono;
    }

    public partidos(int idPartido, String partido, int numVotos, String icono) {
        this.idPartido = idPartido;
        this.partido = partido;
        this.numVotos = numVotos;
        this.icono = icono;
    }
    
    public ArrayList getResultPartidos(Connection conexion){
        ArrayList listPartidos = new ArrayList();
        try{
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM partidos;");
        while(rs.next()){
            listPartidos.add(new partidos(rs.getInt("ID_PARTIDO"),rs.getString("PARTIDO"),rs.getInt("NUM_VOTOS"),rs.getString("ICONO")));
        }
        }catch(SQLException SQLE){
            SQLE.getMessage();
        }
        return listPartidos;
    }
    
    public void updatePartidos (Connection conexion,String id) throws SQLException {
        try{
            Statement s = conexion.createStatement();
            int rs = s.executeUpdate("UPDATE `votantes`.`partidos` SET `NUM_VOTOS`= (NUM_VOTOS+1) WHERE `ID_PARTIDO`='"+id+"';");
            if(rs == 0){
                throw new SQLException();
            }
        }catch(SQLException SQLE){
            SQLE.getMessage();
            //throw new SQLException();
        }
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }
    
    
}
