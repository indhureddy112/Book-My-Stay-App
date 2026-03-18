import java.util.*;

// Booking Record
class Reservation {
    String reservationId;
    String roomType;

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
    }
}

// Cancellation Service
class CancellationService {

    // Inventory (roomType -> count)
    private Map<String, Integer> inventory = new HashMap<>();

    // Active bookings (reservationId -> Reservation)
    private Map<String, Reservation> bookings = new HashMap<>();

    // Rollback stack (LIFO)
    private Stack<String> rollbackStack = new Stack<>();

    // Initialize inventory
    public CancellationService() {
        inventory.put("single", 5);
        inventory.put("double", 3);
        inventory.put("suite", 2);

        // Pre-existing booking (simulate confirmed booking)
        bookings.put("single-1", new Reservation("single-1", "single"));
    }

    // Cancel booking
    public void cancelBooking(String reservationId) {

        System.out.println("Booking Cancellation");

        // Validation
        if (!bookings.containsKey(reservationId)) {
            System.out.println("Invalid reservation. Cannot cancel.");
            return;
        }

        Reservation res = bookings.get(reservationId);

        // Remove booking
        bookings.remove(reservationId);

        // Restore inventory
        String roomType = res.roomType;
        inventory.put(roomType, inventory.get(roomType) + 1);

        // Push to rollback stack
        rollbackStack.push(reservationId);

        // Output
        System.out.println("Booking cancelled successfully.");
        System.out.println("Inventory restored for room type: " + roomType);

        System.out.println("Rollback History (most recent first):");
        System.out.println("Released Reservation ID: " + rollbackStack.peek());

        System.out.println("Updated " + roomType + " room availability: "
                + inventory.get(roomType));
    }
}

// Main Class
public class UseCase10BookingCancellation {
    public static void main(String[] args) {

        CancellationService service = new CancellationService();

        // Cancel booking
        service.cancelBooking("single-1");
    }
}