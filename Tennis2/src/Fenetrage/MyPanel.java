/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fenetrage;

import Base.DbConnexion;
import Objet.Joueur;
import Utile.Randomize;
import javax.swing.*;

/**
 *
 * @author Manitra
 */
public class MyPanel extends JPanel {
    //Liste des boutons utilise
    private JButton lancer = new JButton("Lancer");
    private JButton restart = new JButton("Remettre en position");
    private Graphique graph;
    private int joueur1;
    private int joueur2;
    //Ensemble des textes utilise
    private JLabel[] score = new JLabel[2];
    private JLabel[] joueur = new JLabel[2];
    private JLabel score_text = new JLabel("Score:");
    private JLabel[][] set = new JLabel[2][2];
    
    //Initialisation des joueurs
    private Joueur joue = new Joueur();
    public MyPanel(Graphique g) throws Exception
    {
        //COnfiguration du bouton de relancement
        /*restart.addActionListener(new RestartListener(g));
        restart.setBounds(200, 200, 100, 50);
        this.add(restart);*/
        
        //Configuration emplacement layout
        this.setLayout(null);
        
        //Instanciation du box score
        score[0] = new JLabel("0");
        score[1] = new JLabel("0");
        //Ajout de l'action du bouton
        lancer.addActionListener(g);
        //Ajout du bouton dans le panel
        this.add(lancer);
        
        lancer.setBounds(400,200,100,50);
        
        //Configuration des scores des joueurs
        int x = 800;
        int score_y = 400;
        for(int i=0;i<2;i++)
        {
            score[i].setBounds(300,score_y,100,100);
            score_y+=50;
            this.add(score[i]);
        }
        int set_x = 350;
        
        for(int i=0;i<2;i++)
        {
            int set_y = 400;
            for(int j=0;j<2;j++)
            {
                set[i][j] = new JLabel("0");
                set[i][j].setBounds(set_x,set_y,100,100);
                this.add(set[i][j]);
                set_y+=50;
            }
            set_x+=50;
        }
        
        //Configuration du texte "score"
        score_text.setBounds(300,350,100,100);
        this.add(score_text);
        
        //Configuration du nom des joueurs
        int joueur_y = 400;
        Object[] obj = new DbConnexion().select(new Joueur(), "joueur");
        joueur1 = new Randomize().random(0, obj.length);
        joueur2 = new Randomize().random(0, obj.length);
        
        Joueur j1 = (Joueur) obj[joueur1];
        Joueur j2 = (Joueur) obj[joueur2];
//eto ela le mivavaka va isakafo        
//eto ela le mina tay
        //de eto ela miteny hoe voky be pory
        joueur[0] = new JLabel();
        joueur[1] = new JLabel();
        joueur[0].setText(j1.getNomjoueur());
        joueur[1].setText(j2.getNomjoueur());
        for(int i=0;i<2;i++)
        {
            joueur[i].setBounds(200,joueur_y,100,100);
            joueur_y+=50;
            this.add(joueur[i]);
        }
    }

    public JLabel[] getScore() {
        return score;
    }

    public void setScore(JLabel[] score) {
        this.score = score;
    }

    public JLabel[][] getSet() {
        return set;
    }

    public void setSet(JLabel[][] set) {
        this.set = set;
    }

    public int getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(int joueur1) {
        this.joueur1 = joueur1;
    }

    public int getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(int joueur2) {
        this.joueur2 = joueur2;
    }
    
}
