package com.rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rover.Rover.MarsRover.CardinalDirection;

import org.junit.jupiter.api.Test;

public class MarsRoverTest {

    @Test
    public void the_rover_reports_its_position_correctly() {
        MarsRover marsRover = new MarsRover(0, 0, CardinalDirection.NORTH);
        assertEquals("0:0:N", marsRover.getPosition());
    }
}
