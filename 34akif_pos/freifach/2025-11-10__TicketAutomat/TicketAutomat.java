public class TicketAutomat {

    // -- ATTRIBUTE ----------------------------------------------------------------------------------------------------

    private String standort;
    private int ticketPreis;
    private int eingeworfen;
    private int gesamtEinnahmen;

    // -- KONSTRUKTOR --------------------------------------------------------------------------------------------------
    public TicketAutomat(String standort, int ticketPreis) {
        if (standort != null && !standort.isBlank()) {
            this.standort = standort;
        } else {
            System.out.println("Fehler: ungueltiger Standort");
        }
        setTicketPreis(ticketPreis);

        this.eingeworfen = 0;
        this.gesamtEinnahmen = 0;
    }


    // -- GETTER/SETTER ------------------------------------------------------------------------------------------------

    public String getStandort() {
        return standort;
    }

    public int getTicketPreis() {
        return ticketPreis;
    }

    public void setTicketPreis(int ticketPreis) {
        if (ticketPreis > 0 && ticketPreis <= 100) {
            this.ticketPreis = ticketPreis;
        } else {
            System.out.println("Fehler: ungueltiger ticketPreis: " + ticketPreis);
        }
    }

    public int getEingeworfen() {
        return eingeworfen;
    }

    public void einwerfen(int betragInCent) {
        if (betragInCent > 0 && betragInCent <= 100) {
            eingeworfen = eingeworfen + betragInCent;
        } else {
            System.out.println("Fehler: unueltiger Betrag " + betragInCent);
        }
    }


    // -- SONSTIGE METHODEN --------------------------------------------------------------------------------------------

    /**
     * Gibt das Wechselgeld bzw. den bisher bezahlten Betrag zurück.
     * Setzt den bisher bezahlten Betrag zurück auf 0.
     */
    public int wechselGeldAuszahlen() {
        int wechselGeld = eingeworfen;
        eingeworfen = 0;
        return wechselGeld;
    }


    public String ticketString() {
        String ticketInfo = "";
        ticketInfo = ticketInfo + "#################################\n";
        ticketInfo = ticketInfo + "#    E I N Z E L T I C K E T     \n";
        ticketInfo = ticketInfo + "#--------------------------------\n";
        ticketInfo = ticketInfo + "#    Spenger-Line \u2122        \n";
        ticketInfo = ticketInfo + "#    von: " + standort + "      \n";
        ticketInfo = ticketInfo + "#--------------------------------\n";
        ticketInfo = ticketInfo + "#    Barzahlung | CENT: " + ticketPreis + "  \n";
        ticketInfo = ticketInfo + "#################################";
        return ticketInfo;
    }
    
    /**
     * - Pruefen, ob genug Geld eingeworfen
     * - Falls ja:
     *      - Gesamteinnahmen um bisher Ticketpreis erhöhen
     *      - Ticketpreis von eingeworfen abziehen
     *      - Ticket drucken
     * - Falls nein:
     *      - Fehlermeldung drucken
     */
    public String ticketDrucken() {
        String ticketInfo = "";
        if (eingeworfen >= ticketPreis) {
            ticketInfo = ticketString();
            gesamtEinnahmen = gesamtEinnahmen + ticketPreis;
            eingeworfen = eingeworfen - ticketPreis;
        } else {
            ticketInfo = ticketInfo + "#################################\n";
            ticketInfo = ticketInfo + "\nNicht genuegend Geld eingworfen!\n\n";
            ticketInfo = ticketInfo + "#################################\n";
        }
        return ticketInfo;
    }

    /**
     * Liefert Informationen über Standort, Ticketpreis und bisher bezahlten Betrag
     */
    public String status() {
        String infos = "";

        infos += "#################################\n";
        infos += "# Standort:    " + standort + "\n";
        infos += "# Ticketpreis: " + ticketPreis + "\n";
        infos += infos + "# Bezahlt:     " + eingeworfen + "\n";
        infos += infos + "#################################";

        return infos;
    }

    public String toString() {
        return "Standort: " + standort + ", Ticketpreis: " + ticketPreis + ", Bezahlt: " 
                + eingeworfen + ", Gesamteinnahmen: " + gesamtEinnahmen;
    }
    
    /**
     * Gibt sämtliche Informationen auf die Konsole aus
     */
    public void print() {
        System.out.println(status());
    }
    
  
}
