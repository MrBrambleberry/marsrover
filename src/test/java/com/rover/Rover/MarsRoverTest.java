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
}
