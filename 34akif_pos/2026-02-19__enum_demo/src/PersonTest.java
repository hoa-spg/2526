public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("Anna");
        p1.setGeschlecht(Person.Geschlecht.WEIBILICH);

        Person p2 = new Person("Ben");
        p2.setGeschlecht(Person.Geschlecht.MAENNLICH);

        Person p3 = new Person("Chris");
        p3.setGeschlecht(Person.Geschlecht.DIVERS);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}

