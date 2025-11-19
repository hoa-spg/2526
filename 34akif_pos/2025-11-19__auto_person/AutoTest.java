

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
    public void einsteigen() {
        Auto auto = new Auto("Ferrari", 1150);
        Person p1 = new Person("Ferdinand", true, true, 85);
        Person p2 = new Person("Lea", false, false, 70);
        Person p3 = new Person("Petra", false, true, 60);
        auto.einsteigen(p1);
        auto.einsteigen(p2);
        assertEquals(p1, auto.getFahrer());
        assertEquals(p2, auto.getBeifahrer());
        assertEquals(null, auto.getRueckbank());
        auto.einsteigen(p3);
        assertEquals(p3, auto.getRueckbank());
    }
}

