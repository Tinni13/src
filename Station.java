import java.util.ArrayList;
import java.util.List;

public class Station {
    private String id;
    private String location;
    private int capacity;
    private List<Vehicle> vehicles;

    public Station(String id, String location, int capacity) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(); 
    }

    // method to obtain the location 
    public String getLocation() {
        return location;
    }

    // add a vehicle if the station has not reached its maximun capacity
    public boolean addVehicle(Vehicle v) {
        if (vehicles.size() < capacity) {
            vehicles.add(v);
            return true;
        }
        return false; 
    }

    // remove a vehicle when someone rents it
    public boolean removeVehicle(Vehicle v) {
        return vehicles.remove(v);
    }

    // check if the station on longer has room for returns
    public boolean isFull() {
        return vehicles.size() >= capacity;
    }
}