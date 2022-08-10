package com.unifyed.service;

import com.unifyed.model.Coordinates;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.commands.Command.CommandFactory;
import com.unifyed.service.commands.LeftCommand;
import com.unifyed.service.commands.MoveCommand;
import com.unifyed.service.commands.RightCommand;
import com.unifyed.util.DIRECTION;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@Data
public class MarsMoverProcessServiceTest {

    @InjectMocks
    MarsMoverProcessService marsMoverProcessService;

    @Mock
    CommandFactory commandFactory;

    @Test
    public void testProcessInput() {
        RoverCommands roverCommands = new RoverCommands(new Rover(DIRECTION.N, new Coordinates(1,2)),
                Arrays.asList(new LeftCommand(), new MoveCommand(), new RightCommand()));
        Rover rover = marsMoverProcessService.process(roverCommands, new Plataeu(5, 5));
        Assertions.assertEquals(roverCommands.getRover().getDirection(), DIRECTION.N);
        Assertions.assertEquals(roverCommands.getRover().getCoordinates().getXCoordinate(), 0);
        Assertions.assertEquals(roverCommands.getRover().getCoordinates().getYCoordinate(), 2);
    }
}
