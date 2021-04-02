import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class Date{
    private static LocalDate localDateEventDate;


    public static void setEventDate(String eventDate){
         localDateEventDate = LocalDate.parse(eventDate);
    }
    public static long compareEventDate(LocalDate now, LocalDate eventDate) {
        return ChronoUnit.DAYS.between( now , eventDate );
    }

    public static boolean isEventHistoricOrPlanned(LocalDate now, LocalDate localDateEventDate){
        int result = now.compareTo(localDateEventDate);
        return 0 > result;
    }

    public static LocalDate getLocalDate() {
        return localDateEventDate;
    }

}
