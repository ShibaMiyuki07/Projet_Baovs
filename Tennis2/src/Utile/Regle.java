/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utile;

import Base.DbConnexion;
import Objet.Coordonne_terrain;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author Manitra
 */
public class Regle {
    private Coordonne_terrain fullcourt;
    private Coordonne_terrain doublegauche;
    private Coordonne_terrain doubledroite;
    private Coordonne_terrain zoneservicehaut;
    private Coordonne_terrain zoneservicebas;
    private Coordonne_terrain zoneservicehautgauche;
    private Coordonne_terrain zoneservicehautdroite;
    private Coordonne_terrain zoneservicebasgauche;
    private Coordonne_terrain zoneservicebasdroite;
    private Coordonne_terrain filet;
    
    public Regle() throws Exception
    {
        DbConnexion connex = new DbConnexion();
        Object[] obj = connex.select(new Coordonne_terrain(),"Coordonne_terrain");
        Method[] f = this.getClass().getDeclaredMethods();
        for(int i = 0;i<obj.length;i++)
        {
            Coordonne_terrain terre = (Coordonne_terrain) obj[i];
            for(int j=0;j<f.length;j++)
            {
                if(f[j].getName().equalsIgnoreCase("set"+terre.getNom_terrain()))
                {
                    f[j].invoke(this, terre);
                }
            }
            
        }
    }
    public boolean checkServiceHaut(Coordonne balle,int joueur) throws Exception
    {
        
        //Check la position de la balle 

        if(balle.getX()>zoneservicebasdroite.getCoordonneX())
        {
            if(balle.getY()>zoneservicebas.getCoordonneY())
            {
                if(balle.getX()<doubledroite.getCoordonneX())
                {
                    if(balle.getY()<zoneservicebas.getHeight()+zoneservicebas.getCoordonneY())
                    {
                        System.out.println("service mety");
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        System.out.println("tsy mety mihitsy");
        return false;
    }
    
    public boolean checkServiceBas(Coordonne balle,int joueur)
    {
        if(balle.getX()>zoneservicehautgauche.getCoordonneX())
        {
            if(balle.getX()<zoneservicehautdroite.getCoordonneX())
            {
                if(balle.getY()>zoneservicehaut.getCoordonneY())
                {
                    if(balle.getY()<zoneservicehaut.getHeight()+zoneservicehaut.getCoordonneY())
                    {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    
    public boolean checkOut(Coordonne balle,int joueur)
    {
        if(balle.getX()< doublegauche.getCoordonneX()+doublegauche.getWidth())
        {
            System.out.println("out gauche");
            return false;
        }
        if(balle.getX() > doubledroite.getCoordonneX())
        {
            System.out.println("out droite");
            return false;
        }
        if(balle.getX()< fullcourt.getCoordonneX())
        {
            System.out.println("out terrain gauche");
            return false;
        }
        if(balle.getX()>fullcourt.getHeight()+fullcourt.getCoordonneX())
        {
            System.out.println("out terrain droite");
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean checkFilet(Coordonne balle,int joueur)
    {
        if(balle.getY() == filet.getCoordonneY())
        {
            return false;
        }
        return true;
    }
    public Coordonne_terrain getFullcourt() {
        return fullcourt;
    }

    public void setFullcourt(Coordonne_terrain fullcourt) {
        this.fullcourt = fullcourt;
    }


    public Coordonne_terrain getDoublegauche() {
        return doublegauche;
    }

    public void setDoublegauche(Coordonne_terrain doublegauche) {
        this.doublegauche = doublegauche;
    }

    public Coordonne_terrain getDoubledroite() {
        return doubledroite;
    }

    public void setDoubledroite(Coordonne_terrain doubledroite) {
        this.doubledroite = doubledroite;
    }

    public Coordonne_terrain getZoneservicehaut() {
        return zoneservicehaut;
    }

    public void setZoneservicehaut(Coordonne_terrain zoneservicehaut) {
        this.zoneservicehaut = zoneservicehaut;
    }

    public Coordonne_terrain getZoneservicebas() {
        return zoneservicebas;
    }

    public void setZoneservicebas(Coordonne_terrain zoneservicebas) {
        this.zoneservicebas = zoneservicebas;
    }

    public Coordonne_terrain getZoneservicehautgauche() {
        return zoneservicehautgauche;
    }

    public void setZoneservicehautgauche(Coordonne_terrain zoneservicehautgauche) {
        this.zoneservicehautgauche = zoneservicehautgauche;
    }

    public Coordonne_terrain getZoneservicehautdroite() {
        return zoneservicehautdroite;
    }

    public void setZoneservicehautdroite(Coordonne_terrain zoneservicehautdroite) {
        this.zoneservicehautdroite = zoneservicehautdroite;
    }

    public Coordonne_terrain getZoneservicebasgauche() {
        return zoneservicebasgauche;
    }

    public void setZoneservicebasgauche(Coordonne_terrain zoneservicebasgauche) {
        this.zoneservicebasgauche = zoneservicebasgauche;
    }

    public Coordonne_terrain getZoneservicebasdroite() {
        return zoneservicebasdroite;
    }

    public void setZoneservicebasdroite(Coordonne_terrain zoneservicebasdroite) {
        this.zoneservicebasdroite = zoneservicebasdroite;
    }

    public Coordonne_terrain getFilet() {
        return filet;
    }

    public void setFilet(Coordonne_terrain filet) {
        this.filet = filet;
    }
    
}
