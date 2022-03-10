 package com.rover.Rover;
 import org.junit.jupiter.api.Test;
 
 import static org.junit.jupiter.api.Assertions.assertThrows;
 import static org.junit.jupiter.api.Assertions.assertTrue;

 public class CoordinatesTest {
    @Test
    public void a_set_of_coordinates_cannot_be_created_if_one_of_the_values_is_above_fifty() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Coordinates(51, 10);
        });

        String expectedMessage = "A coordinate with a width or depth greater than fifty is not allowed";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
 }
 