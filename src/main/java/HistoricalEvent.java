import java.util.ArrayList;

public class HistoricalEvent extends EventNarrator {
    public static void sorting(Event event){
        ArrayList<Event> plannedEvents = new ArrayList<>();
        plannedEvents.add(event);
        for (Event singleEvent: plannedEvents) {
            System.out.println("-----------------------");
            System.out.println("HISTORICAL");
            System.out.println("-----------------------");
            System.out.println(singleEvent.getEventInput());
            System.out.println(singleEvent.getEventDate());
        }
    }
}
