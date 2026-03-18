import java.util.*;

// Service class
class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Add-On Service Manager
class AddOnServiceManager {

    private Map<String, List<Service>> serviceMap = new HashMap<>();

    public void addService(String reservationId, Service service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);
    }

    public void displayTotalCost(String reservationId) {

        double total = 0;

        List<Service> services = serviceMap.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.getPrice();
            }
        }

        System.out.println("Add-On Service Selection");
        System.out.println("Registration ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + total);
    }
}

// Main Class
public class BookMyStayApp{
    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        // Example: Single-1 reservation
        String reservationId = "Single-1";

        // Add services (total = 1500.0)
        manager.addService(reservationId, new Service("Breakfast", 500.0));
        manager.addService(reservationId, new Service("WiFi", 1000.0));

        // Display result
        manager.displayTotalCost(reservationId);
    }
}