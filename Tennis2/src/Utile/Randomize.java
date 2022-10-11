/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utile;

import java.util.Random;

/**
 *
 * @author Manitra
 */
public class Randomize
{
    public int random(int inf,int sup)
    {
        Random random = new Random();
        int nb;
        nb = inf+random.nextInt(sup-inf);
        return nb;
    }
}
