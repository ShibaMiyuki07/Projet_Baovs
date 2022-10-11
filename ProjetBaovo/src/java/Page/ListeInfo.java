/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Page;

import Base.DbConnexion;
import Model.Candidat;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manitra
 */
public class ListeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Object[] obj;
        try {
             obj = new DbConnexion().select(new Candidat(), "candidat");
             RequestDispatcher dispat = request.getRequestDispatcher("/ListeInfo.jsp");
            request.setAttribute("liste", obj);
            dispat.forward(request, response);
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }      
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException          
    {
        PrintWriter out = response.getWriter();
        out.print("tsy mety");
    }

}
