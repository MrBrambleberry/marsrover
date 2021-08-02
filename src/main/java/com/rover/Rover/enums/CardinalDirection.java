package com.rover.Rover.enums;

public enum CardinalDirection {
    NORTH("WEST", "EAST"), SOUTH("EAST", "WEST"), EAST("NORTH", "SOUTH"), WEST("SOUTH", "NORTH");

    private String toTheLeft;
    private String toTheRight;

    CardinalDirection(String toTheLeft, String toTheRight) {
        this.toTheLeft = toTheLeft;
        this.toTheRight = toTheRight;
    }

    public CardinalDirection getToTheLeft() {
        return CardinalDirection.valueOf(this.toTheLeft);
    }

    public CardinalDirection getToTheRight() {
        return CardinalDirection.valueOf(this.toTheRight);
    }

}