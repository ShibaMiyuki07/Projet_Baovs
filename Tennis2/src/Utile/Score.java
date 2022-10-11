/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utile;

import Base.DbConnexion;
import Fenetrage.Graphique;
import Objet.Points;
import javax.swing.JLabel;

/**
 *
 * @author Manitra
 */
public class Score {
    public void addScore(JLabel[] score,int joueur,int sets,JLabel[][] set,Graphique g) throws Exception
    {
        int num_service = g.getService_joueur();
        DbConnexion connex = new DbConnexion();
        Object[] obj = connex.select(new Points(), "Points");
        int id =0;
        for(int i = 0;i<obj.length;i++)
        {
            Points p = (Points) obj[i];
            if(p.getPoint().equalsIgnoreCase(score[joueur].getText()))
            {
                id = i;
            }
        }
        try
        {
            if(score[joueur].getText().equalsIgnoreCase("A"))
            {
                Points p = (Points) obj[10];
            }
            else
            {
                Points p = (Points) obj[id+1];
                score[joueur].setText(p.getPoint());
                g.setJoueur(g.getService_joueur());
                DbConnexion connect = new DbConnexion();
                
            }
        }
        catch(Exception e)
        {
            int score_set = Integer.parseInt(set[sets][joueur].getText());
            score_set+=1;

            //En cas d'egalite 40-40
            if(score[0].getText().equalsIgnoreCase("40") && score[1].getText().equalsIgnoreCase("40"))
            {
                score[joueur].setText("A");
                g.setJoueur(g.getService_joueur());
            }
            //Si le score contient avantage
            else
            {
                if(score[0].getText().equalsIgnoreCase("A") && score[1].getText().equalsIgnoreCase("40"))
                {
                    if(joueur == 0)
                    {
                        score[0].setText("0");
                        score[1].setText("0");
                        
                        set[sets][joueur].setText(score_set+"");
                        if(num_service == 0)
                        {
                            g.setService_joueur(1);
                            g.setJoueur(1);
                        }
                        if(num_service == 1)
                        {
                            g.setService_joueur(0);
                            g.setJoueur(0);
                        }
                    }
                    if(joueur == 1)
                    {
                        score[0].setText("40");
                        score[1].setText("40");
                        g.setJoueur(g.getService_joueur());
                    }
                }
                
                //Si contient avantage 
                if(score[0].getText().equalsIgnoreCase("40") && score[1].getText().equalsIgnoreCase("A"))
                {
                    if(joueur == 0)
                    {
                        score[0].setText("40");
                        score[1].setText("40");
                        g.setJoueur(g.getService_joueur());
                    }
                    if(joueur == 1)
                    {
                        score[0].setText("0");
                        score[1].setText("0");
                        if(num_service == 0)
                        {
                            g.setService_joueur(1);
                            g.setJoueur(1);
                        }
                        if(num_service == 1)
                        {
                            g.setService_joueur(0);
                            g.setJoueur(0);
                        }
                        set[sets][joueur].setText(score_set+"");
                    }
                }
                //Si ne contient pas d'avantage ou d'egalite
                else
                {
                    
                    //Changement de service
                    if(num_service == 0)
                    {
                        score[0].setText("0");
                        score[1].setText("0");
                        g.setService_joueur(1);
                        g.setJoueur(1);
                        set[sets][joueur].setText(score_set+"");
                    }
                    
                    //Changement de service
                    else
                    {
                        score[0].setText("0");
                        score[1].setText("0");
                        g.setService_joueur(0);
                        g.setJoueur(0);
                        set[sets][joueur].setText(score_set+"");
                    }
                
                    
                }
            
                
                
            }
                
            //}
        }
    }
}
