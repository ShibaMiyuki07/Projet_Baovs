/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fenetrage;

import Utile.Coordonne;
import Utile.Randomize;
import Utile.Regle;
import Utile.Score;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Manitra
 */
public class Graphique extends JPanel implements ActionListener,Runnable{
    private MyPanel panel;
    private int i =2;
    private int faute = 0;
    private int joueur = 0;
    
    //Utilise pour changement de service
    private int service_joueur = 0;
    
    //Compte le nombre de retour lors du match
    private int retour_balle = 1;
    private Coordonne t = new Coordonne();
    private Coordonne premier_touche = new Coordonne();
    
    //Coordonne de chaque joueur
    private Coordonne joueur1 = new Coordonne(200,80);
    private Coordonne joueur2 = new Coordonne(680,1000);
    
    //Coordonne du 2e rebondissement de la balle
    private Coordonne fin;
    private Graphique graph;
    private MyFrame frame;
    //private int i=0;
    private double calcul ;
    private double distance;
    double distance_moitie;
    private double distance_reel;
    
    //initialisation du thread utilise
    private Thread th;
    public Graphique()
    {
        th = new Thread(this);
        t.setX(200);
        t.setY(100);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        paintTerrain(g);
    }
    public void paintTerrain(Graphics g)
    {
        g.setColor(Color.blue);
        
        //Creation du terrain
        g.fillRect(100, 100, 700, 900);
        
        g.setColor(Color.white);    
        
        //Creation des deux zones doubles
            //Double gauche
            g.drawRect(100, 100, 100, 900);

            //Double droite
            g.drawRect(700, 100, 100, 900);
            
        //Zone de service
            //Zone de service haut
            g.drawRect(200,325, 500, 225);
            
            //Zone de service bas
            g.drawRect(200,550, 500, 225);
            
        //Zone de service haut
            //Gauche
                g.drawRect(200, 325, 250, 225);
            
            //Droite
            g.drawRect(450, 325, 250, 225);
            
        //Zone de service bas
            //Gauche
            g.drawRect(200, 550, 250, 225);
            
            //Droite
            g.drawRect(450, 550, 250, 225);
        
        //Dessin de la ligne de filet
        g.drawLine(100, 550, 800, 550);
        
            paintBall(g);
            
        //Creation des joueur
        g.setColor(Color.black);
            //Joueur 1
            g.fillRect(joueur1.getX(),joueur1.getY() , 20, 20);
            
            //joueur 2 
            g.fillRect(joueur2.getX(),joueur2.getY() , 20, 20);
    }
    
