import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestEvent {
    String eventInput;
    String eventDate;
    Event input;
    LocalDate mockNowDateBefore;
    LocalDate mockNowDateAfter;



    @Test
    @BeforeEach
    public void setup(){
        eventInput = "Testing testing";
        eventDate = "2021-04-09";
         input = new Event(eventInput, eventDate);
         mockNowDateBefore = LocalDate.parse("2020-01-01");
        mockNowDateAfter = LocalDate.parse("2220-10-11");
    }

    @Test
    public void AssertEventCreatedCorrectly() {

        assertAll("Should return correct details",
                () -> assertEquals("2021-04-09", input.getEventDate().toString()),
                () -> assertEquals("Testing testing", input.getEventInput())
        );
    }

    @Test
    public void AssertInputSetterWorksCorrectly() {
        String setterTest = "Setter works";
        input.setEventInput(setterTest);
        assertEquals("Setter works",input.getEventInput());
    }

    static class TestTime extends TestEvent{
        @Test
        public void AssertDayDifferenceReturnRightData() {

            Event secondEvent = new Event("Clean the room","2020-04-01");
            int eventDateDiffAfterObjectOne = (int) Date.compareEventDate(mockNowDateAfter,input.getEventDate());
            int eventDateDiffAfterObjectTwo = (int) Date.compareEventDate(mockNowDateAfter,secondEvent.getEventDate());
            int eventDateDiffBeforeObjectOne = (int) Date.compareEventDate(mockNowDateBefore,input.getEventDate());
            int eventDateDiffBeforeObjectTwo = (int) Date.compareEventDate(mockNowDateBefore,secondEvent.getEventDate());
            assertAll("Mock LocalDate.now(), the dates are never changing, program use real now()",
                    () -> assertEquals(Integer.valueOf(-72868), eventDateDiffAfterObjectOne ),
                    () -> assertEquals(Integer.valueOf(-73241),  eventDateDiffAfterObjectTwo),
                    () -> assertEquals(Integer.valueOf(464), eventDateDiffBeforeObjectOne ),
                    () -> assertEquals(Integer.valueOf(91), eventDateDiffBeforeObjectTwo )
            );
            EventNarrator.sortHistoricalOrPlanned(secondEvent);
            EventNarrator.sortHistoricalOrPlanned(input);
        }
        @Test
        public void AssertFalseIfHistoricalAndTrueWhenPlanned(){
            Event secondEvent = new Event("Clean the room","2020-04-01");
            //past .. to Historic
            assertTrue(Date.isEventHistoricOrPlanned(mockNowDateBefore,input.getEventDate()));
            //future .. to Planned
            assertFalse(Date.isEventHistoricOrPlanned(mockNowDateAfter,secondEvent.getEventDate()));
        }
    }
}
