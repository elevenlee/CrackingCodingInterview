package edu.nyu.cs.codinginterview.chapter08.parking;

public class Bus extends Vehicle {

    public Bus() {
        spotsNeeded = 5;
        type = VehicleType.LARGE;
    }
    
    @Override
    public boolean canFitsInSpot(ParkingSpot spot) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
