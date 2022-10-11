/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objet;

import Base.DbConnexion;

/**
 *
 * @author Manitra
 */
public class Joueur {
    private int idJoueur;
    private String nomjoueur;
    

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomjoueur() {
        return nomjoueur;
    }

    public void setNomjoueur(String nomjoueur) {
        this.nomjoueur = nomjoueur;
    }
    public Joueur getJoueur(String nom) throws Exception
    {
        Joueur joue  = new Joueur();
        joue.setNomjoueur(nom);
        DbConnexion connect = new DbConnexion();
        Object[] obj = connect.select(joue,"joueur");
        
        Joueur retour = (Joueur) obj[0];
        return retour;
    }

    
}
