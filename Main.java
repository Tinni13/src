public class Main {
    public static void main(String[] args) throws InterruptedException {
        // initial system configuration
        Station s1 = new Station("S1", "Centro", 5);
        Station s2 = new Station("S2", "Norte", 5);
        Vehicle v1 = new Vehicle("V1", VehicleType.SCOOTER, 90);
        User u1 = new User("U1", "Carlos", "Tarjeta");

        s1.addVehicle(v1);
        System.out.println("--- Iniciando Alquiler ---");
        
        // the user initiates the rental through his method
        Rental rental = u1.startRental(v1, s1);

        if (rental != null) {
            System.out.println("Alquiler iniciado con éxito.");
            
            // we simulate a use time of 2 seconds
            Thread.sleep(2000); 

            // finish rental
            rental.endRental(s2);
            System.out.println("Alquiler finalizado en estación: " + s2.getLocation());
            System.out.println("Costo total: $" + rental.getTotalCost());
        } else {
            System.out.println("No se pudo iniciar el alquiler.");
        }
    }
}