@Test
public void testFinalizarAlquiler() {
    Station station = new Station("S1", "Centro", 5);
    Vehicle vehicle = new Vehicle("V1", VehicleType.SCOOTER, 50);
    User user = new User("U1", "Ana", "Tarjeta");

    station.addVehicle(vehicle);
    Rental rental = new Rental(user, vehicle, station);
    Station stationDestino = new Station("S2", "Norte", 5);

    rental.endRental(stationDestino);

    assertEquals(VehicleStatus.AVAILABLE, vehicle.getStatus()); 
    assertNotNull(rental.getEndTime());
    assertTrue(rental.getTotalCost() >= 0);
}