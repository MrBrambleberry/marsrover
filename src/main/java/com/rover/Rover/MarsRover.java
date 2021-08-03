package com.rover.Rover;

import com.rover.Rover.enums.*;

public class MarsRover {
    private Coordinates coordinates;
    private CardinalDirection heading;
    private static final int gridSize = 5;

    public MarsRover(int xCoordinate, int yCoordinate, CardinalDirection heading) {
        this.coordinates = new Coordinates(xCoordinate, yCoordinate, gridSize);
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
                this.coordinates.incrementYCoordinate();
                break;
            case WEST:
                this.coordinates.decrementXCoordinate();
                break;
            case SOUTH:
                this.coordinates.decrementYCoordinate();
                break;
            case EAST:
                this.coordinates.incrementXCoordinate();
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
        return this.coordinates.getXCoordinate() + ":" + this.coordinates.getYCoordinate() + ":"
                + this.heading.getCompassDirection();
    }

}
