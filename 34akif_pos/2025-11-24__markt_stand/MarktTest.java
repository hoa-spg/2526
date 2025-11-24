

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MarktTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MarktTest
{
    /**
     * Default constructor for test class MarktTest
     */
    public MarktTest()
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
    public void testMaxEssensStaende() {
        Markt markt1 = new Markt();
        Stand s1 = new Stand("Christbaumkugeln", false);
        Stand s2 = new Stand("Punsch", true);
        Stand s3 = new Stand("Spielzeug", false);
        markt1.standHinzufugen(s1);
        markt1.standHinzufugen(s2);
        markt1.standHinzufugen(s3);
        
        assertEquals(3, markt1.anzahlStaende());
        Stand s4 = new Stand("Langos", true);
        boolean hinzugefuegt = markt1.standHinzufugen(s4);
        assertEquals(false, hinzugefuegt);
        assertEquals(3, markt1.anzahlStaende());    
    }
    
    @Test
    public void testMarktVoll() {
        Markt markt1 = new Markt();
        Stand s1 = new Stand("Christbaumkugeln", false);
        Stand s2 = new Stand("Punsch", true);
        Stand s3 = new Stand("Spielzeug", false);
        markt1.standHinzufugen(s1);
        markt1.standHinzufugen(s2);
        markt1.standHinzufugen(s3);
        
        assertEquals(3, markt1.anzahlStaende());
        Stand s4 = new Stand("Weihnachtskerzen", false);
        boolean hinzugefuegt = markt1.standHinzufugen(s4);
        assertEquals(true, hinzugefuegt);
        assertEquals(4, markt1.anzahlStaende());   
        
        Stand s5 = new Stand("Christbäume", false);
        hinzugefuegt = markt1.standHinzufugen(s5);
        assertEquals(false, hinzugefuegt);
        assertEquals(4, markt1.anzahlStaende());
    }    
    
    @Test
    public void testStandEntfernen() {
        Markt markt1 = new Markt();
        Stand s1 = new Stand("Christbaumkugeln", false);
        Stand s2 = new Stand("Punsch", true);
        Stand s3 = new Stand("Spielzeug", false);
        markt1.standHinzufugen(s1);
        markt1.standHinzufugen(s2);
        markt1.standHinzufugen(s3);
        
        assertEquals(3, markt1.anzahlStaende());
        Stand s4 = markt1.standEntfernen("Christbaumkugeln");
        assertEquals(2, markt1.anzahlStaende());
        
        assertEquals(s4, s1);        
    }    
    
    @Test
    public void print()
    {
        Markt markt1 = new Markt();
        Stand s1 = new Stand("Christbaumkugeln", false);
        Stand s2 = new Stand("Punsch", true);
        Stand s3 = new Stand("Spielzeug", false);
        markt1.standHinzufugen(s1);
        markt1.standHinzufugen(s2);
        markt1.standHinzufugen(s3);
        
        markt1.print();
    }
}

