package com.unifyed.service.Iservice;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;

public interface ProcessService {
    Rover process(RoverCommands roverCommands, Plataeu plataeu);
}
