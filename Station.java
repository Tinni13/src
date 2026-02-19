//
import java.util.ArrayList;
import java.util.List;

public class Station{
    private String id;
    private String location;
    private int capacity;
    private List<Vehicle> vehicles;

    public Station(String id, String location, int capacity){
        this.id = id;
        this.location = location;
        this.capacity = capacity;
    }
    //
    public boolean addVehicle(Vehicle v){
        if (vehicles.size() < capacity){
            vehicles.add(v);
            return true;
        }
        return false;
    }
    //
    public boolean removeVehicle(Vehicle v){
        return vehicles.remove(v);
    }
    //
    public boolean isFull(){
        return vehicles.size() >= capacity;
    }
}