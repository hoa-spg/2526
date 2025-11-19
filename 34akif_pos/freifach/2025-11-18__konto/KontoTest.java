

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class KontoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KontoTest
{
    /**
     * Default constructor for test class KontoTest
     */
    public KontoTest()
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
    public void generateIban()
    {
        Konto k = new Konto();
        String iban = k.getIban();
        System.out.println("IBAN: " + iban);
        int length = iban.length();
        assertEquals(20, length);
    }
}

