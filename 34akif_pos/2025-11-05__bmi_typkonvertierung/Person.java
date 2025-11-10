public class Person {
    private String name;
    private boolean maennlich; 
    private int groesse; // in cm
    private int gewicht; // in kg

    public Person() {
        setName("Azra");
        setMaennlich(false);
        setGroesse(170);
        setGewicht(60);
    }

    public Person(String name, boolean maennlich, int groesse, int gewicht) {
        setName(name);
        setMaennlich(maennlich);
        setGroesse(groesse);
        setGewicht(gewicht);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Fehler: Name darf nicht null oder leer sein!");
        }
    }

    public boolean isMaennlich() {
        return maennlich;
    }

    public void setMaennlich(boolean maennlich) {
        this.maennlich = maennlich;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        if (groesse >= 110 && groesse <= 220) {
            this.groesse = groesse;
        } else {
            System.out.println("Fehler: Größe muss zwischen 110 und 220 cm liegen!");
        }
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        if (gewicht >= 30 && gewicht <= 150) {
            this.gewicht = gewicht;
        } else {
            System.out.println("Fehler: Gewicht muss zwischen 30 und 150 kg liegen!");
        }
    }
    
    public double bmiBerechnen() {
        // double groesseInM = (double)groesse/100;
        double groesseInM = groesse/100.0;
        return gewicht/(groesseInM*groesseInM);
    }

    public void bmiAusgeben() {
        System.out.println(this);
        double bmi = bmiBerechnen();
        System.out.print("BMI: " + bmi + ", ");
        if (maennlich) {
            if (bmi < 20) {
                System.out.println("Untergewicht");
            } else { // bmi >= 20
                if (bmi < 25) {
                    System.out.println("Normalgewicht");
                } else {
                    System.out.println("Uebergewicht");
                }
            }
        } else {
            if (bmi < 19) {
                System.out.println("Untergewicht");
            } else if (bmi < 24) {
                System.out.println("Normalewicht");
            } else {
                System.out.println("Uebergewicht");
            }
        
        }
    }
    
    public String toString() {
        return "Name='" + name + '\'' +
                ", Geschlecht=" + (maennlich ? "männlich" : "weiblich") +
                ", Größe=" + groesse + " cm" +
                ", Gewicht=" + gewicht + " kg";
    }


    public void print() {
        System.out.println(this);
    }

 
}
