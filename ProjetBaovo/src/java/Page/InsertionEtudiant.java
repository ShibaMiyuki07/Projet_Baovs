/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Page;

import Base.DbConnexion;
import Model.Candidat;
import Model.EcoleOrigine;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manitra
 */
public class InsertionEtudiant extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DbConnexion connex = new DbConnexion();
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Object[] obj = connex.select(new EcoleOrigine(), "ecoleorigine");
            RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("ecole", obj);
            dispat.forward(request, response);
        } catch (Exception ex) {
            out.print(ex.getMessage());
        }      
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
        PrintWriter out = response.getWriter();
        try {
               Candidat design = new Candidat();
               design.setNom(request.getParameter("nom"));
               design.setPrenom(request.getParameter("prenom"));
               design.setAdresse(request.getParameter("adresse"));
               design.setDatenaissance(request.getParameter("datenaissance"));
               //design.setDate(request.getParameter("datenaissance").to);
               design.setIdEcoleOrigine(Integer.parseInt(request.getParameter("ecole")));
                try {
                    connex.insert(design, "candidat", "idcandidat");
                    response.sendRedirect("localhost:8080/ProjetBaovo/ListeInfo");
                    out.print("mety");
                } catch (Exception ex) {
                    out.print(ex.getMessage());
                }

        } catch (Exception ex) {
            try {
                Object[] obj = connex.select(new EcoleOrigine(), "ecoleorigine");
                RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
                request.setAttribute("ecole", obj);
                request.setAttribute("message", ex.getMessage());
            } catch (Exception ex1) {
                Logger.getLogger(InsertionEtudiant.class.getName()).log(Level.SEVERE, null, ex1);
            }
           
        }
        
    }

}
