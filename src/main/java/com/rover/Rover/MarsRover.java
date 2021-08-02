package com.rover.Rover;

import com.rover.Rover.enums.*;

public class MarsRover {
    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection heading;
    private static final int gridSize = 5;

    public MarsRover(int xCoordinate, int yCoordinate, CardinalDirection heading) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.heading = heading;
    }

    private void faceLeft() {
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

    private void faceRight() {
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

    private void moveForward() {
        switch (this.heading) {
            case NORTH:
                this.yCoordinate = yCoordinate + 1 > gridSize ? 0 : yCoordinate + 1;
                break;
            case WEST:
                this.xCoordinate = xCoordinate - 1 < 0 ? gridSize : xCoordinate - 1;
                break;
            case SOUTH:
                this.yCoordinate = yCoordinate - 1 < 0 ? gridSize : yCoordinate - 1;
                break;
            case EAST:
                this.xCoordinate = xCoordinate + 1 > gridSize ? 0 : xCoordinate + 1;
                break;
        }
    }

    public String execute(String commandList) {
        String[] commands = commandList.split("");

        for (String command : commands) {
            switch (command) {
                case "L":
                    faceLeft();
                    break;
                case "R":
                    faceRight();
                    break;
                case "M":
                    moveForward();
                    break;
            }
        }

        return getPosition();
    }

    private String getPosition() {
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
