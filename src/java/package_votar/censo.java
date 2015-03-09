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

public class censo {
    private String nif;
    private String passwd;
    private String nombre;
    private String apellidos;
    private String votoEmitido;
    
    public censo(){
    }

    public censo(String nif, String votoEmitido) {
        this.nif = nif;
        this.votoEmitido = votoEmitido;
    }
    
    public censo(String nif, String nombre, String apellidos, String votoEmitido) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.votoEmitido = votoEmitido;
    }
    
    public censo(String nif, String passwd, String nombre, String apellidos, String votoEmitido) {
        this.nif = nif;
        this.passwd = passwd;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.votoEmitido = votoEmitido;
    }
    
    public ArrayList getCenso(Connection conexion){
        ArrayList listado = new ArrayList();
        try{
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT NIF,NOMBRE,APELLIDOS,VOTO_EMITIDO FROM censo;");
        while(rs.next()){
            listado.add(new censo(rs.getString("NIF"),rs.getString("NOMBRE"),rs.getString("APELLIDOS"),rs.getString("VOTO_EMITIDO")));
        }
        }catch(SQLException SQLE){
            SQLE.getMessage();
        }
        return listado;
    }
    
    public boolean comprobarUser (Connection conexion,String votante,String passwd){
        try{
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT NIF FROM censo WHERE NIF='"+votante+"' AND PASSWD='"+passwd+"' AND VOTO_EMITIDO='NO';");
            if(rs.next()){
                return true;
            }
        }catch(SQLException SQLE){
            SQLE.getMessage();
        }
        return false;
    }

    public void updateUser (Connection conexion,String votante) throws SQLException {
        try{
            Statement s = conexion.createStatement();
            int rs = s.executeUpdate("UPDATE `votantes`.`censo` SET `VOTO_EMITIDO`='si' WHERE `NIF`='"+votante+"';");
            if(rs == 0){
                throw new SQLException();
            }
        }catch(SQLException SQLE){
            SQLE.getMessage();
            throw new SQLException();
        }
    }
    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the votoEmitido
     */
    public String getVotoEmitido() {
        return votoEmitido;
    }

    /**
     * @param votoEmitido the votoEmitido to set
     */
    public void setVotoEmitido(String votoEmitido) {
        this.votoEmitido = votoEmitido;
    }
    
}