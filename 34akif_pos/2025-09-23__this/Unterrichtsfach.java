
public class Unterrichtsfach {

    // Eigenschaften
    private String name;
    private int wochenStundenAnzahl;
    private boolean freifach;
    private char trakt; // 'A', 'B', 'C' oder 'D'

    // Konstruktoren
    public Unterrichtsfach() {
        setName("POS");
        setWochenStundenAnzahl(7);
        setFreifach(false);
        setTrakt('C');
    }

    public Unterrichtsfach(String name, int wochenStundenAnzahl, boolean freifach, char trakt) {
        setName(name);
        setWochenStundenAnzahl(wochenStundenAnzahl);
        setFreifach(freifach);
        setTrakt(trakt);
    }
    
    // Get/Set-Methoden
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWochenStundenAnzahl() {
        return wochenStundenAnzahl;
    }

    public void setWochenStundenAnzahl(int wochenStundenAnzahl) {
        this.wochenStundenAnzahl = wochenStundenAnzahl;
    }

    // getFreifach wäre auch möglich, aber klingt komisch
    public boolean isFreifach() {
        return freifach;
    }

    public void setFreifach(boolean freifach) {
        this.freifach = freifach;
    }

    public char getTrakt() {
        return trakt;
    }

    public void setTrakt(char trakt) {
        this.trakt = trakt;
    }

    // Weitere Methoden
    public void print() {
        if (this.isFreifach()) {
            System.out.println("Fach: " + getName() + " (" + getWochenStundenAnzahl() + " h/w) Trakt: " + getTrakt() + ", Freifach");
        } else {
            System.out.println("Fach: " + getName() + " (" + getWochenStundenAnzahl() + " h/w) Trakt: " + getTrakt() + ", reguläres Fach");
        }
    }
    
}
