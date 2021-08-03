package com.rover.Rover;

import com.rover.Rover.enums.*;

public class MarsRover {
    private Coordinates coordinates;
    private CardinalDirection heading;
    private static final int gridSize = 5;

    public MarsRover(Coordinates coordinates, CardinalDirection heading) {
        this.coordinates = coordinates;
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
                this.coordinates.incrementYCoordinate(gridSize);
                break;
            case WEST:
                this.coordinates.decrementXCoordinate(gridSize);
                break;
            case SOUTH:
                this.coordinates.decrementYCoordinate(gridSize);
                break;
            case EAST:
                this.coordinates.incrementXCoordinate(gridSize);
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
