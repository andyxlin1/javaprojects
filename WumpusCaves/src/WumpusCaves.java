///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           WumpusCaves Refactor
// Course:          CS 200, 2019 term 1
//
// Author:          Andy Lin
// Email:           alin47@wisc.edu email address
// Lecturer's Name: Jim Wlliams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// https://cs200-www.cs.wisc.edu/wp/syllabus/#academicintegrity
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This project is an adventure game inspired by both the
 * classic Hunt the Wumpus game and the Tham Luang cave rescue.
 *     https://en.wikipedia.org/wiki/Hunt_the_Wumpus
 *     https://en.wikipedia.org/wiki/Tham_Luang_cave_rescue
 * 
 * @author Jim Williams
 * @author Andy Lin
 */
public class WumpusCaves {

    /**
     * Whether the game is search and rescue or hunt the wumpus.
     */
    enum GameMode {
        hunt, rescue
    };

    /**
     * Update the location parameter based on the direction. The cave is
     * in the shape of a torus meaning it wraps all directions. Movement
     * in any direction (n,s,e,w) is handled by this method.
     *  
     * @param currentCave The cave being explored.
     * @param CurrRowColumnChange The current row and column that are changed, 
     *    based on the direction, to the new row and column.
     *     
     * @param direction Either "n","s","e" or "w"
     */
    public static void move(char[][] currentCave, int[] currRowColumnChange,
        String direction) {
        
        
        switch (direction) {
        case "n":
            currRowColumnChange[Config.ROW]--;
            if ( currRowColumnChange[Config.ROW] <0) {
                currRowColumnChange[Config.ROW] = currentCave.length -1;
            }
            break;
        case "s":
            currRowColumnChange[Config.ROW]++;
            if ( currRowColumnChange[Config.ROW] >= currentCave.length) {
                currRowColumnChange[Config.ROW] = 0;
            }
            break;
        case "e":
            currRowColumnChange[Config.COLUMN] = 
            ++currRowColumnChange[Config.COLUMN] % currentCave[Config.ROW].length;
            break;
        case "w":
            currRowColumnChange[Config.COLUMN]--;
            if ( currRowColumnChange[Config.COLUMN] <0) {
                currRowColumnChange[Config.COLUMN] = currentCave[Config.ROW].length-1;
            }
            break;
        }       
    }
     
    

    /**
     * Prints out the result of the action of moving to the current location.
     * 
     * Algorithm:
     *  Checks to see whether the room you're in has a bat, pit, Wumpus,
     *  or simply nothing and performs a certain action.
     * 
     * @param RNG  A random number generator.
     * @param currentCave The cave being explored.
     * @param currentLocation The current location of the player
     * @param mode Whether rescuing a child or hunting the wumpus
     * @return true if alive, otherwise false.
     */
    
    public static boolean status(Random RNG, char[][] currentCave, int[] currentLocation, GameMode mode) {
        if (currentCave[currentLocation[Config.ROW]][currentLocation[Config.COLUMN]] == Config.BAT) {
            System.out.println(batMovePlayer(RNG,currentCave,currentLocation));
        }
        
        else if (currentCave[currentLocation[Config.ROW]][currentLocation[Config.COLUMN]] == Config.PIT) {
            System.out.println("You fell into a pit.");
            return false;
        }

        System.out.println("room " + currentLocation[Config.ROW] + "" + currentLocation[Config.COLUMN]);


        if (currentCave[currentLocation[Config.ROW]][currentLocation[Config.COLUMN]] == Config.WUMPUS) {
            if (mode == GameMode.rescue) {
                System.out.println("You've found the child safe and happy to see you!");
            } 
            
            else {
                System.out.println("You've been eaten by the Wumpus.");
            }
            return false;
            
        } 
        
        else {
            playerPerception (currentCave, currentLocation, mode);

        }
        return true;
    }

    /**
     * Prints out what the player senses in each rooms
     * 
     * Algorithm:
     *  Checks what room the player is in, and if the room contains an event
     *  (such as pit, bat, wumpus/child), it gives a certain message.
     * 
     * @param currentCave The cave being explored.
     * @param currentLocation The current location of the player
     * @param mode Whether rescuing a child or hunting the wumpus
     * @return returns the perception string at a given room
     */
    
    public static String playerPerception(char[][] currentCave, int[] currentLocation, GameMode mode) {    
        boolean[] numOfPerceptions = new boolean[Config.numPerceptions];
        String[] directions = {"n", "s", "e", "w"};
    
        for (int i = 0; i < directions.length; i++) {
            int[] perceiveArray = Arrays.copyOf(currentLocation, currentLocation.length);
            move(currentCave, perceiveArray, directions[i]);
    
            switch (currentCave[perceiveArray[Config.ROW]][perceiveArray[Config.COLUMN]]) {
                case 'p':
                    numOfPerceptions[Config.PerceivePit] = true;
                    break;
                case 'b':
                    numOfPerceptions[Config.PerceiveBat] = true;
                    break;
                case 'w':
                    numOfPerceptions[Config.PerceiveWumpusOrChild] = true;
                    break;
            }
        }
    

        if (numOfPerceptions[Config.PerceiveBat]) {
            System.out.println("you hear a rustling");
        }
        
        if (numOfPerceptions[Config.PerceivePit]) {
            System.out.println("you feel a draft");
        }
        
        if (numOfPerceptions[Config.PerceiveWumpusOrChild]) {
            if (mode == GameMode.rescue) {
                System.out.println("you hear a child snoring");
            } 
            else {
                System.out.println("there's an awful smell");
            }
        }
        return ("");
    }
    /**
     * If the room has a bat, it moves you into a random room and prints out a 
     * message to let the player know the bat has moved you into a different room
     * 
     * Algorithm:
     *  This code continually checks whether or not the player is in a room that
     *  contains 'b' or Config.BAT. If it does, it will randomly place the user
     *  in a different room by randomly generating a row and column until it's
     *  on a room that contains no "events" (Wumpus/child, pit, bat).
     * 
     * @param currentCave The cave being explored.
     * @param currentLocation The current location of the player
     * @param mode Whether rescuing a child or hunting the wumpus
     */
    public static String batMovePlayer(Random RNG, char[][] currentCave, int[] currentLocation) {
            do {
                currentLocation[Config.ROW] = RNG.nextInt(currentCave.length);
                currentLocation[Config.COLUMN] = RNG.nextInt(currentCave[Config.ROW].length);
            } while (currentCave[currentLocation[Config.ROW]][currentLocation[Config.COLUMN]] != ' ');
            return ("A huge bat picked you up and dropped you in another room...");
        
    }
    
