public class Person {

    private String name;
    private boolean maennlich;
    private boolean fuehrerschein;
    private int gewicht;

    public Person() {
        setName("n/a");
        setMaennlich(true);
        setFuehrerschein(true);
        setGewicht(70);
    }

    public Person(String name, boolean maennlich, boolean fuehrerschein, int gewicht) {
        setName(name);
        setMaennlich(maennlich);
        setFuehrerschein(fuehrerschein);
        setGewicht(gewicht);
    }

    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        if (name != null && !name.isBlank()) {
            this.name = name; 
        } else {
            System.out.println("FEHLER: ungueltiger Name.");
        }
    }

    public boolean isMaennlich() { 
        return maennlich; 
    }

    public void setMaennlich(boolean maennlich) { 
        this.maennlich = maennlich; 
    }

    public boolean hasFuehrerschein() { 
        return fuehrerschein; 
    }
    
    public void setFuehrerschein(boolean fuehrerschein) { 
        this.fuehrerschein = fuehrerschein; 
    }

    public int getGewicht() { 
        return gewicht; 
    }
    
    public void setGewicht(int gewicht) { 
        if (gewicht >= 30 && gewicht <= 150) {
            this.gewicht = gewicht; 
        } else {
            System.out.println("FEHLER: ungueltiges Gewicht: " + gewicht);
        }
    }

    public String toString() {
        String geschlecht = maennlich ? "m" : "w";
        return name + " (" + geschlecht + "), Gewicht: " + gewicht + " kg";
    }
}
