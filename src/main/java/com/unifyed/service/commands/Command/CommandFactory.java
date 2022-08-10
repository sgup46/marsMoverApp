package com.unifyed.service.commands.Command;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;

public interface CommandFactory {
    Command getCommand(String commandType);
}
