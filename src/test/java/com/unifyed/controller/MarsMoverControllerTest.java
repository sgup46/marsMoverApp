package com.unifyed.controller;

import com.unifyed.model.Coordinates;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.MarsMoverOutputService;
import com.unifyed.service.MarsMoverPlateuInputService;
import com.unifyed.service.MarsMoverProcessService;
import com.unifyed.service.MarsMoverRoverInputService;
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

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@Data
public class MarsMoverControllerTest {
    @InjectMocks
    MarsMoverController marsMoverController;

    @Mock
    MarsMoverPlateuInputService marsMoverPlateuInputService;

    @Mock
    MarsMoverRoverInputService marsMoverRoverInputService;

    @Mock
    MarsMoverProcessService marsMoverProcessService;

    @Mock
    MarsMoverOutputService marsMoverOutputService;

    @Test
    public void testProcessInput() {
        RoverCommands roverCommands = new RoverCommands(new Rover(DIRECTION.N, new Coordinates(1,2)),
                Arrays.asList(new LeftCommand(), new MoveCommand(), new RightCommand()));
        Mockito.when(marsMoverProcessService.process(Mockito.any(RoverCommands.class), Mockito.any(Plataeu.class))).thenReturn(new Rover(DIRECTION.N, new Coordinates(1, 2)));
        Mockito.when(marsMoverPlateuInputService.processInput(Mockito.any(List.class))).thenReturn(new Plataeu(4,4));
        Mockito.when(marsMoverRoverInputService.processInput(Mockito.any(List.class))).thenReturn(roverCommands);
        Mockito.when(marsMoverOutputService.processOutput(Mockito.any(Plataeu.class))).thenReturn("3 1 E");
        String output = marsMoverController.processInput("src/test/resources/RoverCommandsInvalidSample.txt");
        Assertions.assertEquals(output, "3 1 E");
    }
}
