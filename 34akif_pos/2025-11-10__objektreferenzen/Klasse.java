
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
    public void inskribieren(Student neu) {
        if (neu != null) {
            if (this.stud1 == null) {
                this.stud1 = neu;
            } else if (this.stud2 == null) {
                this.stud2 = neu;
            } else if (this.stud3 == null) {
                this.stud3 = neu;
            } else {
                System.out.println("Klasse voll, kann nicht inskribieren");
            }
        }
    }
    
    /**
     * Entfernt alle Referenzen auf den uebergebenen Studenten
     */
    public void entfernen(Student stud) {
        // TODO
    }
    
    /**
     * Entfernt ersten Studenten mit uebereinstimmendem Namen, 
     * und gib Referenz auf diesen Studenten als Rueckgabewert zurueck.
     */
    public Student entfernen(String name) {
        // TODO
        return null;
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
