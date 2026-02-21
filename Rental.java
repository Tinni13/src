import java.time.Duration;
import java.time.LocalDateTime;

// class that manages the transaction and rental metrics
public class Rental {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Station originStation;
    private Station destinationStation;
    private Vehicle vehicle;
    private User user;
    private double totalCost;

    private static final double PRICE_PER_MINUTE = 0.5; 

    // records the beginning of the rental and the initial data
    public Rental(User user, Vehicle vehicle, Station originStation) {
        this.user = user;
        this.vehicle = vehicle;
        this.originStation = originStation;
        this.startDateTime = LocalDateTime.now(); 
    }

    // the rental ends, calculates the cost and releases the vehicle in the new station
    public void endRental(Station destination) {
        if (destination.isFull()) {
            System.out.println("Error: Estación de destino llena.");
            return;
        }
        this.endDateTime = LocalDateTime.now();
        this.destinationStation = destination;
        
        vehicle.endUse(); 
        destination.addVehicle(vehicle); 
        this.totalCost = calculateCost(); 
    }

    // calculates the cost besed on the duration between the beginning and the end
    public double calculateCost() {
        if (endDateTime == null) return 0;
        // calculate the difference in minutes
        long minutes = Duration.between(startDateTime, endDateTime).toMinutes();
        // minimun charge of 1 minute to avoid costs of $0 in rapid tests
        if (minutes <= 0) minutes = 1; 
        return minutes * PRICE_PER_MINUTE;
    }

    // getters to access rental information 
    public double getTotalCost() { return totalCost; }
    public LocalDateTime getStartTime() { return startDateTime; }
    public LocalDateTime getEndTime() { return endDateTime; }
}