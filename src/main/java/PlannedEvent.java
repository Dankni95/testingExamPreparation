import java.util.ArrayList;

public class PlannedEvent extends EventNarrator{
    public static void sorted(Event event){
        ArrayList<Event> plannedEvents = new ArrayList<>();
        plannedEvents.add(event);
        for (Event singleEvent: plannedEvents) {
            System.out.println("-----------------------");
            System.out.println("PLANNED");
            System.out.println("-----------------------");
            System.out.println(singleEvent.getEventInput());
            System.out.println(singleEvent.getEventDate());
        }
    }
}
