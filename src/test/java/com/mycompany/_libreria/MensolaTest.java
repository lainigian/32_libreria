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
public class MensolaTest {
    
   
    Libro l1,l2,l3;
    Mensola m1;
    
    @Before
    public void inizilaizzazione()
    {
        m1=new Mensola();
        l1=new Libro("I promessi sposi","Manzoni",500);
        l2=new Libro("La divina commedia","Dante",300);
        l3=new Libro("Moby Dick","Melville",600);
    }

    /**
     * Test of getNumMaxVolumi method, of class Mensola.
     */
    @Test
    public void testGetNumMaxVolumi() 
    {
        int atteso,attuale;
        atteso=15;
        attuale=m1.getNumMaxVolumi();
        assertEquals("Numero massimo di libri",atteso,attuale);
    }

    /**
     * Test of getNumVolumi method, of class Mensola.
     */
    @Test
    public void testGetNumVolumi() 
    {
        int atteso,attuale;
        atteso=0;
        attuale=m1.getNumVolumi();
        assertEquals("getNumVolumi mensola vuota",atteso, attuale);
        
        m1.setVolume(l1, 2);
        atteso=1;
        attuale=m1.getNumVolumi();
        assertEquals("getNumVolumi mensola con un libro",atteso, attuale);

        m1.setVolume(l2, 5);
        atteso=2;
        attuale=m1.getNumVolumi();
        assertEquals("getNumVolumi mensola con due libri",atteso, attuale);
        
        m1.rimuoviVolume(5);
        atteso=1;
        attuale=m1.getNumVolumi();
        assertEquals("getNumVolumi mensola con un libro",atteso, attuale);
 
    }

    /**
     * Test of setVolume method, of class Mensola.
     */
    @Test
    public void testSetVolume() 
    {
        m1.setVolume(l1, 2);
        Libro libro=m1.getVolume(2);
        assertTrue("setVolume in posixione corretta",libro.equals(l1));
        
        int atteso,attuale;
        atteso=-1;
        attuale=m1.setVolume(l1, -1);
        assertEquals("setVolume con posizione negativa",atteso, attuale);
        
        atteso=-1;
        attuale=m1.setVolume(l1, m1.getNumMaxVolumi());
        assertEquals("setVolume con posizione maggiore al massimo conserntito",atteso, attuale);
        
        atteso=-2;
        attuale=m1.setVolume(l2, 2);
        assertEquals("setVolume con posizione occupata",atteso, attuale);
   
    }

    /**
     * Test of getVolume method, of class Mensola.
     */
    @Test
    public void testGetVolume() 
    {
        Libro libro=m1.getVolume(-1);
        assertNull("Get volume con posizione <0", libro);
        
        libro=m1.getVolume(m1.getNumMaxVolumi());
        assertNull("Get volume con posizione superiore alla masssima posizione disponibile", libro);
        
        libro=m1.getVolume(3);
        assertNull("Get volume con posizione vuota", libro);
    
    }

    /**
     * Test of rimuoviVolume method, of class Mensola.
     */
    @Test
    public void testRimuoviVolume() 
    {
        m1.setVolume(l1, 0);
        m1.setVolume(l2, 5);
        m1.setVolume(l3, 14);
        
        int atteso,attuale;
        atteso=0;
        attuale=m1.rimuoviVolume(0);
        assertEquals("Metodo rimuoviVolume corretto",atteso, attuale);
        
        atteso=2;
        attuale=m1.getNumVolumi();
        assertEquals("Metodo rimuoviVolume dopo rimozione corretta",atteso, attuale);
        
        atteso=-1;
        attuale=m1.rimuoviVolume(-1);
        assertEquals("Metodo rimuoviVolume con posizione negativa",atteso, attuale);
        
        atteso=-1;
        attuale=m1.rimuoviVolume(m1.getNumMaxVolumi());
        assertEquals("Metodo rimuoviVolume con posizione superiore all aposizione massima",atteso, attuale);
        
        atteso=-2;
        attuale=m1.rimuoviVolume(3);
        assertEquals("Metodo rimuoviVolume con posizione vuota",atteso, attuale);
        
        
        
    }

    /**
     * Test of presenzaTitolo method, of class Mensola.
     */
    @Test
    public void testPresenzaTitolo() 
    {
        assertFalse("PresenzaTitolo con mensola vuota",m1.presenzaTitolo("Prova"));
        
        m1.setVolume(l1, 2);
        assertTrue("PresenzaTitolo con libro presente",m1.presenzaTitolo("I promessi sposi"));
        assertFalse("PresenzaTitolo titolo non presente",m1.presenzaTitolo("I promessi cosi"));
        assertTrue("PresenzaTitolo con libro presente",m1.presenzaTitolo("i promessi Sposi"));
    }

    /**
     * Test of equals method, of class Mensola.
     */
    @Test
    public void testEquals() 
    {
        m1.setVolume(l1, 0);
        
        Mensola m2=new Mensola(m1);
        assertTrue("Mensola euguali",m1.equals(m2));
        
        m2.setVolume(l2, 1);
        assertFalse("Metodo equals fra mensola con un libro e mensola con due libri",m1.equals(m2));
        
        m2.rimuoviVolume(0);
        m2.rimuoviVolume(1);
        m2.setVolume(l2, 0);
        assertFalse("Metodo equals fra due mensole con libri diversi nella stessa posizione",m1.equals(m2));
        
        m2.rimuoviVolume(0);
        m2.setVolume(l1, 1);
        assertFalse("Metodo equals fra mensole con libro uguale in posizioni diverse",m1.equals(m2));
                
        
        
    }
    
}
