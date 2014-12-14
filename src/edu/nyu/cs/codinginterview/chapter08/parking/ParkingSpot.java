package edu.nyu.cs.codinginterview.chapter08.parking;

public class ParkingSpot {
    private Vehicle vehicle;
    @SuppressWarnings("unused")
    private VehicleType type;
    private int row;
    private int spotNumber;
    @SuppressWarnings("unused")
    private Level level;
    
    public ParkingSpot(Level level, int row, int spotNumber, VehicleType type) {
        // TODO Auto-generated method stub
    }
    
    public boolean isAvailable() {
        return vehicle == null;
    }
    
    public boolean canFitVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public boolean park(Vehicle v) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }
    
    public void removeVehicle() {
        // TODO Auto-generated method stub
    }
    
}
