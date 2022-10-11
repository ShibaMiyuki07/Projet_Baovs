/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Page;

import Base.DbConnexion;
import Model.Bacc;
import Model.Candidat;
import Model.Filiere;
import Model.FiliereCandidat;
import Model.NoteCandidat;
import Model.Promotion;
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
public class InsertionFiliere extends HttpServlet {
    DbConnexion connex = new DbConnexion();
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        Candidat candidat_selectionne = new Candidat();
        candidat_selectionne.setIdCandidat(id);
        try {
            Object[] obj = connex.select(candidat_selectionne, "candidat");
            Object[] liste_filiere = connex.select(new Filiere(), "filiere");
            //out.print(obj.length);
            Candidat envoi = new Candidat();
            Object[] liste_bacc = connex.select(new Bacc(), "bacc");
            envoi = (Candidat) obj[0];
            out.print(envoi.getNom());
            RequestDispatcher dispat = request.getRequestDispatcher("InsertionFiliere.jsp");
            request.setAttribute("candidat", envoi);
            request.setAttribute("liste_filiere", liste_filiere);
            request.setAttribute("liste_bacc", liste_bacc);
            dispat.forward(request, response);
        } catch (Exception ex) {
            
            ex.printStackTrace();
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
    
    //Insertion dans la table filiere_candidat
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FiliereCandidat candidat = new FiliereCandidat();
        PrintWriter out = response.getWriter();
        String[] test = request.getParameterValues("serie[]");
        for(int i=0;i<test.length;i++)
        {
            int id = Integer.parseInt(test[i]);
            int modal = id-1;
            float note_math = Float.parseFloat(request.getParameter("maths"+modal));
            float note_frs = Float.parseFloat(request.getParameter("frs"+modal));
            float note_ang = Float.parseFloat(request.getParameter("ang"+modal));
            
            int idCandidat = Integer.parseInt(request.getParameter("idcandidat"));
            
            NoteCandidat note = new NoteCandidat();
            note.setIdBacc(id);
            note.setNote_maths(note_math);
            note.setNote_francais(note_frs);
            note.setNote_ang(note_ang);
            note.setIdCandidat(idCandidat);
            
            candidat.setIdCandidat(Integer.parseInt(request.getParameter("idcandidat")));
            candidat.setIdFiliere(Integer.parseInt(request.getParameter("filiere")));
            candidat.setIdBacc(id);
            
            Promotion prom = new Promotion();
            prom.setDatedebut(request.getParameter("datedebut"));
            prom.setIdfiliere(candidat.getIdFiliere());
            try {
                Object[] o = connex.select(prom, "promotion");
                Promotion promotion = (Promotion) o[0];
                candidat.setIdPromotion(promotion.getIdpromotion());
                
                connex.insert(candidat, "filiere_candidat", null);
            } catch (Exception ex) {
                response.sendRedirect("localhost:8080/ProjetBaovo/InsertionFiliere?id="+candidat.getIdCandidat());
                request.setAttribute("message", "La promotion choisi n'est pas encore disponible");
            }
            
            try {
                connex.insert(note, "note_candidat", null);
            } catch (Exception ex) {
                response.sendRedirect("localhost:8080/ProjetBaovo/InsertionFiliere?id="+candidat.getIdCandidat());
                request.setAttribute("message", "Veuillez reessayer plus tard");
                ex.printStackTrace();
            }
            
        }
        
    }

}
