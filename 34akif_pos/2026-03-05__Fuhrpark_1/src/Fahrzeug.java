import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Fahrzeug {

    private String bezeichnung;
    private LocalDate erstZulassung;
    private int neupreis;

    public Fahrzeug() {
        setBezeichnung("n/a");
        setErstZulassung(LocalDate.of(2000, 12, 31));
        setNeupreis(30_000);
    }

    public Fahrzeug(String bezeichnung, LocalDate erstZulassung, int neupreis) {
        setBezeichnung(bezeichnung);
        setErstZulassung(erstZulassung);
        setNeupreis(neupreis);
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        if (bezeichnung != null && !bezeichnung.isBlank()) {
            this.bezeichnung = bezeichnung;
        } else {
            System.out.println("Fehler: ungueltige Bezeichnung.");
        }
    }

    public LocalDate getErstZulassung() {
        return erstZulassung;
    }

    public void setErstZulassung(LocalDate erstZulassung) {
        if (erstZulassung != null) {
            if (erstZulassung.isBefore(LocalDate.now())) {
                this.erstZulassung = erstZulassung;
            } else {
                System.out.println("Fehler: erstZulassung kann nicht in der Zukunft liegen.");
            }
        } else {
            System.out.println("Fehler: erstZulassung ist null.");
        }
    }

    public int getNeupreis() {
        return neupreis;
    }

    public void setNeupreis(int neupreis) {
        if (neupreis > 0) {
            this.neupreis = neupreis;
        } else {
            System.out.println("Fehler: ungueltiger Neupreis (kann nicht negativ oder 0 sein).");
        }
    }

    public int alter() {
        return LocalDate.now().getYear() - this.erstZulassung.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fahrzeug fahrzeug = (Fahrzeug) o;
        return neupreis == fahrzeug.neupreis && Objects.equals(bezeichnung, fahrzeug.bezeichnung) && Objects.equals(erstZulassung, fahrzeug.erstZulassung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bezeichnung, erstZulassung, neupreis);
    }

    @Override
    public String toString() {
        return bezeichnung + " (EZ: "
                + erstZulassung.format(DateTimeFormatter.ISO_DATE)
                + "), NP: " + neupreis + ", Alter: " + alter() + " Jahre";
    }
}
