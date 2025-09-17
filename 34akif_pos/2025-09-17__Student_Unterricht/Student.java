
public class Student {

    // Eigenschaften der Klasse
    private String name;
    private int geburtsjahr;
    private char geschlecht; // 'm' .. männlich, 'w' .. weiblich, 'x' .. divers
    
    public Student() {
        setName("Maria");
        setGeburtsjahr(1970);
        setGeschlecht('w');
    }
    
    public Student(String neuerName, int neuesGeburtsjahr, char neuesGeschlecht) {
        setName(neuerName);
        setGeburtsjahr(neuesGeburtsjahr);
        setGeschlecht(neuesGeschlecht);
    }
    
    // Methoden der Klasse
    public void setName(String neuerName) {
        name = neuerName; // Zuweisung
    }
    
    public String getName() {
        return name;
    }
    
    public void setGeburtsjahr(int neuesGeburtsjahr) {
        geburtsjahr = neuesGeburtsjahr; 
    }
    
    public int getGeburtsjahr() {
        return geburtsjahr;
    }
    
    public void setGeschlecht(char neuesGeschlecht) {
        geschlecht = neuesGeschlecht;
    }
    
    public char getGeschlecht() {
        return geschlecht;
    }
    
    public void printStudent() {
        System.out.println("Name: " + name + " (" + geschlecht + "), Geburtsjahr: " + geburtsjahr);
    }
    
    
}
