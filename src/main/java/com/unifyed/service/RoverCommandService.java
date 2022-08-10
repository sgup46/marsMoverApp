package com.unifyed.service;

import com.unifyed.model.RoverCommands;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverCommandService implements MarsMoverService<List<RoverCommands>, Boolean>{
    @Override
    public Boolean process(List<RoverCommands> inputs) {
        return null;
    }
}
