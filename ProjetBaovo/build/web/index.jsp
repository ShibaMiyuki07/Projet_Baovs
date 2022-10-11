<%@page import="Model.EcoleOrigine"%>
<%
    Object[] o =(Object[]) request.getAttribute("ecole");
    
%>

<html>
    <head>
        <title>Inscription des nouveaux etudiants</title>
        <style>
      * {
      }
      body {
        font-family: Roboto, Helvetica, sans-serif;
      }
      /* Fixez le bouton sur le côté gauche de la page the button on the left side of the page */
      .open-btn {
        display: flex;
        justify-content: flex-start;
      }
      /* Stylez et fixez le bouton sur la page */
      .open-button {
        background-color: #1c87c9;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        opacity: 0.8;
        position: fixed;
      }
      /* Positionnez la forme Popup */
      .login-popup {
        position: relative;
        text-align: center;
        width: 100%;
      }
      /* Masquez la forme Popup */
      .form-popup {
        display: none;
        position: fixed;
        left: 45%;
        top: 5%;
        transform: translate(-45%, 5%);
        border: 2px solid #666;
        z-index: 9;
      }
      /* Styles pour le conteneur de la forme */
      .form-container {
        max-width: 300px;
        padding: 20px;
        background-color: #fff;
      }
      /* Largeur complète pour les champs de saisie */
      .form-container input[type="text"],
      .form-container input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0 22px 0;
        border: none;
        background: #eee;
      }
      /* Quand les entrées sont concentrées, faites quelque chose */
      .form-container input[type="text"]:focus,
      .form-container input[type="password"]:focus {
        background-color: #ddd;
        outline: none;
      }
      /* Stylez le bouton de connexion */
      .form-container .btn {
        background-color: #8ebf42;
        color: #fff;
        padding: 12px 20px;
        border: none;
        cursor: pointer;
        width: 40%;
        margin-bottom: 10px;
        opacity: 0.8;
      }
      /* Stylez le bouton pour annuler */
      .form-container .cancel {
        background-color: #cc0000;
      }
      /* Planez les effets pour les boutons */
      .form-container .btn:hover,
      .open-button:hover {
        opacity: 1;
      }
        </style>
    </head>
    <body >
        <%
            try
            {
                if(request.getParameter("message")!= null)
                {
                    out.print(request.getAttribute("message"));
                }
            }
            catch(Exception e)
            {
            
        }
        %>
        <form align="center" method="POST" action="InsertionEtudiant" class="form-container">
            <h1>Inscription IT University</h1>
            <label>Nom : </label>
            <div><input type="text" name="nom" placeholder="Nom....."></div>
            <label>Prenom : </label>
            <div><input type="text" name="prenom" placeholder="Prenom...."></div>
            <label>Adresse : </label>
            <div><input type="text" name="adresse" placeholder="Adresse...."></div> 
            <br>
            <label>Date de naissance : </label>
            <div><input class="date" type="date" name="datenaissance"></div>
            <br>
            <div><input class="btn" style="background-color:blue;" type="button" onclick="openForm()" value="Ecole"></div>
            <div class="form-popup" id="popup-Form">
                  <h2>Choisissez votre ecole d'origine</h2>
                  <select name="ecole">
                      <%
                        for(int i=0;i<o.length;i++)
                        {
                            EcoleOrigine ecole = (EcoleOrigine) o[i];
                      %>
                            <option value="<% out.print(ecole.getIdecoleorigine());%>"><% out.print(ecole.getNom_ecoleorigine());%></option>
                        <%}
                      %>
                  </select>
                  <br>
                  <br>
                  <button class="btn " type="button" onclick="closeForm()">Confirmer</button>
                  <button class="btn cancel" type="button" onclick="closeForm()">Annuler</button>
              </div>
            
            <br>
            <div><input class="btn" type="submit" value="S'inscrire"> <input class="btn cancel" type="reset" value="Anuuler"></div>
        </form>     
             <script>
                function openForm() {
                  document.getElementById("popup-Form").style.display = "block";
                }

                function closeForm() {
                  document.getElementById("popup-Form").style.display = "none";
                }
              </script>
    </body>
</html>
