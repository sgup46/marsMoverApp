package com.unifyed.service;

import com.unifyed.model.Plataeu;
import com.unifyed.service.Iservice.InputService;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
@Data
public class MarsMoverPlateuInputServiceTest {

    @InjectMocks
    MarsMoverPlateuInputService marsMoverPlateuInputService;

    @Test
    public void testProcessInput() {
        Plataeu plataeu = marsMoverPlateuInputService.processInput(Arrays.asList("4 4"));
        Assertions.assertEquals(plataeu.getXAxisValue(), 4);
        Assertions.assertEquals(plataeu.getYAxisValue(), 4);
    }
}
