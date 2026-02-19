//
public class Main{
    public static void main(String[] args){
        //
        Station station1 = new Station("S1", "Centro", 5);
        Station station2 = new Station("S1", "Centro", 5);

        //
        Vehicle bike = new Vehicle("B1", VehicleType.BIKE, 90);

        //
        station1.addVehicle(bike);

        //
        User user = new User("U1", "Sara","Tarjeta");

        //
        Rental rental = user.startRental(bike, station1);
        if (rental != null){
            System.out.println("Inicio de Alquiler");
            System.out.println("Costo Total:" +rental.getTotalCost());
        }
        else {
            System.out.println("No pudo iniciar el alquiler")
        }

        

    }
}