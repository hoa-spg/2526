
import java.util.Random;

public class Student {
    
    private String vorname;
    private String nachname;
    private String accountName;

    public Student() {
        setVorname("Lisa");
        setNachname("Maier");
        resetAccountName();
    }

    public Student(String vorname, String nachname) {
        setVorname(vorname);
        setNachname(nachname);
        resetAccountName();
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        if (vorname != null && !vorname.isBlank() && vorname.length() >= 2) {
            this.vorname = vorname;
        } else {
            System.out.println("FEHLER: ungueltiger Vorname.");
        }
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        if (nachname != null && !nachname.isBlank() && nachname.length() >= 2) {
            this.nachname = nachname;
        } else {
            System.out.println("FEHLER: ungueltiger Nachname.");
        }
    }
    
    public String getAccountName() {
        return this.accountName;
    }
    
    public String emailAddress() {
        return this.accountName.toLowerCase() + "@spengergasse.at";
    }
    
    /**
     * 3 Buchstaben des Nachnamens, dann 2 Buchstaben des Vornames, 3 Zufallszahlen
     */
    public String generateAccountName() {
        String acc = "";
        if (nachname.length() >= 3) {
            acc += nachname.substring(0, 3);
        } else {
            acc += nachname.substring(0, 2) + "X";
        }
        acc += vorname.substring(0, 2);
        Random random = new Random();
        int r = 100 + random.nextInt(900);
        acc += r;
        return acc.toUpperCase();
    }
    
    public void resetAccountName() {
        this.accountName = generateAccountName();    
    }
    
    public String toString() {
        return vorname + " " + nachname;
    }
    
    public void print() {
        System.out.println(this);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
