package com.rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.rover.Rover.enums.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarsRoverTest {

    Grid defaultGrid = new Grid(5,5);

    @ParameterizedTest
    @CsvSource({ "NORTH,0:0:W", "WEST,0:0:S", "SOUTH,0:0:E", "EAST,0:0:N" })
    public void the_rover_has_the_correct_heading_if_told_to_face_left(CardinalDirection heading,
            String expectedPosition) throws Exception {
        Coordinates coordinates = new Coordinates(0, 0);
        MarsRover marsRover = new MarsRover(coordinates, heading, defaultGrid);
        assertEquals(expectedPosition, marsRover.execute("L"));
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,0:0:E", "EAST,0:0:S", "SOUTH,0:0:W", "WEST,0:0:N" })
    public void the_rover_has_the_correct_heading_if_told_to_face_right(CardinalDirection heading,
            String expectedPosition) throws Exception {
        Coordinates coordinates = new Coordinates(0, 0);
        MarsRover marsRover = new MarsRover(coordinates, heading, defaultGrid);
        assertEquals(expectedPosition, marsRover.execute("R"));
    }

    @ParameterizedTest
    @CsvSource({ "NORTH,3:4:N", "EAST,4:3:E", "SOUTH,3:2:S", "WEST,2:3:W" })
    public void the_rover_moves_to_the_correct_position_if_told_to_move_forward(CardinalDirection heading,
            String expectedPosition) throws Exception {
        Coordinates coordinates = new Coordinates(3, 3);
        MarsRover marsRover = new MarsRover(coordinates, heading, defaultGrid);
        assertEquals(expectedPosition, marsRover.execute("M"));
    }

    @ParameterizedTest
    @CsvSource({ "0,5,NORTH,0:6:N LOST", "5,2,EAST,6:2:E LOST", "3,0,SOUTH,3:-1:S LOST", "0,4,WEST,-1:4:W LOST" })
    public void the_rover_reports_itself_as_being_lost_if_it_falls_off_the_edge_of_the_grid_and_leaves_a_scent_behind(int xCoordinate, int yCoordinate,
            CardinalDirection heading, String expectedPosition) throws Exception {
        Grid grid = new Grid(5,5);
        Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
        MarsRover marsRover = new MarsRover(coordinates, heading, grid);
        assertEquals(expectedPosition, marsRover.execute("M"));
        assertTrue(grid.hasScent(coordinates));
    }

    @ParameterizedTest
    @CsvSource({ "1,2,NORTH,LMLMLMLMM,1:3:N", "3,3,EAST,MMRMMRMRRM,5:1:E" })
    public void the_rover_executes_commands_and_ends_up_in_an_expected_position_and_heading(int xCoordinate,
            int yCoordinate, CardinalDirection heading, String commandList, String expectedPosition) throws Exception {
        Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
        MarsRover marsRover = new MarsRover(coordinates, heading, defaultGrid);
        assertEquals(expectedPosition, marsRover.execute(commandList));
    }

    @Test
    public void an_exception_is_thrown_if_a_command_the_rover_doesnt_understand_is_passed_to_it() throws Exception {
        Coordinates coordinates = new Coordinates(0, 0);
        MarsRover marsRover = new MarsRover(coordinates, CardinalDirection.NORTH, defaultGrid);
        Exception exception = assertThrows(Exception.class, () -> {
            marsRover.execute("?");
        });

        String expectedMessage = "Command not recognised";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void an_exception_is_thrown_if_the_series_of_instructions_given_to_the_rover_are_too_long() throws Exception {
        Coordinates coordinates = new Coordinates(0, 0);
        MarsRover marsRover = new MarsRover(coordinates, CardinalDirection.NORTH, defaultGrid);
        
        Exception exception = assertThrows(Exception.class, () -> {
            marsRover.execute("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        });

        String expectedMessage = "The rover cannot parse a command list of 100 or more instructions";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
