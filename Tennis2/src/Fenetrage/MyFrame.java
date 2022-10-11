/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fenetrage;

import java.awt.*;
import java.awt.LayoutManager;
import javax.swing.JFrame;

/**
 *
 * @author Manitra
 */
public class MyFrame extends JFrame{
    private Graphique g = new Graphique();
    public MyFrame() throws Exception
    {
        g.setFrame(this);
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Us Open");
        this.setLayout(new GridLayout());
        MyPanel panel = new MyPanel(this.getG());
        g.setPanel(panel);
        this.add(panel);       
        this.add(g);
        this.setVisible(true);
    }

    public Graphique getG() {
        return g;
    }

    public void setG(Graphique g) {
        this.g = g;
    }
    
}
