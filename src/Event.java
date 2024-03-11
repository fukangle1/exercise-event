import java.time.LocalDate;
import java.util.ArrayList;

public class Event{
        private String eventID;
        private String eventName;
        private String eventVenue;
        private LocalDate eventDate;
        private ArrayList<Attendee> eventAttendees;
    
    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName= eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>(); 
    }
    
    public void addAttendee(Attendee newattendee) {
        eventAttendees . add(newattendee);
    }
    public void removeAttendee(Attendee attendee) {
        ArrayList<Attendee> eyentAttendees;
        eventAttendees.removeIf(a -> a. getName() .equals(attendee.getName()));
    } 
    public boolean updateattendee(String oldName, Attendee newAttendee){
        for (int i =0;i<eventAttendees.size(); i++) {
            Attendee attendee = eventAttendees .get(i);
        if (attendee. getName(). equals(oldName)) {
            eventAttendees .set(i, newAttendee);
            return true ;
        }
        }
        return false;
    }
        public boolean findAttendee(String name) {
            return eventAttendees . stream( ) . anyMatch(a -> a. getName() . equals(name));
        }
        public void organizeEvent() {
            System. out . println("Organizing event: "+ this);
            System.out. println("Total number of attendees: "+ eventAttendees. size());
        }
    @Override
        public String toString() {
            StringBuilder sb =new StringBuilder();
            sb. append(" Event{" +
                            "eventID='").append(eventID).append('\'')
                            .append(",eventName='").append(eventName).append('\'')
                            .append(",eventVenue='").append(eventVenue).append('\'')
                            .append(",eventDate='").append(eventDate).append('\'')
                            .append(",eventAttendees=[");
            eventAttendees.forEach(a->sb.append(a.getName()).append(", "));
            if(!eventAttendees.isEmpty()){
                sb.setLength(sb.length()-2);
            }
            sb.append(("]}"));
            return sb.toString();
        }
    }