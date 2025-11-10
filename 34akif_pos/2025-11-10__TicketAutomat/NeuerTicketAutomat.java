
public class NeuerTicketAutomat
{
    
    private String standort;
    private int ticketPreis;
    private int eingeworfenesGuthaben;
    private int gesamtEinnahmen;
    
    public NeuerTicketAutomat(String standort, int ticketPreis) {
 
        if (standort != null) {
            this.standort = standort;
        } else {
            System.out.println("Fehler: ungueltiger Standort");
        }
        
        setTicketPreis(ticketPreis);
        
        this.eingeworfenesGuthaben = 0;
        this.gesamtEinnahmen = 0;
    }
    
    public void setTicketPreis(int ticketPreis) {
        if (ticketPreis >= 0 && ticketPreis < 1000) {
            this.ticketPreis = ticketPreis;
        } else {
            System.out.println("Fehler: ungueltiger Ticket-Preis: " + ticketPreis);
        }
    }
    
    public int getTicketPreis() {
        return ticketPreis;
    }
    
    public int getEingeworfenesGuthaben() {
        return eingeworfenesGuthaben;
    }
    
    public int getGesamtEinnahmen() {
        return gesamtEinnahmen;
    }
    
    public void einwerfen(int betrag) {
        if (betrag > 0) {
            this.eingeworfenesGuthaben = this.eingeworfenesGuthaben + betrag;
        } else {
            System.out.println("Fehler: ungueltiger Betrag: " + betrag);
        }
    }
    
    public String ticketString() {
         String ticket = "";
         ticket = ticket + "###################################\n\n";
         ticket = ticket + "Gueltiges Ticket\n";
         ticket = ticket + "Preis: " + getTicketPreis() + "\n\n";
         ticket = ticket + "###################################\n";
         return ticket;
    }
    
    public boolean ticketDrucken() {
        if (eingeworfenesGuthaben >= ticketPreis) {
            eingeworfenesGuthaben = eingeworfenesGuthaben - ticketPreis;
            System.out.println(ticketString());
            return true;
        } else {
            System.out.println("Nicht genug Guthaben! Ticket kann nicht gedruckt werden.");
            return false;
        }
    }
    
    public int wechselGeldAuszahlen() {
        int zwischenspeicher = this.eingeworfenesGuthaben;
        this.eingeworfenesGuthaben = 0;
        return zwischenspeicher;     
    }
    
    public String status() {
        // TODO
        return "";
    }
    
    public void print() {
        // TODO
    }
}
