package com.unifyed.service;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.Iservice.ProcessService;
import com.unifyed.service.commands.Command.Command;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarsMoverProcessService implements ProcessService {
    @Override
    public Rover process(RoverCommands roverCommands, Plataeu plataeu) {
        Rover rover = roverCommands.getRover();
        List<Command> roverCommandsList = roverCommands.getRoverCommands();
        roverCommandsList.stream().forEach(command -> {
            command.execute(rover, plataeu);
        });
        plataeu.addRover(rover);
        return rover;
    }
}
