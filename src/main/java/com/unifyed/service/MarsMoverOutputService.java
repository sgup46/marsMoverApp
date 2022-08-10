package com.unifyed.service;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.Iservice.OutputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MarsMoverOutputService implements OutputService<Plataeu, String> {

    Logger logger = LoggerFactory.getLogger(MarsMoverOutputService.class);

    @Override
    public String processOutput(Plataeu plataeu) {
        try {
            List<Rover> rovers = plataeu.getRovers();
            int count = 0;
            StringBuffer buffer = new StringBuffer();
            for(Rover rover: rovers) {
                buffer.append(rover.toString());
                if (count != rovers.size()-1) {
                    buffer.append("\n");
                }
                count ++;
            }

            String finalOutput = buffer.toString();
            logger.info(finalOutput);
            return finalOutput;
        } catch (Exception e) {
            throw new MarsRoverException("invalid output for Plateu:" + e.getMessage());
        }
    }
}
