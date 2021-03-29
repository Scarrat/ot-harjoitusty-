/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kostajoo
 */
public class KassapaateTest {
    
   Kassapaate paate;
   Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
    }
    
    @Test
    public void uusiPaateOikein() {
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void ostoToimiiEdullisella() {
        assertEquals(10, paate.syoEdullisesti(250));
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void ostoToimiiMaukkaalla() {
        assertEquals(10, paate.syoMaukkaasti(410));
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void edullinenLiianVahan() {
        assertEquals(230,paate.syoEdullisesti(230));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasLiianVahan() {
        assertEquals(230,paate.syoMaukkaasti(230));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenKortilla() {
        kortti = new Maksukortti(400);
        assertEquals(true, paate.syoEdullisesti(kortti));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasKortilla() {
        kortti = new Maksukortti(400);
        assertEquals(true, paate.syoMaukkaasti(kortti));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenKortillaEiRiita() {
        kortti = new Maksukortti(230);
        assertEquals(false, paate.syoEdullisesti(kortti));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasKortillaEiRiita() {
        kortti = new Maksukortti(230);
        assertEquals(false, paate.syoMaukkaasti(kortti));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void latausToimii() {
        kortti = new Maksukortti(10);
        paate.lataaRahaaKortille(kortti, 10);
        assertEquals(100010, paate.kassassaRahaa());
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void latausToimiiOikein() {
        kortti = new Maksukortti(10);
        paate.lataaRahaaKortille(kortti, -5);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(10, kortti.saldo());
    }
}
