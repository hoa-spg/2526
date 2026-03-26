import java.util.Objects;

public abstract class Immobilie {

    private String adresse;
    private int wert;

    public Immobilie() {
        this.adresse = "n/a";
        this.wert = 0;
    }

    public Immobilie(String adresse, int wert) throws ImmobilienException {
        setAdresse(adresse);
        setWert(wert);
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) throws ImmobilienException {
        if (adresse != null && !adresse.isBlank()) {
            this.adresse = adresse;
        } else {
            throw new ImmobilienException("Parameter adresse ist null oder leer.");
        }
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) throws ImmobilienException {
        if (wert >= 0) {
            this.wert = wert;
        } else {
            throw new ImmobilienException("Ungueltiger Parameter wert: " + wert);
        }
    }

    public int gesamtWert() {
        return wert;
    }

    public int maklerProvision() {
        return (int)Math.ceil(0.01 * wert);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Immobilie immobilie = (Immobilie) o;
        return wert == immobilie.wert && Objects.equals(adresse, immobilie.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresse, wert);
    }

    @Override
    public String toString() {
        String str = "Adresse: " + adresse + ", Wert: " + wert;
        return str;
    }
}
