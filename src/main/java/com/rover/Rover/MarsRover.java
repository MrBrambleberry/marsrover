package com.rover.Rover;

import com.rover.Rover.enums.*;

public class MarsRover {
    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection heading;

    public MarsRover(int xCoordinate, int yCoordinate, CardinalDirection heading) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.heading = heading;
    }

    public void faceLeft() {
        switch (this.heading) {
        case NORTH:
            this.heading = CardinalDirection.WEST;
            break;
        case WEST:
            this.heading = CardinalDirection.SOUTH;
            break;
        case SOUTH:
            this.heading = CardinalDirection.EAST;
            break;
        case EAST:
            this.heading = CardinalDirection.NORTH;
            break;
        }
    }

    public void faceRight() {
        switch (this.heading) {
        case NORTH:
            this.heading = CardinalDirection.EAST;
            break;
        case WEST:
            this.heading = CardinalDirection.NORTH;
            break;
        case SOUTH:
            this.heading = CardinalDirection.WEST;
            break;
        case EAST:
            this.heading = CardinalDirection.SOUTH;
            break;
        }
    }

    public void moveForward() {
        switch (this.heading) {
        case NORTH:
            this.yCoordinate++;
            break;
        case WEST:
            this.xCoordinate--;
            break;
        case SOUTH:
            this.yCoordinate--;
            break;
        case EAST:
            this.xCoordinate++;
            break;
        }
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
