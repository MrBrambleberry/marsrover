package com.rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.rover.Rover.enums.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarsRoverTest {

    @ParameterizedTest
    @CsvSource({ "NORTH,0:0:W", "WEST,0:0:S", "SOUTH,0:0:E", "EAST,0:0:N" })
    public void the_rover_has_the_correct_heading_if_told_to_face_left(CardinalDirection heading,
            String expectedPosition) throws Exception {
        MarsRover marsRover = new MarsRover(0, 0, heading);
        assertEquals(expectedPosition, marsRover.execute("L"));
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,0:0:E", "EAST,0:0:S", "SOUTH,0:0:W", "WEST,0:0:N" })
    public void the_rover_has_the_correct_heading_if_told_to_face_right(CardinalDirection heading,
            String expectedPosition) throws Exception {
        MarsRover marsRover = new MarsRover(0, 0, heading);
        assertEquals(expectedPosition, marsRover.execute("R"));
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,3:4:N", "EAST,4:3:E", "SOUTH,3:2:S", "WEST,2:3:W" })
    public void the_rover_moves_to_the_correct_position_if_told_to_move_forward(CardinalDirection heading,
            String expectedPosition) throws Exception {
        MarsRover marsRover = new MarsRover(3, 3, heading);
        assertEquals(expectedPosition, marsRover.execute("M"));
    }

    @ParameterizedTest
    @CsvSource({ "0,5,NORTH,0:0:N", "5,2,EAST,0:2:E", "3,0,SOUTH,3:5:S", "0,4,WEST,5:4:W" })
    public void the_rover_circumnavigates_the_planet_if_at_the_edge_and_told_to_move(int xCoordinate, int yCoordinate,
            CardinalDirection heading, String expectedPosition) throws Exception {
        MarsRover marsRover = new MarsRover(xCoordinate, yCoordinate, heading);
        assertEquals(expectedPosition, marsRover.execute("M"));
    }

    @ParameterizedTest
    @CsvSource({ "1,2,NORTH,LMLMLMLMM,1:3:N", "3,3,EAST,MMRMMRMRRM,5:1:E" })
    public void the_rover_executes_commands_and_ends_up_in_an_expected_position_and_heading(int xCoordinate,
            int yCoordinate, CardinalDirection heading, String commandList, String expectedPosition) throws Exception {
        MarsRover marsRover = new MarsRover(xCoordinate, yCoordinate, heading);
        assertEquals(expectedPosition, marsRover.execute(commandList));
    }

    @Test
    public void an_exception_is_thrown_if_a_command_the_rover_doesnt_understand_is_passed_to_it() {
        MarsRover marsRover = new MarsRover(0, 0, CardinalDirection.NORTH);
        Exception exception = assertThrows(Exception.class, () -> {
            marsRover.execute("?");
        });

        String expectedMessage = "Command not recognised";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
