

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DemoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DemoTest
{
    /**
     * Default constructor for test class DemoTest
     */
    public DemoTest()
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
    public void sumNumbersOneTo()
    {
        assertEquals(5050, Demo.sumNumbersOneTo(100));
    }
    
    @Test
    public void sumNumbersOneToN() {
        for (int i=1; i<100; i++) {
            int sum = i*(i+1)/2;
            assertEquals(sum, Demo.sumNumbersOneTo(i));
        }
        
    }
}

