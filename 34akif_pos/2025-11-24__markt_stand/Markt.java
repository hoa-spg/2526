public class Markt {
    
    private String name;
    private String stadt;
    private Stand pos1;
    private Stand pos2;
    private Stand pos3;
    private Stand pos4;

    public Markt() {
        setName("Heumarkt");
        setStadt("Wien");
    }

    public Markt(String name, String stadt) {
        setName(name);
        setStadt(stadt);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStadt(String stadt) {
        if (stadt != null) {
            this.stadt = stadt;
        } else {
            System.out.println("FEHLER: ungueltige Stadt");
        }
    }

    public String GetStadt(){
        return stadt;
    }

    public boolean standHinzufugen(Stand neu){
        if (neu == null) {
            System.out.println("FEHLER: neuer Stand ist null.");
            return false;
        } 
            
        if (neu.isEssen() && this.anzahlEssenStende() > 0) {
            System.out.println("FEHLER: keine weiteren Essensstaende moeglich.");
            return false;
        }
        
        if (pos1 == null) {
            pos1 = neu;
            return true;
        } else if (pos2 == null) {
            pos2 = neu;
            return true;
        } else if (pos3 == null) {
            pos3 = neu;
            return true;
        } else if (pos4 == null) {
            pos4 = neu;
            return true;
        }
        System.err.println("Fehler: Kein freien Platz vorhanden");
        return false;
        
    }
    
    public Stand standEntfernen(String name) {
        if (name == null) {
            System.out.println("FEHLER: name ist null");
            return null;
        }
        
        // name != null
        Stand entfernterStand = null; 
        if (pos1 != null && pos1.getName().equals(name)) {
            entfernterStand = pos1;
            pos1 = null;        
        } else if (pos2 != null && pos2.getName().equals(name)) {
            entfernterStand = pos2;
            pos2 = null;        
        } else if (pos3 != null && pos3.getName().equals(name)) {
            entfernterStand = pos3;
            pos3 = null;
        } else if (pos4 != null && pos4.getName().equals(name)) {
            entfernterStand = pos4;
            pos4 = null;            
        }
        return entfernterStand;
    }

    public int anzahlStaende(){
        int anzahl = 0;
        if(pos1 != null){
            anzahl++;
        }
        if(pos2 != null){
            anzahl++;
        }
        if(pos3 != null){
            anzahl++;
        }
        if(pos4 != null){
            anzahl++;
        }
        return anzahl;
    }

    public int anzahlEssenStende(){
        int essenStand = 0;
        if(pos1 != null && pos1.isEssen()){
            essenStand++;
        }
        if(pos2 != null && pos2.isEssen()){
            essenStand++;
        }
        if(pos3 != null && pos3.isEssen()){
            essenStand++;
        }
        if(pos4 != null && pos4.isEssen()){
            essenStand++;
        }
        return essenStand;
    }

    public int anzahlFreiePlaetze(){
        int freiePlaetze = 0;
        if(pos1 == null){
            freiePlaetze++;
        }
        if(pos2 == null){
            freiePlaetze++;
        }
        if(pos3 == null){
            freiePlaetze++;
        }
        if(pos4 == null){
            freiePlaetze++;
        }
        return freiePlaetze;
    }

    public String toString(){
        String str = "Name: " + name + "\n";
        str += "Stadt: " + stadt + "\n";
        str += "--------------------------------------\n";
        str += "Stand 1: " + ((pos1 != null) ? pos1 : " -- leer -- ") + "\n";
        str += "Stand 2: " + ((pos2 != null) ? pos2 : " -- leer -- ") + "\n";
        str += "Stand 3: " + ((pos3 != null) ? pos3 : " -- leer -- ") + "\n";
        str += "Stand 4: " + ((pos4 != null) ? pos4 : " -- leer -- ") + "\n";
        str += "--------------------------------------\n";
        return str;
    }

    public void print(){
        System.out.print(this);
    }
}