package com.rover.Rover.enums;

public enum CardinalDirection {
    NORTH("N", "WEST", "EAST"), SOUTH("S", "EAST", "WEST"), EAST("E", "NORTH", "SOUTH"), WEST("W", "SOUTH", "NORTH");

    private String compassDirection;
    private String toTheLeft;
    private String toTheRight;

    CardinalDirection(String compassDirection, String toTheLeft, String toTheRight) {
        this.compassDirection = compassDirection;
        this.toTheLeft = toTheLeft;
        this.toTheRight = toTheRight;
    }

    public String getCompassDirection() {
        return this.compassDirection;
    }

    public CardinalDirection getToTheLeft() {
        return CardinalDirection.valueOf(this.toTheLeft);
    }

    public CardinalDirection getToTheRight() {
        return CardinalDirection.valueOf(this.toTheRight);
    }

}