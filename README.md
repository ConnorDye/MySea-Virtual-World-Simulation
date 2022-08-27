# MySea: Virtual World Simulation and Game

This program is a virtual simulation of the sea with many creatures. Run the source files (the VirtualWorld.java class holds GUI functionality) when it is loaded into a IDE like IntelliJ to see the game (see a picture below).

Created by Connor Dye as a California Polytechnic University Project. My responsibilities included: **`1.)`** complete refactoring of the program into an object oriented design from a procedural design **`2.)`** creating a A* search algorithm for movement of the creatures in the simulation **`3.)`** overall optimazation of code to make the program more efficient.

## Features
- Usage: run the GUI in IntelliJ IDE to see the simulation
- AStarPathingStrategy.java features the A* search movement algorithm I created for the movement of the creatures
- SGRASS.java holds the functionality for the seagrass entity in the program, fish.java for the fish, etc.; see the src files for each entities functionality
- note that abstract classes and interfaces were utilized to reduce code duplication and improve readability as many entities (creatures) share a degree of functionality


![simulation](https://user-images.githubusercontent.com/84818795/177058496-7557dd55-54fc-4e84-9e31-6e91dd32c26f.png)
