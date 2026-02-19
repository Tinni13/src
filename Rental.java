package src;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rental {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Station originStation;
    private Station destinationStation;
    private Vehicle vehicle;
    private User user;
    private double totalCost;

    private static final double PRICE_PER_MINUTE = 0.5;

    //
    public Rental(User user, Vehicle vehicle, Station originStation){
        this.user = user;
        this.vehicle = vehicle;
        this.originStation = originStation;
        this.startTime = LocalDateTime.now();
    }
    //
    public void endRental(Station destination){
        this.endDateTime = LocalDateTime.now();
        this.destinationStation = destination;
        vehicle.endUse();
        destination.addVehicle(vehicle);
        totalCost = calculateCost();
    }
    //
    public double calculateCost(){
        long minutes = Duration.between(startTime, endTime).toMinutes();
        return minutes * PRICE_PER_MINUTE;
    }
    //
    public double getTotalCost(){
        return totalCost;
    }
}
