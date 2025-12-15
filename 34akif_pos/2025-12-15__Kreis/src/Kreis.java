public class Kreis {

    private int radius;

    public Kreis() {
        setRadius(18);
    }

    public Kreis(int radius) {
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Fehler, ungueltiger Radius " + radius);
        }
    }

    public void zeichnen() {
        for (int y = -radius; y <= radius; y++) {
            for (int x = -radius; x <= radius; x++) {
                double d = Math.sqrt(x*x + y*y);
                if (d <= radius) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Kreis: " + radius;
    }

    public void print() {
        System.out.println(this);
    }
}