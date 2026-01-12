
public class Computer {

    private String name;
    private int speicher;
    private boolean ssd;

    public Computer() {
        setName("n/a");
        setSpeicher(500);
        setSsd(false);
    }

    public Computer(String name, int speicher, boolean ssd) {
        setName(name);
        setSpeicher(speicher);
        setSsd(ssd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isBlank()){
            this.name = name;
        }else{
            System.out.println("Fehler");
        }
    }

    public int getSpeicher() {
        return speicher;
    }

    public void setSpeicher(int speicher) {
        if(speicher >= 100 && speicher <= 2000){
            this.speicher = speicher;
        }else{
            System.out.println("muss zwischen 100 und 2000 sein");
        }
    }

    public boolean hasSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    public String toString() {
        String str = this.name + ", ";
        str += hasSsd() ? "SSD: " : "HDD: ";
        str += getSpeicher() + " GB";
        return str;
    }

    public void printComputer() {
        System.out.println(this);
    }
}
