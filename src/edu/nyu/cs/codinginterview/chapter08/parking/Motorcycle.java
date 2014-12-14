package edu.nyu.cs.codinginterview.chapter08.parking;

public class Motorcycle extends Vehicle {

    public Motorcycle() {
        spotsNeeded = 1;
        type = VehicleType.MOTORCYCLE;
    }
    
    @Override
    public boolean canFitsInSpot(ParkingSpot spot) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
