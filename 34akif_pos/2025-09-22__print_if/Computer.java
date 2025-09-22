public class Computer {
    
    private String modell;
    private double taktFrequenz; // [GHz]
    private boolean notebook;
    private int speicher; // [GB]
    
    public Computer() {
        setModell("Acer");
        setTaktFrequenz(1.9);
        setNotebook(true);
        setSpeicher(500);        
    }
    
    public Computer(String neuModell, double neuTaktfrequenz, 
                    boolean neuNotebook, int neuSpeicher) 
    {
        setModell(neuModell);
        setTaktFrequenz(neuTaktfrequenz);
        setNotebook(neuNotebook);
        setSpeicher(neuSpeicher);
    }
    
    public String getModell() {
        return modell;
    }
    
    public void setModell(String neuesModell) {
        modell = neuesModell;
    }
    
    public double getTaktFrequenz() {
        return taktFrequenz;
    }
    
    public void setTaktFrequenz(double neueTaktFrequenz) {
        taktFrequenz = neueTaktFrequenz;
    }
    
    // boolesche setter: is... has...
    public boolean isNotebook() {
        return notebook;
    }
    
    public void setNotebook(boolean neuNotebook) {
        notebook = neuNotebook;
    }
    
    public int getSpeicher() {
        return speicher;
    }
    
    public void setSpeicher(int neuSpeicher) {
        speicher = neuSpeicher;
    }
    
    public void printComputer() {
        if (notebook) {
            System.out.println("NOTEBOOK: Modell: " + modell + ", " + taktFrequenz + " GHz " + speicher + " GB HDD/SDD"); 
        } else {
            System.out.println("DESKTOP: Modell: " + modell + ", " + taktFrequenz + " GHz " + speicher + " GB HDD/SDD"); 
        }
    }
    
}
