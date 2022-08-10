package com.unifyed.service.commands.Command;

public interface CommandFactory {
    Command getCommand(String commandType);
}
