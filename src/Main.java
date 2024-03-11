import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System .in) ;
        System. out. println("Enter event ID:");
        String eventID = scanner . nextLine();

        System. out. println("Enter event name:");
        String eventName = scanner . nextLine() ;
    
        System. out . println("Enter event venue:");
        String eventVenue = scanner.nextLine(); 
    
        System. out. println("Enter event date (yyyy-MM-dd):");
        String dateString = scanner . nextLine() ;
        LocalDate eventDate=LocalDate. parse( dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        Event event = new Event(eventID, eventName, eventVenue,eventDate);
        boolean running = true ;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1 - Add attendee");
            System. out. println("2 - Remove attendee");
            System. out. println("3 - Update attendee" );
            System. out. println("4 - Find attendee" );
            System. out . println("5 - Organize event");
            System. out . println("0 - Exit" );
            int choice = scanner . nextInt() ;
            scanner. nextLine();

    switch (choice) { 
        case 1:
            System.out.println("Enter attendee name:");
            String attendeeName = scanner . nextLine();
            event . addAttendee(new Attendee(attendeeName));
            break;
        case 2:
            System. out.println("Enter attendee name to remove:" );
            String attendeeToRemove = scanner. nextLine();
            event.removeAttendee(new Attendee(attendeeToRemove));
            break;
        case 3:
            System.out .println("Enter old attendee name: ");
            String oldName=scanner .nextLine();
            System . out.println("Enter new attendee name: ") ;
            String newName = scanner .nextLine();
        if (event.updateattendee(oldName, new Attendee(newName))) { 
                    System. out . println("Attendee updated.");
        }else{
            System. out . println("Attendee not found.");
        }
        break ;
        case 4:
            System. out . println("Enter attendee name to find:");
            String nameToFind = scanner .nextLine( );
        if (event. findAttendee(nameToFind)) {
            System . out . println(" Attendee found. ");
        }else {
            System.out . println("Attendee not found.");
        }
        break;
    case 5 :
        event . organizeEvent();
        break;
    case 0:
        running = false;
        break;
    default:
        System.out.println("Invalid option.");
        break;
    }
    }
    scanner.close();
}
}