import java.util.*;

// Reservation class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Booking History (stores confirmed bookings)
class BookingHistory {
    private List<Reservation> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    // Add confirmed booking
    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    // Get all reservations
    public List<Reservation> getReservations() {
        return reservations;
    }
}

// Reporting Service
class BookingReportService {
    public void generateReport(List<Reservation> reservations) {
        System.out.println("Booking History Report");
        for (Reservation r : reservations) {
            System.out.println("Guest: " + r.getGuestName() + ", Room Type: " + r.getRoomType());
        }
    }
}

// Main class
public class BookMyStayApp {
    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Simulating confirmed bookings
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));

        // Generate report
        System.out.println("Booking History and Reporting\n");
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history.getReservations());
    }
}