    //Fonction utilise pour le deplacement de la balle
    public void paintBall(Graphics g)
    {
        //Creation de la balle 
            //Couleur
            g.setColor(Color.green);
            //Coordonne de la balle
            try
            {
                g.fillOval(fin.getX(), fin.getY(), 10, 10);
            }
            catch(Exception e)
            {
                g.fillOval(t.getX(), t.getY(), 10, 10);
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int speed = 1;
        
        //Commencer l'utilisation du thread
        th.start();
        
    }

    public void setGraph(Graphique graph) {
        this.graph = graph;
    }

    
    //Fonction utilise par le thread
    @Override
    public synchronized void run() {
        fin = new Coordonne();
        
        while(i>0)
        {
            if(i == 2)
            {
                //Envoie la premiere balle
                if(service_joueur == 0)
                {
                    fin.setX(new Randomize().random(450, 650));
                    fin.setY(new Randomize().random(550, 850));
                }
                else
                {
                    fin.setX(new Randomize().random(100, 450));
                    fin.setY(new Randomize().random(250, 550));
                }
                repaint();
                Regle regle;
                try {
                    regle = new Regle();
                    System.out.println(regle.checkServiceHaut(fin, joueur));
                    
                    //Check si le service est valide , check si la balle touche le filet
                        //Check quel joueur sert
                        if(service_joueur == 0)
                        {
                            if(regle.checkServiceHaut(fin, joueur) == false || regle.checkFilet(fin, joueur) == false)
                            {
                                faute +=1;  
                                wait(2000);

                                //Si le serveur a fait plus de 2 faute
                                if(faute == 2)
                                {
                                    i = 0;
                                    joueur = 1;
                                    repaint();
                                    wait(2000);

                                    this.run();
                                }
                                //Sinon
                                else
                                {
                                    i = 0;
                                    repaint();
                                    this.run();
                                }
                            }
                        }
                        else
                        {
                            if(regle.checkServiceBas(fin, joueur) == false || regle.checkFilet(fin, joueur) == false)
                            {
                                faute +=1;  
                                wait(2000);

                                //Si le serveur a fait plus de 2 faute
                                if(faute == 2)
                                {
                                    i = 0;
                                    joueur = 0;
                                    repaint();
                                    wait(2000);

                                    this.run();
                                }
                                //Sinon
                                else
                                {
                                    i = 0;
                                    repaint();
                                    this.run();
                                }
                            }
                        }
                }
                //Dans le cas d'une Exception ou autre 
                catch (Exception ex) {
                    ex.printStackTrace();
                }  
            }
            
            //Debut du jeu
            
            if(i == 1)
            {
                try {
                    //Calcul la trajectoire de la balle
                    calculTrajectoire();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
            repaint();
                i--;
            
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            
        }
        
        //Ajout des scores des joueurs
        if(faute != 1)
        {
            Score sc = new Score();
            
            try {
                //Ajout des scores dans le premier panel
                sc.addScore(panel.getScore(),joueur,0,panel.getSet(),this);
                System.out.println("Service actuelle : "+service_joueur);
                
                //Remet les fautes a 0
                faute = 0;
            } catch (Exception ex) {
                ex.printStackTrace();
                }
        }
        repaint();
        
        //Changer le service
        if(service_joueur == 0)
        {
            t.setX(200);
            t.setY(100); 
        }
        if(service_joueur == 1)
        {
            t.setX(690);
            t.setY(990);
        }
        fin =null;
        
        //Remet les coordonne de base des joueurs
        joueur1 = new Coordonne(200,80);
        joueur2 = new Coordonne(680,1000);
        i =2;
        repaint();
        if(!panel.getSet()[0][0].getText().equalsIgnoreCase("2") && !panel.getSet()[0][1].getText().equalsIgnoreCase("2"))
        {
            try
            {
                    wait(3000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            this.run();
        }
        th.stop();
    }
    
    //Calcul des trajectoires de la balle
    public synchronized void calculTrajectoire() throws  Exception
    {
                
        faute = 0;
        int rando = new Randomize().random(-30, 30);
        repaint();
        if(joueur == 0)
        {
            int x_moitie = fin.getX()/3;
            int y_moitie = fin.getY()/3;
            
            int x = fin.getX()+(x_moitie);//*joueur_1);
            int y = fin.getY()+y_moitie;
            //Changement de coordonne de la balle
            fin.setX(x);
            fin.setY(y);
            
            /*depart.setX(x);
            depart.setY(y);*/
            //Changement de coordonne du joueur 2
            joueur2.setX(fin.getX()+rando);
            joueur2.setY(fin.getY()+10);
            
            System.out.println(rando);
            System.out.println(joueur);
            repaint();
            
        }
        
        //Si le joueur qui repond est 
        if(joueur == 1)
        {
            int x_moitie = fin.getX()/3;
            int y_moitie = fin.getY()/3;
            
            //Changement de coordonne de la balle
            int x = fin.getX()-(x_moitie);//*joueur_2);
            int y = fin.getY()-y_moitie;
            fin.setX(x);
            fin.setY(y);
            /*depart.setX(x);
            depart.setY(y);*/
            //Changement de coordonne du joueur1
            joueur1.setX(fin.getX()+rando);
            joueur1.setY(fin.getY()-10);
           
            System.out.println(rando);
            System.out.println(joueur);
            repaint();
            
            
        }
        if(rando>=-20)
        {
            if(rando<=20)
            {
                retour();
            }
        }
        
    }
    
    //Fonction utilise pour retourner la balle
    public synchronized void retour() throws Exception
    {
        Regle regle = new Regle();
        wait(2000);
        faute = 0;
        if(joueur == 0)
        {
            i = 1;
            fin.setX(new Randomize().random(100, 800));
            fin.setY(new Randomize().random(100, 550));
            
            //Check si la balle est dans le terrain ou si la balle touche le filet
            if(regle.checkOut(fin, joueur) == false || regle.checkFilet(fin, joueur) == false)
            {
                i =0;
                
                repaint();
                wait(3000);
                //sc.addScore(panel.getScore(),joueur,0,panel.getSet());
                this.run();
                
            }
            
           else
            {
                 repaint();
                
                wait(900);
                joueur = 1;
                calculTrajectoire();
            }
            //System.out.println(fin.getY());
        }
        if(joueur == 1)
        {
            i= 1;
            
            //retour de la balle
            fin.setX(new Randomize().random(100, 800));
            fin.setY(new Randomize().random(550, 900));
            
            //Check si la balle est dans le terrain ou si la balle touche le filet
            if(regle.checkOut(fin, joueur) == false || regle.checkFilet(fin, joueur) == false)
            {
                i=0;
                repaint();
                wait(3000);
                //sc.addScore(panel.getScore(),joueur,0,panel.getSet());
                this.run();
                
            }
            else
            {
                repaint();
                
                repaint();
                wait(900);
                joueur = 0;

                calculTrajectoire();
            }
        }
        
    }

    public MyPanel getPanel() {
        return panel;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    public MyFrame getFrame() {
        return frame;
    }

    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }

    public int getService_joueur() {
        return service_joueur;
    }

    public void setService_joueur(int service_joueur) {
        this.service_joueur = service_joueur;
    }

    public int getJoueur() {
        return joueur;
    }

    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }
    
}
