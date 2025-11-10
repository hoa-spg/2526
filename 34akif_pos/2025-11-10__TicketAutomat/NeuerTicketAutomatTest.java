

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class NeuerTicketAutomatTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NeuerTicketAutomatTest
{
    /**
     * Default constructor for test class NeuerTicketAutomatTest
     */
    public NeuerTicketAutomatTest()
    {
    }


    @Test
    public void testCreateTicketAutomat() {
        NeuerTicketAutomat ta = new NeuerTicketAutomat("Spengergasse", 30);
    }

    @Test
    public void testSetTicketPreis() {
        NeuerTicketAutomat neuerTic1 = new NeuerTicketAutomat("Spengergasse", 30);
        neuerTic1.setTicketPreis(50);
        assertEquals(50, neuerTic1.getTicketPreis());
    }

    @Test
    public void testSetTicketPreis2() {
        NeuerTicketAutomat neuerTic1 = new NeuerTicketAutomat("Spengergasse", 30);
        neuerTic1.setTicketPreis(-40);
        assertEquals(30, neuerTic1.getTicketPreis());
    }
    
    @Test
    public void testSetTicketPreis3() {
        NeuerTicketAutomat nta = new NeuerTicketAutomat("Spengergasse", 30);
        nta.setTicketPreis(1200);
        assertEquals(30, nta.getTicketPreis());
    }
    
    
    
    
    
    

    @Test
    public void testTicketDrucken1()
    {
        NeuerTicketAutomat neuerTic1 = new NeuerTicketAutomat("Spengergasse", 30);
        assertEquals(false, neuerTic1.ticketDrucken());
    }

    @Test
    public void testTicketDrucken2()
    {
        NeuerTicketAutomat neuerTic1 = new NeuerTicketAutomat("Spengergasse", 30);
        neuerTic1.einwerfen(30);
        assertEquals(true, neuerTic1.ticketDrucken());
    }

    @Test
    public void testTicketDrucken3() {
        NeuerTicketAutomat neuerTic1 = new NeuerTicketAutomat("Spengergasse", 30);
        neuerTic1.einwerfen(70);
        assertEquals(true, neuerTic1.ticketDrucken());
        assertEquals(true, neuerTic1.ticketDrucken());
        assertEquals(false, neuerTic1.ticketDrucken());
    }
    
    @Test
    public void testWechselGeld1() {
        NeuerTicketAutomat neuerTic1 = new NeuerTicketAutomat("Spengergasse", 30);
        neuerTic1.einwerfen(70);
        assertEquals(true, neuerTic1.ticketDrucken());
        assertEquals(true, neuerTic1.ticketDrucken());
        assertEquals(false, neuerTic1.ticketDrucken());
        assertEquals(10, neuerTic1.wechselGeldAuszahlen());   
    }
}






