

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class GalaxieTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GalaxieTest
{
    /**
     * Default constructor for test class GalaxieTest
     */
    public GalaxieTest()
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
    public void typ1()
    {
        Galaxie galaxie1 = new Galaxie();
        galaxie1.setTyp('x');
        assertEquals('s', galaxie1.getTyp());
    }

    @Test
    public void typ2()
    {
        Galaxie galaxie1 = new Galaxie();
        galaxie1.setTyp('i');
        assertEquals('i', galaxie1.getTyp());
    }

     @Test
    public void typ3()
    {
        Galaxie galaxie1 = new Galaxie();
        galaxie1.setTyp('e');
        assertEquals('e', galaxie1.getTyp());
    }


}


