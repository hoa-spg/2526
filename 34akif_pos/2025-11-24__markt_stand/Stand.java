public class Stand{
    private String name;
    private boolean essen;

    public Stand() {
        setName("n/a");
        setEssen(false);
    }

    public Stand(String name, boolean essen) {
        setName(name);
        setEssen(essen);
    }

    public void setName(String name) {
        if(name != null && !name.isBlank()){
            this.name = name;
        }else{
            System.out.println("really? did u left the name empty?");
        }
    }

    public String getName() {
        return name;
    }

    public void setEssen(boolean essen) {
        this.essen = essen;
    }

    public boolean isEssen() {
        return essen;
    }

    public String toString() {
        String str = null;
        if (essen) {
            str = name + " (Essensstand)";
        } else {
            str = name + " (Marktstand)";
        }
        return str;
    }

    public void print() {
        System.out.println(this);
    }
}