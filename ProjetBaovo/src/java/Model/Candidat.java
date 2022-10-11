/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Model;

/**
 *
 * @author Manitra
 */
public class Candidat {
    private int idCandidat;
    private String nom;
    private String prenom;
    private String adresse;
    private String datenaissance;
    private int idEcoleOrigine;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public int getIdEcoleOrigine() {
        return idEcoleOrigine;
    }

    public void setIdEcoleOrigine(int idEcoleOrigine) {
        this.idEcoleOrigine = idEcoleOrigine;
    }
    
    
}
