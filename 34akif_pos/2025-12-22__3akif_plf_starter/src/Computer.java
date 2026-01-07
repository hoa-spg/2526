public class Computer {
    private String name;
    private int speicher;
    private boolean ssd;

    public Computer() {
        // TODO
    }

    public Computer(String name, int speicher, boolean ssd) {
        // TODO
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // TODO
        this.name = name;
    }

    public int getSpeicher() {
        return speicher;
    }

    public void setSpeicher(int speicher) {
        // TODO
        this.speicher = speicher;
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
