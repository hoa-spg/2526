

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class KlasseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KlasseTest
{
    /**
     * Default constructor for test class KlasseTest
     */
    public KlasseTest()
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
    public void durchschnittsAlter()
    {
        Klasse klasse1 = new Klasse();
        Student student1 = new Student("Peter", 1998, 'm');
        Student student2 = new Student("Lisa", 2000, 'w');
        Student student3 = new Student("Sandra", 2001, 'w');
        klasse1.inskribieren(student1);
        klasse1.inskribieren(student2);
        klasse1.inskribieren(student3);
        double da = klasse1.durchschnittsAlter();
        assertEquals(25.333, da, 0.01);
        
    
    }
}

