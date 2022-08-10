package com.unifyed;

import com.unifyed.controller.MarsMoverController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MarsMoverAppApplicationTests {

	@Autowired
	MarsMoverAppApplication marsMoverAppApplication;

	@Autowired
	MarsMoverController marsMoverController;

	@Test
	public void contextLoads() {
		Assertions.assertTrue(marsMoverAppApplication!=null);
	}

	@Test
	public void testRoverCommandsSample() {
		String output = marsMoverController.processInput("src/test/resources/RoverCommandsSample.txt");
		Assertions.assertEquals(output, "1 3 N\n" +
				                               "5 1 E");
	}

	@Test
	public void testRoverCommandsInvalidSample() {
		String output = null;
		try {
			output = marsMoverController.processInput("src/test/resources/RoverCommandsInvalidSample.txt");
		} catch (Exception e) {
			Assertions.assertEquals(e.getMessage(), "Unable to place rover:5 1 E on new coordinates: " +
					"Coordinates(super=com.unifyed.model.Coordinates@efc, xCoordinate=6, yCoordinate=1) having plateu: 5 5");
		}

	}

}