    /**
     * Prints out and prompts user what they want to do with the equipment depending
     * on what gamemode they're on. If they use the equipment on a spot where the
     * wumpus/child is and in the correct direction, they win the game.
     * 
     * Algorithm:
     *  Depending on the gamemode, it prompts the user what direction they want 
     *  to fire their equipment in. If they fire their equipment in the correct direction
     *  they win the game.
     * 
     * @param scnr Allows code to use Scanner class
     * @param mode Determines whether the user is saving child or hunting
     * @param startingLocation The starting location for the user
     * @param userCavern the Cavern the user chose
     */
    public static void equipmentAction(Scanner scnrt,GameMode mode, int[] startingLocation, char [][] UserCavern) {
        if (mode == GameMode.rescue) {
            System.out.print("What direction to throw rope (nsew): ");
        } else {
            System.out.print("What direction to fire arrow (nsew): ");
        }
    
        String equipmentDirection = scnrt.nextLine().trim().toLowerCase();
        boolean success = false;
        if (mode == GameMode.rescue) {
            System.out.println("Rope flies " + equipmentDirection + "");
        } else {
            System.out.println("Arrow flies " + equipmentDirection + "");
        }
    
        int[] currRowCol =
            Arrays.copyOf(startingLocation,
                startingLocation.length);
        move(UserCavern, currRowCol, equipmentDirection);
    
        if (UserCavern[currRowCol[Config.ROW]][currRowCol[Config.COLUMN]] == Config.WUMPUS) {
            if (mode == GameMode.rescue) {
                System.out.println("Congratulations! The child grabbed the rope and "
                    + "you brought safely out of the cave!");
            } else {
                System.out.println(
                    "Congratulations! You killed the Wumpus and saved the villagers"
                        + " from their nightly terror.");
            }
            success = true;
        }
    
        if (success) {
            System.out
                .println("Hopefully, you can now find your way out of the cave....");
           
        }
  }
  
    /**
     * Prints out what the beginning of the introduction of the game
     * 
     * Algorithm:
     *  Prints out each message separately on a new line.
     */
  public static void printBeginning() {
      System.out.print("Use your senses to find your way in the cave. ");
      System.out.println("Beware of the huge bats");
      System.out.println("and the bottomless pits. Good Luck!\n");
      System.out.println("You enter the cave...");
  }
    
    /**
     * TODO summary comment
     * TODO algorithm 
     * 
     * @param args  unused
     */
    public static void main(String[] args) {
        Scanner scnrt = new Scanner(System.in);
        Random someNUM = new Random(Config.SEED);

        System.out.print("Would you like to go on a hunt or rescue a child (h/r): ");
        GameMode mode = GameMode.hunt;
        if (scnrt.nextLine().trim().toLowerCase().charAt(0) == Config.RESCUE) {
            mode = GameMode.rescue;
        }
        System.out.println("Thank you for coming to help us at Wumpus Caves.");
        if (mode == GameMode.rescue) {
            System.out.println("A child wandered into the cave and has not returned.");
            System.out.println("Please help us find our child!");
        } else {
            System.out.println("A Wumpus comes out of the cave at night and");
            System.out.println("attacks the villagers. Please hunt it down.");
        }
        System.out.println();

        char[][] UserCavern = Config.CAVES[Config.ROW];

        int caveNumberEnter = 0;
        boolean caveEnterLimit = false;
        for (; !caveEnterLimit;) {
            System.out.print("Please enter the number of the cave to enter: ");
            caveNumberEnter = scnrt.nextInt();
            scnrt.nextLine();
            if (caveNumberEnter >= 1 && caveNumberEnter <= Config.CAVES.length) {
                caveEnterLimit = true;
            }
        }
        UserCavern = Config.CAVES[caveNumberEnter - 1];
        System.out.println();
        printBeginning();



        int[] startingLocation = {0, 0};

        while (status(someNUM, UserCavern,
            startingLocation, mode)) {

            System.out.print("action: ");

            String action = scnrt.nextLine().trim().toLowerCase();
            switch (action) {
                case "n":
                case "s":
                case "e":
                case "w":
                    move(UserCavern,
                        startingLocation, action);
                    break;
                case "g":
                    equipmentAction(scnrt,mode,startingLocation, UserCavern);

                    break;
                default:
                    if (mode == GameMode.rescue) {
                        System.out.println("Move (nsew) or get rope (g).");
                    } else {
                        System.out.println("Move (nsew) or get arrow (g).");
                    }
                    break;
            }
        }
        System.out.println("Thanks for playing Wumpus Caves!");
        scnrt.close();
    }
}
