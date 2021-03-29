package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void latausToimii() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    @Test
    public void saldoPienenee() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    }
    
    @Test
    public void saldoEiMeneNeg() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void riittikoRahat() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void riittikoRahat2() {
        assertEquals(false, kortti.otaRahaa(15));
    }
}
