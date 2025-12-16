
public class Mitarbeiter
{
    private String name;
    private int gehalt;

    //konstruktoren
    public Mitarbeiter(){
        // String name = "n/a";
        // int gehalt = 2000;
        setName("n/a");
        setGehalt(2000);
    }

    public Mitarbeiter(String name, int gehalt){
        setName(name);
        setGehalt(gehalt);
    }

    //Getter,Setter
    public String getName(){
        return name;
    }

    public void setName(String name){
        if (name!=null && !name.isBlank()){
            this.name = name;
        }else{
            System.out.println("FEHLER: ungultige name");
        }
    }

    public int getGehalt(){
        return gehalt;
    }

    public void setGehalt(int gehalt){
        if (gehalt >= 2000 && gehalt <= 5000){
            this.gehalt = gehalt;
        }else{
            System.out.println("FEHLER: Gehalt nicht imgultigem Bereich");
        }
    }

    public String toString(){
        String str = "";
        return name + "("+ gehalt + "Euro)";
    }
}
