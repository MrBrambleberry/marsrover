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
        this.heading = this.heading.getToTheLeft();
    }

    private void faceRight() {
        this.heading = this.heading.getToTheRight();
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

    public String execute(String commandList) throws Exception {
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
                default:
                    throw new Exception("Command not recognised");
            }
        }

        return getPosition();
    }

    private String getPosition() {
        return this.xCoordinate + ":" + this.yCoordinate + ":" + this.heading.getCompassDirection();
    }

}
