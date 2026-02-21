//System user.
public class User{
    private String id;
    private String name;
    private String paymentMethod;

    public User(String id, String name, String paymentMethod){
        this.id = id;
        this.name = name;
        this.paymentMethod = paymentMethod;
    }
    public Rental startRental(Vehicle v, Station station){
    
        if (v.isAvailable()){
            if (station.removeVehicle(v)){
                v.startUse();
                return new Rental(this, v, station);
            }
        }
        return null; 
    }
}