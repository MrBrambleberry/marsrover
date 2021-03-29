package com.rover.Rover;

public class MarsRover {
    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection heading;

    public enum CardinalDirection {
        NORTH, SOUTH, EAST, WEST
    }

    public MarsRover(int xCoordinate, int yCoordinate, CardinalDirection heading) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.heading = heading;
    }

    public String getPosition() {
        String shortHeading = new String();
        switch (this.heading) {
        case NORTH:
            shortHeading = "N";
            break;
        case SOUTH:
            shortHeading = "S";
            break;
        case EAST:
            shortHeading = "E";
            break;
        case WEST:
            shortHeading = "W";
            break;
        }

        return this.xCoordinate + ":" + this.yCoordinate + ":" + shortHeading;
    }

}
