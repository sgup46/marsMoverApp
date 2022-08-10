package com.unifyed.service.commands;

import com.unifyed.model.Coordinates;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.util.DIRECTION;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Data
public class RightCommandTest {
    @InjectMocks
    RightCommand rightCommand;

    @Test
    public void testExecute() {
        Rover rover = new Rover(DIRECTION.N, new Coordinates(1, 2));
        rightCommand.execute(rover,
                new Plataeu(4,4));
        Assertions.assertEquals(rover.getDirection(), DIRECTION.E);
        Assertions.assertEquals(rover.getCoordinates().getXCoordinate(), 1);
        Assertions.assertEquals(rover.getCoordinates().getYCoordinate(), 2);
    }
}
