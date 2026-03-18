import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Validator Class
class BookingValidator {

    // Validate room type
    public static void validateRoomType(String roomType) throws InvalidBookingException {

        if (!(roomType.equals("single") ||
                roomType.equals("double") ||
                roomType.equals("suite"))) {

            throw new InvalidBookingException("Invalid room type selected");
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Booking Validation");

            System.out.print("Enter guest name: ");
            String guestName = sc.nextLine();

            System.out.print("Enter room type (single/double/suite): ");
            String roomType = sc.nextLine();

            // Validate input
            BookingValidator.validateRoomType(roomType);

            // If valid (not required in your output, but good practice)
            System.out.println("Booking Successful for " + guestName);

        } catch (InvalidBookingException e) {

            // Graceful failure handling
            System.out.println("Booking Failed: " + e.getMessage());
        }

        sc.close();
    }
}