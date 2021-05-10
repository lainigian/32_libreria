/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._libreria;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gian
 */
public class MensolaTest 
{
    Mensola m1,m2;
    Libro l1,l2;
    
    @Before
    public void Inizializzazione()
    {
        m1=new Mensola();
        m2=new Mensola();
        l1= new Libro("I promessi sposi","Manzoni",600);
        l2= new Libro("La divina commedia","Dante",300);
    }
    
    @Test
    public void testEquals()
    {
        m1.setVolume(l1, 0);
        m2.setVolume(l1, 0);
        assertEquals("Mensole con libro uguale in posizione uguale", m1,m2);
        
        m1.setVolume(l2, 1);
        assertFalse("m1 con due libri, m2 con un libro ", m1.equals(m2));
        
        m2.setVolume(l2, 1);
        m1.rimuoviVolume(1);
        assertFalse("m1 con un libro, m2 con due libri ", m1.equals(m2));
        
        m2.rimuoviVolume(1);
        m2.rimuoviVolume(0);
        m2.setVolume(l2, 0);
        assertFalse("m1 e m2 con libri diversi nella stessa posizione ", m1.equals(m2));
        
        
        m2.rimuoviVolume(0);
        m2.setVolume(l1, 1);
        assertFalse("m1 e m2 con libro uguale in posizioni diverse ", m1.equals(m2));
        
    }
  
    
    
}
