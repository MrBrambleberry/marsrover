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

    @ParameterizedTest
    @CsvSource({ "0,5,NORTH,0:0:N", "5,2,EAST,0:2:E", "3,0,SOUTH,3:5:S", "0,4,WEST,5:4:W" })
    public void the_rover_circumnavigates_the_planet_if_at_the_edge_and_told_to_move(int xCoordinate, int yCoordinate,
            CardinalDirection heading, String expectedPosition) {
        MarsRover marsRover = new MarsRover(xCoordinate, yCoordinate, heading);
        marsRover.moveForward();
        assertEquals(expectedPosition, marsRover.getPosition());

    }
}
