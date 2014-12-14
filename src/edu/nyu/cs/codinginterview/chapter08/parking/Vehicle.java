package edu.nyu.cs.codinginterview.chapter08.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected List<ParkingSpot> parkingSpots = 
            new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleType type;
    
    public int getSpotsNeeded() {
        return spotsNeeded;
    }
    
    public VehicleType getType() {
        return type;
    }
    
    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }
    
    public void clearSpots() {
        // TODO Auto-generated method stub
    }
    
    public abstract boolean canFitsInSpot(ParkingSpot spot);
    
}
