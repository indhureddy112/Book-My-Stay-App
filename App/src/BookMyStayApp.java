abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

// Room Types
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

// Inventory (State Holder)
class RoomInventory {
    Room room;
    int availableRooms;

    public RoomInventory(Room room, int availableRooms) {
        this.room = room;
        this.availableRooms = availableRooms;
    }
}

// Search Service (READ-ONLY)
class RoomSearchService {

    public static void searchRooms(RoomInventory[] inventoryList) {

        System.out.println("Room Search\n");

        for (RoomInventory inv : inventoryList) {

            // Only show available rooms (validation)
            if (inv.availableRooms > 0) {

                if (inv.room instanceof SingleRoom) {
                    System.out.println("Single Room:");
                } else if (inv.room instanceof DoubleRoom) {
                    System.out.println("Double Room:");
                } else if (inv.room instanceof SuiteRoom) {
                    System.out.println("Suite Room:");
                }

                inv.room.displayRoomDetails();
                System.out.println("Available: " + inv.availableRooms);
                System.out.println();
            }
        }
    }
}

// Main Class
public class BookMyStayApp{
    public static void main(String[] args) {

        // Centralized inventory (same as Use Case 3)
        RoomInventory[] inventory = {
                new RoomInventory(new SingleRoom(), 5),
                new RoomInventory(new DoubleRoom(), 3),
                new RoomInventory(new SuiteRoom(), 2)
        };

        // Perform search (READ ONLY)
        RoomSearchService.searchRooms(inventory);
    }
}