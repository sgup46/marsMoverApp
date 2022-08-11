1) The main class to invoke is MarsMoverAppApplication, which is Spring Boot application
2) Simulation and evidence from Integration TestCase : MarsMoverAppApplicationTests.testRoverCommandsSample() method and input in file "RoverCommandsSample.txt" under resources folder in test cases
3) Model Class to define the domain model for Rover, Directions, Plateu and Coordinates. RoverCommands will encapsulate the Rover and its respective commands to send it to processing engine
4) 4 services Classes, backed by interfaces , using Dependency injection
   a) One to process Plateu input information
   b) 2nd to process Rover and its commands input information
   c) 3rd to process the RoverCommands and place it to plateu by implementing the moves
   d) 4th to display the final output to log console
5) CommandFactory and Commands implementation to handle the 3 commands: Left, Right anf Move
6) Controller will handle the overall flow . While iterating sequentially for all rover and its commands, the Rovers will be placed over the Plateu
7) Centralized Exception Handling in Place
8) Logging framework integrated
9) Junits for each class implemented seperately to test each class flow.
10) Config folder contains the ServiceLocationFactory for resolving the Commands at run time.