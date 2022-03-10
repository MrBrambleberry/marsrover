package com.rover.Rover;

import com.rover.Rover.enums.*;

public class MarsRover {
    private Coordinates coordinates;
    private CardinalDirection heading;
    private Grid grid;
    private final String instructionListTooLong = "The rover cannot parse a command list of 100 or more instructions";
    private final String unknownInstruction = "Command not recognised";

    public MarsRover(Coordinates coordinates, CardinalDirection heading, Grid grid) {
        this.coordinates = coordinates;
        this.heading = heading;
        this.grid = grid;
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
                this.coordinates.incrementYCoordinate(grid.getDepth());
                break;
            case WEST:
                this.coordinates.decrementXCoordinate(grid.getWidth());
                break;
            case SOUTH:
                this.coordinates.decrementYCoordinate(grid.getDepth());
                break;
            case EAST:
                this.coordinates.incrementXCoordinate(grid.getWidth());
                break;
        }
    }

    public String execute(String commandList) throws Exception {
        
        if(commandList.length() >= 100){
            throw new Exception(instructionListTooLong);
        }
        
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
                    throw new Exception(unknownInstruction);
            }
        }

        return getPosition();
    }

    private String getPosition() {
        return this.coordinates.getXCoordinate() + ":" + this.coordinates.getYCoordinate() + ":"
                + this.heading.getCompassDirection();
    }

}
