package com.unifyed.service.commands.Command;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;

public interface Command {
    void execute(CommandFactory command, Rover rover, Plataeu plataeu);
}
