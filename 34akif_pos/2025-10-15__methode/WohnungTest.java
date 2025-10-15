

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WohnungTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WohnungTest
{
    /**
     * Default constructor for test class WohnungTest
     */
    public WohnungTest()
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
    
    // Testmethoden
    

    @Test
    public void testParameterloserKonstruktor()
    {
        Wohnung wohnung1 = new Wohnung();
        assertEquals(3, wohnung1.getAnzahlZimmer());
        assertEquals(false, wohnung1.hasBalkon());
        assertEquals(70, wohnung1.getGroesse());
    }

    @Test
    public void testKonstruktor()
    {
        Wohnung wohnung1 = new Wohnung("XYZ", 99, true, 5, 123.45);
        assertEquals("XYZ", wohnung1.getAdresse());
        assertEquals(5, wohnung1.getAnzahlZimmer());
        assertEquals(true, wohnung1.hasBalkon());
        assertEquals(99, wohnung1.getGroesse());
        assertEquals(123.45, wohnung1.getMonatsMiete(), 0.05);
    }

    @Test
    public void testSetAdresse()
    {
        Wohnung wohnung1 = new Wohnung();
        wohnung1.setAdresse(null);
        assertNotNull(wohnung1.getAdresse());
        wohnung1.setAdresse("");
        assertNotSame("", wohnung1.getAdresse());
    }
}



