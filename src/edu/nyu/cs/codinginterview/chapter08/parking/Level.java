package edu.nyu.cs.codinginterview.chapter08.parking;

public class Level {
    @SuppressWarnings("unused")
    private int floor;
    @SuppressWarnings("unused")
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    @SuppressWarnings("unused")
    private static final int SPOTS_PER_ROW = 10;
    
    public Level(int floor, int numberSpots) {
        // TODO Auto-generated method stub
    }
    
    public int availableSpots() {
        return availableSpots;
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @SuppressWarnings("unused")
    private boolean parkStartingAtSpot(int num, Vehicle v) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @SuppressWarnings("unused")
    private int findAvaiableSpots(Vehicle v) {
        // TODO Auto-generated method stub
        return -1;
    }
    
    public void spotFreed() {
        availableSpots++;
    }

}
