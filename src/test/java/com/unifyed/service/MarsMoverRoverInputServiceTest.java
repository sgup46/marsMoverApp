package com.unifyed.service;

import com.unifyed.model.RoverCommands;
import com.unifyed.service.commands.Command.CommandFactory;
import com.unifyed.service.commands.LeftCommand;
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
import java.util.List;

@ExtendWith(MockitoExtension.class)
@Data
public class MarsMoverRoverInputServiceTest {

    @InjectMocks
    MarsMoverRoverInputService marsMoverRoverInputService;

    @Mock
    CommandFactory commandFactory;

    @Test
    public void testProcessInput() {
        List<String> inputs = new ArrayList<>();
        inputs.add("1 2 N");
        inputs.add("LMLMLMLMM");
        marsMoverRoverInputService.setCommandFactory(commandFactory);
        Mockito.when(commandFactory.getCommand(Mockito.anyString())).thenReturn(new LeftCommand());
        RoverCommands roverCommands = marsMoverRoverInputService.processInput(inputs);
        Assertions.assertEquals(roverCommands.getRover().getDirection(), DIRECTION.N);
        Assertions.assertEquals(roverCommands.getRover().getCoordinates().getXCoordinate(), 1);
        Assertions.assertEquals(roverCommands.getRover().getCoordinates().getYCoordinate(), 2);
        Assertions.assertEquals(roverCommands.getRoverCommands().size(), 9);
    }
}
