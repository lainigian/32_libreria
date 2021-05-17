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
public class LibroTest 
{
    
    Libro libroVuoto, promessiSposi;
    @Before
    public void inizializzazione()
    {
        libroVuoto= new Libro();
        promessiSposi=new Libro ("I promessi sposi","Manzoni",500);
    }
    /**
     * Test of getTitolo method, of class Libro.
     */
    @Test
    public void testGetTitolo() 
    {
        
        String atteso="";
        String attuale=libroVuoto.getTitolo();
        assertEquals("Libro senza titolo", atteso,attuale);
        
        atteso="I promessi sposi";
        attuale=promessiSposi.getTitolo();
        assertEquals("Libro con titolo", atteso,attuale);
    }

    /**
     * Test of setTitolo method, of class Libro.
     */
    @Test
    public void testSetTitolo() 
    {
        Libro l=libroVuoto;
        l.setTitolo("I promessi sposi");
        String atteso="I promessi sposi";
        String attuale=l.getTitolo();
        assertEquals("Libro con set titolo", atteso,attuale);
        
        l.setTitolo("La divina commedia");
        atteso="La divina commedia";
        attuale=l.getTitolo();
        assertEquals("Libro con set titolo", atteso,attuale);
    }

    /**
     * Test of getCostoFisso method, of class Libro.
     */
    @Test
    public void testGetCostoFisso() 
    {
        Libro l=libroVuoto;
        double atteso,attuale;
        atteso=5.5;
        attuale=l.getCostoFisso();
        assertEquals("GetCosto fisso",attuale, attuale, 0.001);
    }

    /**
     * Test of getAutore method, of class Libro.
     */
    @Test
    public void testGetAutore() 
    {
        Libro l1=libroVuoto;
        String atteso="";
        String attuale=l1.getAutore();
        assertEquals("Autore libro senza autore", atteso,attuale);
        
        l1=promessiSposi;
        atteso="Manzoni";
        attuale=l1.getAutore();
        assertEquals("Autore libro com autore", atteso,attuale); 
    }

    /**
     * Test of setAutore method, of class Libro.
     */
    @Test
    public void testSetAutore() 
    {
        Libro l1=libroVuoto;        
        l1.setAutore("Manzoni");
        String atteso="Manzoni";
        String attuale=l1.getAutore();
        assertEquals("setAutore Manzoni", atteso,attuale); 
        
        l1.setAutore("Dante");
        atteso="Dante";
        attuale=l1.getAutore();
        assertEquals("setAutore Dante", atteso,attuale); 
        
    }

    /**
     * Test of getNumeroPagine method, of class Libro.
     */
    @Test
    public void testGetNumeroPagine()
    {
        Libro l=libroVuoto;
        int atteso,attuale;
        
        atteso=0;
        attuale=l.getNumeroPagine();
        assertEquals("Libro con 0 pagine",atteso, attuale);
        
        l=promessiSposi;
        atteso=500;
        attuale=l.getNumeroPagine();
        assertEquals("Libro con 500 pagine",atteso, attuale);
        
        Libro l1=new Libro("I promessi sposi","Manzoni",-1);
        atteso=0;
        attuale=l1.getNumeroPagine();
        assertEquals("Libro con numero di pagine negativo",atteso, attuale);
    }

    /**
     * Test of setNumeroPagine method, of class Libro.
     */
    @Test
    public void testSetNumeroPagine() 
    {
       Libro l=promessiSposi;
       l.setNumeroPagine(450);
       int atteso=450;
       int attuale=l.getNumeroPagine();
       assertEquals("setNumeroPagine 450",atteso, attuale);
       
       l.setNumeroPagine(-1);
       attuale=450;
       atteso=l.getNumeroPagine();
       assertEquals("setNumeroPagine -1",atteso, attuale);
        
       l.setNumeroPagine(0);
       atteso=0;
       attuale=l.getNumeroPagine();
       assertEquals("setNumeroPagine 0",atteso, attuale);
    }

    /**
     * Test of prezzo method, of class Libro.
     */
    @Test
    public void testPrezzo() 
    {
        Libro l=promessiSposi;
        double atteso=30.5;
        double attuale;
        attuale=l.prezzo();
        assertEquals("Libro con numero di pagine 500",atteso, attuale,0.0001);
        
        l=libroVuoto;
        atteso=l.getCostoFisso();
        attuale=l.prezzo();
        attuale=l.prezzo();
        assertEquals("Libro con numero di pagine 0",atteso, attuale,0.0001);
                
    }

    /**
     * Test of setCostoPagina method, of class Libro.
     */
    @Test
    public void testSetCostoPagina() 
    {
        Libro l= libroVuoto;
        double atteso,attuale;
        Libro.setCostoPagina(0.1);
        atteso=0.1;
        attuale=l.getCostoPagina();
        assertEquals("setCostopagina 0.1",atteso, attuale,0.0001);
        
        Libro.setCostoPagina(-0.1);
        atteso=0.1;
        attuale=l.getCostoPagina();
        assertEquals("setCostopagina 0.1",atteso, attuale,0.0001);

        Libro.setCostoPagina(0);
        atteso=0;
        attuale=l.getCostoPagina();
        assertEquals("setCostopagina 0.1",atteso, attuale,0.0001);
        
        Libro.setCostoPagina(0.05);
        
    }

    /**
     * Test of getCostoPagina method, of class Libro.
     */
    @Test
    public void testGetCostoPagina() 
    {
        double atteso=0.05;
        double attuale=Libro.getCostoPagina();
        assertEquals("getCostoPagina metodo statico",atteso, attuale,0.001);
    }

    /**
     * Test of toString method, of class Libro.
     */
    @Test
    public void testToString() 
    {
       Libro l1=libroVuoto;
       String atteso=";;0 pagine";
       String attuale=l1.toString();
       assertEquals("metodo toString libro vuoto",attuale, atteso);
       
       l1=promessiSposi;
       atteso="I promessi sposi;Manzoni;500 pagine";
       attuale=l1.toString();
       assertEquals("Metodo toString I promessi sposi",atteso, attuale);
        
    }

    /**
     * Test of equals method, of class Libro.
     */
    @Test
    public void testEquals() 
    {
        Libro l1=promessiSposi;
        Libro l2=new Libro (promessiSposi);        
        assertTrue("Costruttore di copia",l1.equals(l2));
        
        l2.setTitolo("La divina commedia");
        assertFalse("Libri con titolo diverso",l1.equals(l2));
        
        Libro l3=new Libro (l1);
        l3.setAutore("Dante");
        assertFalse("Libri con titolo diverso",l1.equals(l3));
        
        Libro l4=new Libro (l1);
        l4.setNumeroPagine(100);
        assertFalse("Libri con titolo diverso",l1.equals(l4));
        
        
        
    }
    
}
