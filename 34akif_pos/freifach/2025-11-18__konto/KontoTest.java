

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
public class KontoTest {
    
    private Konto konto;
    
    public KontoTest() {
    }

    @BeforeEach
    public void setUp() {
        konto = new Konto();
        konto.setUeberziehungsRahmen(0);
    }

    @Test
    public void generateIban() {
        String iban = konto.getIban();
        System.out.println("IBAN: " + iban);
        int length = iban.length();
        assertEquals(20, length);
    }
    
    @Test
    public void setUeberziehungsRahmenOk() {
        konto.setUeberziehungsRahmen(3000);
        assertEquals(3000, konto.getUeberziehungsRahmen());
    }
    
    @Test
    public void setUeberziehungsRahmenKontoUeberzogen() {
        konto.setUeberziehungsRahmen(3000);
        assertEquals(3000, konto.getUeberziehungsRahmen());
        konto.abbuchen(2500);
        assertEquals(-2500, konto.kontostand());
        konto.setUeberziehungsRahmen(1000);
        // Erwartung: klappt nicht, weil Konto mehr als 1000 ueberzogen
        assertEquals(3000, konto.getUeberziehungsRahmen());
    }
    
    @Test
    public void setUeberziehungsRahmenUngueltigenWert() {
        konto.setUeberziehungsRahmen(-1);
        assertEquals(0, konto.getUeberziehungsRahmen());
    }    
    
    @Test
    public void testEinzahlenOk() {
        konto.einzahlen(555);
        assertEquals(555, konto.kontostand());
    }
    
    @Test
    public void testEinzahlenFehlerhafterBetrag() {
        konto.einzahlen(-555);
        assertEquals(0, konto.kontostand());        
    }    
    
    @Test
    public void testAbbuchenOk() {
        konto.einzahlen(555);
        assertEquals(555, konto.kontostand());        
        konto.abbuchen(155);
        assertEquals(400, konto.kontostand());        
    }   
    
    @Test
    public void testAbbuchenFehlerhafterBetrag() {
        konto.einzahlen(555);
        assertEquals(555, konto.kontostand());        
        konto.abbuchen(-155);
        assertEquals(555, konto.kontostand());          
    }  
    
    @Test
    public void testAbbuchenUeberziehen() {
        konto.einzahlen(555);
        assertEquals(555, konto.kontostand());        
        konto.abbuchen(1000);
        assertEquals(555, konto.kontostand());          
    }      
    
    @Test
    public void testAbbuchenUeberziehungsrahmen() {
        konto.setUeberziehungsRahmen(1000);
        konto.einzahlen(555);
        assertEquals(555, konto.kontostand());        
        konto.abbuchen(1000);
        assertEquals(-445, konto.kontostand());  
    }     
    
    @Test
    public void testAbbuchenUeberziehungsrahmenUeberschritten() {
        konto.setUeberziehungsRahmen(1000);
        konto.einzahlen(555);
        assertEquals(555, konto.kontostand());        
        konto.abbuchen(2000);
        assertEquals(555, konto.kontostand());         
    }          
    
    @Test
    public void testZinsenBerechnen1() {
        konto.einzahlen(1000);
        assertEquals(1000, konto.kontostand()); 
        konto.berechneZinsen(0.01);
        assertEquals(1010, konto.kontostand()); 
    }
    
    @Test
    public void testZinsenBerechnen2() {
        konto.einzahlen(100);
        assertEquals(100, konto.kontostand()); 
        konto.berechneZinsen(0.005);
        assertEquals(101, konto.kontostand()); 
    }
    
    @Test
    public void testRunden() {
        assertEquals(101, Konto.runden(100.49999));
        assertEquals(100, Konto.runden(100.47));
        assertEquals(-101, Konto.runden(-100.49999));
        assertEquals(-100, Konto.runden(-100.47));        
        
    }
}

