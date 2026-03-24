public class B extends A {

    public B(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        String str = "B: x=" + getX() + " y=" + y;
        return str;
    }
}
