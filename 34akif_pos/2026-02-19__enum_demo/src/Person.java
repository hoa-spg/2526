public class Person {

    public enum Geschlecht { MAENNLICH, WEIBILICH, DIVERS }

    private String name;
    private Geschlecht geschlecht;

    public Person(String name) {
        this.name = name;
        this.geschlecht = Geschlecht.WEIBILICH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    @Override
    public String toString() {
        String str = name;
        switch (this.geschlecht) {
            case MAENNLICH:
                str += " (m)";
                break;
            case WEIBILICH:
                str += " (w)";
                break;
            case DIVERS:
                str += " (d)";
                break;
            default:
                System.out.println("FEHLER: das Unmoegliche ist passiert ;-)");
        }
        return str;
    }
}
