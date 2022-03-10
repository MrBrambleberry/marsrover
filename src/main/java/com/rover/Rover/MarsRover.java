package com.rover.Rover;

import com.rover.Rover.enums.*;

public class MarsRover {
    private Coordinates coordinates;
    private CardinalDirection heading;
    private Grid grid;
    private final String instructionListTooLong = "The rover cannot parse a command list of 100 or more instructions";
    private final String unknownInstruction = "Command not recognised";
    private boolean isOutOfBounds = false;

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
        Coordinates preMoveLocation = this.coordinates;

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

        if(this.coordinates.getYCoordinate() > grid.getDepth() || this.coordinates.getYCoordinate() < 0){
            isOutOfBounds = true;
            grid.addScent(preMoveLocation);
        }

        if(this.coordinates.getXCoordinate() > grid.getWidth() || this.coordinates.getXCoordinate() < 0){
            isOutOfBounds = true;
            grid.addScent(preMoveLocation);
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
                    if(!grid.hasScent(this.coordinates)){
                        moveForward();
                    }
                    break;
                default:
                    throw new Exception(unknownInstruction);
            }
        }

        return getPosition();
    }

    private String getPosition() {
        String position = this.coordinates.getXCoordinate() + ":" + this.coordinates.getYCoordinate() + ":" + this.heading.getCompassDirection();
        if(isOutOfBounds == true){
            position = position + " LOST";
        }
        return position;
    }

}
