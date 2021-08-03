package com.rover.Rover;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    private int gridSize;

    public Coordinates(int xCoordinate, int yCoordinate, int gridSize) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.gridSize = gridSize;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public void incrementYCoordinate() {
        this.yCoordinate = yCoordinate + 1 > gridSize ? 0 : yCoordinate + 1;
    }

    public void decrementXCoordinate() {
        this.xCoordinate = xCoordinate - 1 < 0 ? gridSize : xCoordinate - 1;
    }

    public void decrementYCoordinate() {
        this.yCoordinate = yCoordinate - 1 < 0 ? gridSize : yCoordinate - 1;
    }

    public void incrementXCoordinate() {
        this.xCoordinate = xCoordinate + 1 > gridSize ? 0 : xCoordinate + 1;
    }

}
