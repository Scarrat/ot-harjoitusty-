/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dg;

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
public class playerTest {
    Player p;
    @Before
    public void setUp() {
        p = new Player();
    }
    
    @Test
    public void healthGoDown() {
        p.healthDown(3);
        assertEquals(p.getHealth(), 7);
    }
    
    @Test
    public void healthGoUp() {
        p.healthDown(3);
        p.healthUp(2);
        assertEquals(p.getHealth(), 9);
    }
}
