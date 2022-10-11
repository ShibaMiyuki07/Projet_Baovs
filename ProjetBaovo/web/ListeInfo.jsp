<%-- 
    Document   : ListeEtudiant
    Created on : 6 oct. 2022, 07:46:55
    Author     : Manitra
--%>

<%@page import="Model.Candidat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object[] obj = (Object[]) request.getAttribute("liste");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" href="include/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="include/table.css">
        <link rel="stylesheet" href="include/select.css">
        <link rel="stylesheet" href="include/bouton.css">
        <title>Liste des candidats</title>
    </head>
    <body>
        <br>
        <h1 style="color: black;">Liste des candidats</h1>
        <table class="container" border="1">
            <thead>
            <tr>
                <th><h1>Nom</h1></th>
                <th><h1>Prenom</h1></th>
                <th><h1>Adresse</h1></th>
                <th><h1>Date de naissance</h1></th>
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
                            Candidat info = (Candidat) obj[i];%>
                            <tr onclick="insertionFiliere(<% out.print(info.getIdCandidat());%>)">
                                <td align="center"><% out.print(info.getNom()); %></td>
                                <td><% out.print(info.getPrenom()); %></td>
                                <td><% out.print(info.getAdresse()); %></td>
                                <td><% out.print(info.getDatenaissance()); %></td>
                            </tr>
                            <%
                                }
                            
                        }
                    %>
                    
        </tbody>
        </table>
                    <br>
                    <div align="center"><a href="ListeCandidatInfo"><button>Liste des candidats en info </button></a> <a href="ListeCandidatDesign"><button>Liste des candidats en design</button></a></div>
    </body>
    <script>
        function insertionFiliere(id)
        {
            location.href="InsertionFiliere?id="+id;
        }
    </script>
</html>
