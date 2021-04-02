import java.time.LocalDate;

public class Event {
    String eventInput;
    LocalDate eventDate;



    public Event(String eventInput, String eventDate) {
        this.eventInput = eventInput;
        Date.setEventDate(eventDate);
        this.eventDate = Date.getLocalDate();
    }
    public String getEventInput() {
        return eventInput;
    }

    public void setEventInput(String eventInput) {
        this.eventInput = eventInput;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

}
