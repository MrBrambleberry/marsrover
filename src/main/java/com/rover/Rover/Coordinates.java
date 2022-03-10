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

    public void incrementYCoordinate() {
        this.yCoordinate++;
    }

    public void decrementXCoordinate() {
        this.xCoordinate--;
    }

    public void decrementYCoordinate() {
        this.yCoordinate--;
    }

    public void incrementXCoordinate() {
        this.xCoordinate++;
    }

}
