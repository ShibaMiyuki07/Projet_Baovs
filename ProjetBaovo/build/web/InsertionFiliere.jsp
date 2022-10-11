<%-- 
    Document   : InsertionFiliere
    Created on : 8 oct. 2022, 22:47:48
    Author     : Manitra
--%>
<%@page import="Model.Bacc"%>
<%@page import="Model.Filiere"%>
<%@page import="Model.Candidat"%>
<%
    Candidat can = (Candidat) request.getAttribute("candidat");
    Object[] obj =(Object[]) request.getAttribute("liste_filiere");
    Object[] liste_bacc = (Object[]) request.getAttribute("liste_bacc");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix de filiere de <% out.print(can.getNom());%></title>
        <style>
      .modal {
        display: none;
        position: fixed;
        z-index: 8;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgb(0, 0, 0);
        background-color: rgba(0, 0, 0, 0.4);
      }
      .modal-content {
        margin: 50px auto;
        border: 1px solid #999;
        width: 60%;
      }
      h2,
      p {
        margin: 0 0 20px;
        font-weight: 400;
        color: #999;
      }
      span {
        color: #666;
        display: block;
        padding: 0 0 5px;
      }
      form {
        padding: 25px;
        margin: 25px;
        box-shadow: 0 2px 5px #f5f5f5;
        background: #eee;
      }
      
      textarea {
        width: 90%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #1c87c9;
        outline: none;
      }
      .contact-form button {
        width: 100%;
        padding: 10px;
        border: none;
        background: #1c87c9;
        font-size: 16px;
        font-weight: 400;
        color: #fff;
      }
      button:hover {
        background: #2371a0;
      }
      .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
      }
      .close:hover,
      .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
      }
      button.button {
        background: none;
        border-top: none;
        outline: none;
        border-right: none;
        border-left: none;
        border-bottom: #02274a 1px solid;
        padding: 0 0 3px 0;
        font-size: 16px;
        cursor: pointer;
      }
      button.button:hover {
        border-bottom: #a99567 1px solid;
        color: #a99567;
      }
    </style>
    </head>
    <body>
        
        <form action="InsertionFiliere" method="POST">
            <h1>La filiere choisi par <% out.print(can.getNom()); %></h1>
            <label>Filiere : </label>
            <select name="filiere">
                <%
                    for(int i=0;i<obj.length;i++)
                    {
                        Filiere filiere =(Filiere) obj[i];
                %>
                <option  value="<% out.print(filiere.getIdFiliere());%>"><% out.print(filiere.getNomFiliere());%></option>
                    
                    
                <%}
                %>
            </select>
            <%
            for(int i=0;i<liste_bacc.length;i++)
            {
                Bacc bacc = (Bacc) liste_bacc[i];
            %>
                <div id="modal<%out.print(i);%>" class="modal">
                    <div class="modal-content">
                      <div class="contact-form">
                        <a class="close">&times;</a>
                          <h2 style="color:black;">Note serie <%out.print(bacc.getSerie());%> : </h2>
                          <div>
                            <input type="text" name="maths<%out.print(i);%>" placeholder="Note de maths...." />
                            <input type="text" name="frs<%out.print(i);%>" placeholder="Note francais..." />
                            <input type="text" name="ang<%out.print(i);%>" placeholder="Note anglais..." />
                          </div>
                          <input type="button" value="confirmer" class="close">
                      </div>
                    </div>
                  </div>
            <%
            }
            %>
            <!-- Insertion des notes du bacc  -->
            
            <div>
                <label>Serie : </label>
                    <%
                        for(int i=0;i<liste_bacc.length;i++)
                        {
                            Bacc filiere =(Bacc) liste_bacc[i];
                    %>
                    <input type="checkbox" class="button" data-modal="modal<%out.print(i);%>" name="serie[]" value="<% out.print(filiere.getIdBacc());%>"><% out.print(filiere.getSerie());%>
                     
                    <%}
                    %>
            </div>
            <div>Choississez votre promotion : <input type="number" min="2023" value="2023"  name="datedebut"></div>
            <div><input type="hidden" name="idcandidat" value="<% out.print(can.getIdCandidat());%>"></div>
            <div><input class="btn" type="submit" value="Valider"></div>
        </form>
    </body>
    <script>
        let modalBtns = [...document.querySelectorAll(".button")];
      modalBtns.forEach(function (btn) {
        btn.onclick = function () {
          let modal = btn.getAttribute("data-modal");
          document.getElementById(modal).style.display = "block";
        };
      });
      let closeBtns = [...document.querySelectorAll(".close")];
      closeBtns.forEach(function (btn) {
        btn.onclick = function () {
          let modal = btn.closest(".modal");
          modal.style.display = "none";
        };
      });
      window.onclick = function (event) {
        if (event.target.className === "modal") {
          event.target.style.display = "none";
        }
      };
    </script>
</html>
