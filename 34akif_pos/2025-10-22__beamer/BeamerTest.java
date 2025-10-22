

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BeamerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BeamerTest
{
    /**
     * Default constructor for test class BeamerTest
     */
    public BeamerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testConstructor()
    {
        Beamer beamer1 = new Beamer();
        assertEquals("C2.14", beamer1.getRaum());
        assertEquals(50, beamer1.getRestzeit());
        assertEquals(false, beamer1.isEingeschaltet());
    }

    @Test
    public void einschalten()
    {
        Beamer beamer1 = new Beamer();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(50, beamer1.getRestzeit());
        beamer1.einschalten();
        assertEquals(true, beamer1.isEingeschaltet());
        assertEquals(49, beamer1.getRestzeit());
    }
    
    
    @Test
    public void einschaltenNichtMoeglich()
    {
        Beamer beamer1 = new Beamer();
        beamer1.runterwerfen();
        beamer1.einschalten();
        assertEquals(false, beamer1.isEingeschaltet());
    }
    
    @Test
    public void einschaltenAmEndeDerLebensdauer()
    {
        Beamer beamer1 = new Beamer();
        beamer1.setRestzeit(2);
        beamer1.einschalten();
        beamer1.ausschalten();
        assertEquals(1, beamer1.getRestzeit());
        String msg = "Beamer in Raum C2.14 (ausgeschaltet), Restzeit: 1 h";
        assertEquals(msg, beamer1.toString());
        beamer1.einschalten();
        msg = "Beamer in Raum C2.14 (eingeschaltet), Restzeit: 0 h, Ende der Lebensdauer erreicht";
        assertEquals(msg, beamer1.toString());
        beamer1.ausschalten();
        msg = "Beamer in Raum C2.14 (ausgeschaltet), Restzeit: 0 h, KAPUTT";
        assertEquals(msg, beamer1.toString());
        
    }
    
    @Test
    public void ausschalten()
    {
        Beamer beamer1 = new Beamer();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(50, beamer1.getRestzeit());
        beamer1.einschalten();
        assertEquals(true, beamer1.isEingeschaltet());
        assertEquals(49, beamer1.getRestzeit());
        beamer1.ausschalten();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(49, beamer1.getRestzeit());
    }
    
    @Test
    public void runterwerfen()
    {
        Beamer beamer1 = new Beamer();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(50, beamer1.getRestzeit());
        beamer1.einschalten();
        beamer1.runterwerfen();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(0, beamer1.getRestzeit());
    }
    
    @Test
    public void reparieren()
    {
        Beamer beamer1 = new Beamer();
        beamer1.runterwerfen();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(0, beamer1.getRestzeit());
        beamer1.reparieren();
        assertEquals(false, beamer1.isEingeschaltet());
        assertEquals(50, beamer1.getRestzeit());
        
    }
    
    
    @Test
    public void reparierenNichtMoeglich() {
        Beamer beamer1 = new Beamer();
        beamer1.setRestzeit(6);
        beamer1.reparieren();
        assertEquals(6, beamer1.getRestzeit());
    }
    
    
    
}


