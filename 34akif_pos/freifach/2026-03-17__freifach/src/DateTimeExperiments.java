import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateTimeExperiments {

    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(1972, 4, 27);
        System.out.println(ld);
        DayOfWeek dow = ld.getDayOfWeek();
        System.out.println(dow);
        boolean ly = ld.isLeapYear();
    }
}
