package com.rover.Rover;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    private final int upperLimit = 50;
    private final String upperLimitExceeded = "A coordinate with a width or depth greater than fifty is not allowed";

    public Coordinates(int xCoordinate, int yCoordinate) throws Exception {

        if(xCoordinate > upperLimit || yCoordinate > upperLimit){
            throw new Exception(upperLimitExceeded);
        }

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public void incrementYCoordinate(int gridSize) {
        this.yCoordinate = yCoordinate + 1 > gridSize ? 0 : yCoordinate + 1;
    }

    public void decrementXCoordinate(int gridSize) {
        this.xCoordinate = xCoordinate - 1 < 0 ? gridSize : xCoordinate - 1;
    }

    public void decrementYCoordinate(int gridSize) {
        this.yCoordinate = yCoordinate - 1 < 0 ? gridSize : yCoordinate - 1;
    }

    public void incrementXCoordinate(int gridSize) {
        this.xCoordinate = xCoordinate + 1 > gridSize ? 0 : xCoordinate + 1;
    }

}
