
public class Klasse {

    private String name;
    private Student stud1;
    private Student stud2;
    private Student stud3;

    public Klasse() {
        setName("3AKIF");    
    }

    public Klasse(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("FEHLER: ungueltiger Name");
        }
    }

    public String getName() {
        return name;
    }

    /**
     * TODO Rueckgabewert boolean: Inskribtion erfolreich
     */
    public boolean inskribieren(Student neu) {
        if (neu != null) {
            if (this.stud1 == null) {
                this.stud1 = neu;
            } else if (this.stud2 == null) {
                this.stud2 = neu;
            } else if (this.stud3 == null) {
                this.stud3 = neu;
            } else {
                System.out.println("Klasse voll, kann nicht inskribieren");
                return false;
            }
        
        } else {
            System.out.println("FEHLER: ungueltiger Student");
            return false;
        }
        return true;
    }
    
    /**
     * Entfernt alle Referenzen auf den uebergebenen Studenten
     */
    public void entfernen(Student stud) {
        if (stud != null) {
            if (stud1 == stud) {
                stud1 = null;
            } else if (stud2 == stud) {
                stud2 = null;
            } else if (stud3 == stud) {
                stud3 = null;
            } else {
                System.out.println("Student nicht in Klasse.");
            }
        } else {
            System.out.println("FEHLER: parameter ist null!");
        }
    }
    
    /**
     * Entfernt ersten Studenten mit uebereinstimmendem Namen, 
     * und gib Referenz auf diesen Studenten als Rueckgabewert zurueck.
     */
    public Student entfernen(String name) {
        if (name != null) {
            if (stud1 != null && stud1.getName().equals(name)) {
                Student tmp = stud1;
                stud1 = null;
                return tmp;
            } else if (stud2 != null && stud2.getName().equals(name)) {
                Student tmp = stud2;
                stud2 = null;
                return tmp;
            } else if (stud3 != null && stud3.getName().equals(name)) {
                Student tmp = stud3;
                stud3 = null;
                return tmp;
            } else {
                System.out.println("Kein Student mit Name " + name + " vorhanden");
            }
        } else {
            System.out.println("Fehler: ungueltiger Name");
        }
        return null;
    }
    
    public int anzahlStudenten() {
        int anzahl = 0;
        if (stud1 != null) {
            anzahl++;
        } 
        if (stud2 != null) {
            anzahl++;
        } 
        if (stud3 != null) {
            anzahl++;
        }
        return anzahl;
    }
    
    public double durchschnittsAlter() {
        int summeGeburtsjahr = 0;
        
        if (stud1 != null) {
            summeGeburtsjahr += stud1.getGeburtsjahr();
        } 
        if (stud2 != null) {
            summeGeburtsjahr += stud2.getGeburtsjahr();
        } 
        if (stud3 != null) {
            summeGeburtsjahr += stud3.getGeburtsjahr();
        }
        int anzahl = anzahlStudenten();
        if (anzahl > 0) {
            double durchschnittsGeburtsjahr = (double)summeGeburtsjahr / anzahl;
            return 2025.0 - durchschnittsGeburtsjahr;
        } else {
            System.out.println("FEHLER: keine Studenten vorhanden.");
            return -1.0; // magic value
        }
    }
    
    public String toString() {
        String str = "Klasse " + name + "\n";
        if (stud1 != null) {
            str += stud1 + "\n";
        } else {
            str += "freier Platz\n";
        }
        str += ((stud2 != null) ? stud2 : "freier Platz") + "\n";
        str += ((stud3 != null) ? stud3 : "freier Platz") + "\n";
        return str;
    }

    public void print() {
        System.out.println(this);
    }
}
