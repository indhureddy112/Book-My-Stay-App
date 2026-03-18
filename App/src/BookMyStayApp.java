import java.util.LinkedList;
import java.util.Queue;
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class RoomInventory {
    String roomType;
    int availableRooms;
    int roomCounter = 1;

    public RoomInventory(String roomType, int availableRooms) {
        this.roomType = roomType;
        this.availableRooms = availableRooms;
    }

    // Allocate room
    public String allocateRoom() {
        if (availableRooms > 0) {
            String roomId = roomType + "-" + roomCounter;
            roomCounter++;
            availableRooms--;
            return roomId;
        }
        return null;
    }
}


public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        RoomInventory single = new RoomInventory("Single", 5);
        RoomInventory dbl = new RoomInventory("Double", 3);
        RoomInventory suite = new RoomInventory("Suite", 2);


        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.poll();
            String roomId = null;

            if (r.roomType.equalsIgnoreCase("Single")) {
                roomId = single.allocateRoom();
            } else if (r.roomType.equalsIgnoreCase("Double")) {
                roomId = dbl.allocateRoom();
            } else if (r.roomType.equalsIgnoreCase("Suite")) {
                roomId = suite.allocateRoom();
            }

            if (roomId != null) {
                System.out.println("Booking confirmed for Guest: "
                        + r.guestName + ", Room ID: " + roomId);
            } else {
                System.out.println("No rooms available for Guest: " + r.guestName);
            }
        }
    }
}