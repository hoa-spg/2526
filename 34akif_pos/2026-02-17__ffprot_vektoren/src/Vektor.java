public class Vektor {

    private int[] v;

    public Vektor(int dim) {
        if (dim > 1) {
            v = new int[dim];
        } else {
            System.out.println("Fehler: ungueltige Dimension " + dim);
        }
    }
    
    public int dim() {
        return v.length;
    }
    
    public void set(int idx, int wert) {
        if (idx >= 0 && idx < v.length) {
            v[idx] = wert;
        } else {
            System.out.println("Fehler: ungueltiger Index " + idx);
        }
    }
    
    public int get(int idx) {
        int wert = 0;
        if (idx >= 0 && idx < v.length) {
            wert = v[idx];
        } else {
            System.out.println("Fehler: ungueltiger Index " + idx);
        }
        return wert;
    }
    
    public int mult(Vektor other) {
        int erg = 0;
        if (other != null) {
            if (this.dim() == other.dim()) {
                for (int i=0; i<v.length; i++) {
                    erg += this.get(i) * other.get(i);
                }
            } else {
                System.out.println("Fehler, dimension ungleich");
            }
        } else {
            System.out.println("Fehler, parameter other ist null");
        }
        return erg;
    }
    
    public Vektor add(Vektor other) {
        Vektor erg = null;
        if (other != null) {
            if (this.dim() == other.dim()) {
                erg = new Vektor(this.dim());
                for (int i=0; i<v.length; i++) {
                    erg.set(i, this.get(i) + other.get(i));
                }
            } else {
                System.out.println("Fehler, dimension ungleich");
            }
        } else {
            System.out.println("Fehler, parameter other ist null");
        }
        return erg;
    }
    
    public String toString() {
        String str = "[";
        for (int i=0; i<v.length; i++) {
            if (i > 0) {
                str += ", ";
            }
            str += v[i];
        }
        str += "]";
        return str;
    }
    
}
