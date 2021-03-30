package com.rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rover.Rover.enums.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarsRoverTest {

    @Test
    public void the_rover_reports_its_position_correctly() {
        MarsRover marsRover = new MarsRover(0, 0, CardinalDirection.NORTH);
        assertEquals("0:0:N", marsRover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,0:0:W", "WEST,0:0:S", "SOUTH,0:0:E", "EAST,0:0:N" })
    public void the_rover_has_the_correct_heading_if_told_to_face_left(CardinalDirection heading,
            String expectedPosition) {
        MarsRover marsRover = new MarsRover(0, 0, heading);
        marsRover.faceLeft();
        assertEquals(expectedPosition, marsRover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,0:0:E", "EAST,0:0:S", "SOUTH,0:0:W", "WEST,0:0:N" })
    public void the_rover_has_the_correct_heading_if_told_to_face_right(CardinalDirection heading,
            String expectedPosition) {
        MarsRover marsRover = new MarsRover(0, 0, heading);
        marsRover.faceRight();
        assertEquals(expectedPosition, marsRover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,3:4:N", "EAST,4:3:E", "SOUTH,3:2:S", "WEST,2:3:W" })
    public void the_rover_moves_to_the_correct_position_if_told_to_move_forward(CardinalDirection heading,
            String expectedPosition) {
        MarsRover marsRover = new MarsRover(3, 3, heading);
        marsRover.moveForward();
        assertEquals(expectedPosition, marsRover.getPosition());
    }
}
