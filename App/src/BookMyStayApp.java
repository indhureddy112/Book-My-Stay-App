import java.util.LinkedList;
import java.util.Queue;

// Reservation class (represents booking request)
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

// Booking Queue class (FIFO handling)
class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
    }

    // Check if queue has requests
    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }

    // Process next request (FIFO)
    public Reservation getNextRequest() {
        return queue.poll();
    }
}

// Main class
public class BookMyStayApp {
    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Add booking requests (arrival order)
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        System.out.println("Booking Request Queue");

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation request = bookingQueue.getNextRequest();

            System.out.println("Processing booking for Guest: "
                    + request.getGuestName()
                    + ", Room Type: "
                    + request.getRoomType());
        }
    }
}