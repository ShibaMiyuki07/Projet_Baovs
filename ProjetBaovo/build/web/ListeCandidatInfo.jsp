<%-- 
    Document   : ListeCandidatInfo
    Created on : 9 oct. 2022, 10:04:17
    Author     : Manitra
--%>
<%@page import="Model.View.ChoixFiliereCandidat"%>
<%
    Object[] obj = (Object[]) request.getAttribute("liste");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" href="include/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="include/table.css">
        <link rel="stylesheet" href="include/select.css">
        <link rel="stylesheet" href="include/bouton.css">
        <title>Liste des candidats en filiere informatique</title>
    </head>
    <body>
        <br>
        <h1 style="color: black;">Liste des candidats</h1>
        <table class="container" border="1">
            <thead>
            <tr>
                <th><h1>Nom</h1></th>
                <th><h1>Prenom</h1></th>
                <th><h1>Filiere choisi</h1></th>
                <th><h1>Promotion choisi</h1></th>
            </tr>
        </thead>
        <tbody>
                    <%
                        if(obj.length == 0)
                        {%>
                        <tr>
                            <td colspan="4">Aucun etudiant</td>
                        </tr>
                        <%}
                        else
                        {
                        for(int i=0;i<obj.length;i++)
                            {
                            ChoixFiliereCandidat info = (ChoixFiliereCandidat) obj[i];%>
                            <tr>
                                <td align="center"><% out.print(info.getNom()); %></td>
                                <td><% out.print(info.getPrenom()); %></td>
                                <td><% out.print(info.getNomfiliere()); %></td>
                                <td><% out.print(info.getNom_promotion()); %></td>
                            </tr>
                            <%
                                }
                            
                        }
                    %>
                    
        </tbody>
        </table>
    </body>
</html>
