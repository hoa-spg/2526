

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AutoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutoTest
{
    /**
     * Default constructor for test class AutoTest
     */
    public AutoTest()
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
    public void testFahren() {
        Auto auto1 = new Auto();
        assertEquals(10.0, auto1.getTankFuellstand(), 0.001);
        assertEquals(true, auto1.fahren());
        assertEquals(9.0, auto1.getTankFuellstand(), 0.001);
        assertEquals(true, auto1.fahren());
        assertEquals(8.0, auto1.getTankFuellstand(), 0.001);
        assertEquals(true, auto1.fahren());
        assertEquals(7.0, auto1.getTankFuellstand(), 0.001);
        assertEquals(true, auto1.fahren());
        assertEquals(6.0, auto1.getTankFuellstand(), 0.001);        
    }

    @Test
    public void testTanken() {
        Auto auto1 = new Auto();
        assertEquals(10.0, auto1.getTankFuellstand(), 0.001);
        auto1.tanken(5.0);
        assertEquals(15.0, auto1.getTankFuellstand(), 0.001);
    }
    
    @Test
    public void testTankenNegativerParameter() {
        Auto auto1 = new Auto();
        assertEquals(10.0, auto1.getTankFuellstand(), 0.001);
        auto1.tanken(-5.0);
        assertEquals(10.0, auto1.getTankFuellstand(), 0.001);
    }  
    
    @Test
    public void testTankenTankVoll() {
        Auto auto1 = new Auto();
        assertEquals(10.0, auto1.getTankFuellstand(), 0.001);
        auto1.tanken(65.0);
        assertEquals(50.0, auto1.getTankFuellstand(), 0.001);
    }       
}


