/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Model;

/**
 *
 * @author Manitra
 */
public class Promotion {

    private int idpromotion;
    private String nom_promotion;
    private String datedebut;
    private String datefin;
    private int idfiliere;

    public int getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(int idpromotion) {
        this.idpromotion = idpromotion;
    }

    public String getNom_promotion() {
        return nom_promotion;
    }

    public void setNom_promotion(String nom_promotion) {
        this.nom_promotion = nom_promotion;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public int getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(int idfiliere) {
        this.idfiliere = idfiliere;
    }
    
}
