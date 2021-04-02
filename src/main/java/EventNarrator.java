import java.time.LocalDate;

public class EventNarrator {

    public static void sortHistoricalOrPlanned(Event event){
        if (Date.isEventHistoricOrPlanned(LocalDate.now(),event.getEventDate())) HistoricalEvent.sorting(event);
        else PlannedEvent.sorted(event);
    }
}
