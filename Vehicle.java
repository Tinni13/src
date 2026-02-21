public class Vehicle {
    private String id;
    private VehicleType type;
    private VehicleStatus status;
    private int batteryLevel;

    public Vehicle(String id, VehicleType type, int batteryLevel) {
        this.id = id;
        this.type = type;
        this.batteryLevel = batteryLevel;
        this.status = VehicleStatus.AVAILABLE;
    }

    // Change the usage status
    public void startUse() { this.status = VehicleStatus.IN_USE; }

    // change the available status to available upon delivery
    public void endUse() { this.status = VehicleStatus.AVAILABLE; }

    // Shipped for repair 
    public void sendToMaintenance() { this.status = VehicleStatus.IN_MAINTENANCE; }

    // Getters needed for business logic
    public VehicleStatus getStatus() { return status; }
    public boolean isAvailable() { return status == VehicleStatus.AVAILABLE; }
}