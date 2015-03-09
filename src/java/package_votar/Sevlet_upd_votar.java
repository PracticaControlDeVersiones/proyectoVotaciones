/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_votar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import package_conex.ConexionBBDD;

@WebServlet(name = "Sevlet_votar", urlPatterns = {"/Sevlet_votar"})
public class Sevlet_upd_votar extends HttpServlet {

    private ConexionBBDD ConexionBD;
    private Connection conex;
    private String votante;
    private String partido;
    
    
    @Override
    public void init() throws ServletException{
        try{
            ConexionBD=ConexionBBDD.GetConexion();
            conex=ConexionBD.GetCon();
            }catch(ClassNotFoundException cnfe){
            }catch(SQLException sqle){
            }
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);     
        votante = (String) session.getAttribute("Votante");     
        partido = request.getParameter("voto");      
        try{
            conex.setAutoCommit(false);       
            censo Censo = new censo();        
            Censo.updateUser(conex, votante);          
            partidos Partidos = new partidos();         
            Partidos.updatePartidos(conex, partido);         
            conex.commit();         
            response.sendRedirect("index.jsp");
            
        } catch (SQLException SQLEex) {
            if(conex != null){
                try {
                    conex.rollback();
                } catch (SQLException SQLEe) {
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
