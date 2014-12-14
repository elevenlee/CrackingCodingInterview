package edu.nyu.cs.codinginterview.chapter08.parking;

public class Car extends Vehicle {

    public Car() {
        spotsNeeded = 1;
        type = VehicleType.COMPACT;
    }
    
    @Override
    public boolean canFitsInSpot(ParkingSpot spot) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
