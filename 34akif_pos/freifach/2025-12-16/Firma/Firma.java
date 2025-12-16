
public class Firma {
    private String name;
    private Mitarbeiter ma1;
    private Mitarbeiter ma2;
    private Mitarbeiter ma3;

    public Firma() {
        setName("n/a");
    }

    public Firma(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name!=null && !name.isBlank()){
            this.name = name;
        }else{
            System.out.println("FEHLER: Firmenname darf nicht leer sein!");
        }
    }
    
    public void einstellen(Mitarbeiter ma) {
        if (ma != null) {
            if (ma1 == null){
                ma1 = ma;
            } else if ( ma2 == null){
                ma2 = ma;
            } else if ( ma3 == null){
                ma3 = ma;
            } else {
                System.out.println("FEHLER: kein Platz in Firma vorhanden");
            }

        } else {
            System.out.println("FEHLER: ungueltiger Mitarbeiter (null)");
        }
    }
    
    // Entfernen mit Namen
    public Mitarbeiter entfernen(String name) {
        if (name != null) { 
            // jeden mitarbeiter ueberpruefen ob dessen name gleich Parameter name ist.
            // wenn ja: mitarbeiter loeschen
            if (ma1 != null && ma1.getName().equals(name)) {
                Mitarbeiter tmp = ma1;
                ma1 = null;
                return tmp;
            } else if (ma2 != null && ma2.getName().equals(name)) {
                Mitarbeiter tmp = ma2;
                ma2 = null;
                return tmp;
            } else if (ma3 != null && ma3.getName().equals(name)) {
                Mitarbeiter tmp = ma3;
                ma3 = null;
                return tmp;
            } else {
                System.out.println("Mitarbeiter nicht gefunden.");
            }
            
        } else {
            System.out.println("FEHLER: name ist null.");
        }
        return null;
    }
    
    
    public int summeGehalt() {
        int summeGehalt = 0;
        if (ma1 != null) {
            summeGehalt += ma1.getGehalt();
        }
        if (ma2 != null) {
            summeGehalt += ma2.getGehalt();
        }
        if (ma3 != null) {
            summeGehalt += ma3.getGehalt();
        }
        return summeGehalt;
    }
    
    public int anzahlMitarbeiter() {
        int anzahl = 0;
        if (ma1 != null) {
            anzahl++;
        }
        if (ma2 != null) {
            anzahl++;
        }
        if (ma3 != null) {
            anzahl++;
        }
        return anzahl;
    }
    
    public double durchschnittsGehalt() {
        if (anzahlMitarbeiter() > 0) {
            double durchschnittsGehalt = (double)summeGehalt() / anzahlMitarbeiter();
            return durchschnittsGehalt;
        } else {
            System.out.println("FEHLER: keine Mitarbeiter vorhanden");
            return 0.0;
        }
    }
    
    public String toString() {
        String str = "Name: "+ name + "\n";
        str += "----------------------------------\n";
        str += ma1 + "\n";
        str += ma2 + "\n";
        str += ma3 + "\n";
        return str;
    }
    
    public void print() {
        System.out.println(this);
    }
}
    