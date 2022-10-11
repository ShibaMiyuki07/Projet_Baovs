package Page.Test;


import Base.DbConnexion;
import Model.Region;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Manitra
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException, IOException, Exception {
        // TODO code application logic here
        /*DbConnexion connex = new DbConnexion();
        Inscription_Info info = new Inscription_Info();
           info.setNom("nom");
           info.setPrenom("prenom");
           info.setAdresse("adresse");
           
           //design.setDate(request.getParameter("datenaissance").to);
           info.setIdecoleorigine(Integer.parseInt("1"));
            try {
                Object[] obj = connex.select(new Inscription_Info(), "inscription_info");
                for(int i=0;i<obj.length;i++)
                {
                    System.out.println(obj[i]);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }*/
        DbConnexion connex = new DbConnexion();
        BufferedReader br = new BufferedReader(new FileReader("C:\\LeconS5\\Projet\\ProjetBaovo\\Region.csv"));
        String ligne = null;
        /*while((ligne = br.readLine()) != null)
        {
            String[] data = ligne.split(",");
            for(String val : data)
            {
                if(!val.equalsIgnoreCase("region"))
                {
                    Region reg = new Region();
                    reg.setNom_region(val);
                    connex.insert(reg,"region", "idregion");
                    System.out.println(val);
                }
            }
        }*/
        
        Object[] obj = connex.select(new Region(), "region");
        for(int i=0;i<obj.length;i++)
        {
            Region reg = (Region) obj[i];
            System.out.println(reg.getNom_region());
        }
    }
}
