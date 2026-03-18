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

class RoomInventory {
    Room room;
    int availableRooms;

    public RoomInventory(Room room, int availableRooms) {
        this.room = room;
        this.availableRooms = availableRooms;
    }

    public void displayInventory(String roomType) {
        System.out.println(roomType + ":");
        room.displayRoomDetails();
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        RoomInventory single = new RoomInventory(new SingleRoom(), 5);
        RoomInventory dbl = new RoomInventory(new DoubleRoom(), 3);
        RoomInventory suite = new RoomInventory(new SuiteRoom(), 2);

        single.displayInventory("Single Room");
        dbl.displayInventory("Double Room");
        suite.displayInventory("Suite Room");
    }
}