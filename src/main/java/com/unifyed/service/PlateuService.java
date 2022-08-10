package com.unifyed.service;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Plataeu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateuService implements MarsMoverService<List<String>, Plataeu>{
    @Override
    public Plataeu process(List<String> inputs) {
        try {
            String input[] = inputs.get(0).split(" ");
            return new Plataeu(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        } catch (Exception e) {
            throw new MarsRoverException("invalid input for Plateu");
        }
    }
}
