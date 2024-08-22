import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate d3 = LocalDate.parse("28/07/2022", f1);
        LocalDate d2 = LocalDate.parse("2022-07-28");
        
        System.out.println(d2.format(f1));
        System.out.println(d3);
    }
}
