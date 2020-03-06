import java.util.Random;
public class TestWumpusCaves {

    /**
     * Uncomment testing methods to have them run.
     * @param args unused
     */
    public static void main(String[] args) {
        testMove();
        testBat();
        testPlayerPerception();

    }

    /**
     * This method tests the move method.
     * 1. Check whether the move north from 1,1 works correctly.
     * 2. Check whether the move west from 1,1 works correctly.
     *
     * 3. Checks whether an incorrect input does anything.
     * 4. Checks whether the move east from 1,1 works correctly.
     * 5. Checks whether the move west from 1,1 works correctly.
     */
    private static void testMove() {
        boolean error = false;

        { // test 1
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

            WumpusCaves.move(cave, location, "n");
            if (!(location[Config.ROW] == 0 && location[Config.COLUMN] == 1)) {
                System.out.println(
                    "testMove 1: location expected 0,1; actual " + location[Config.ROW] + "," + location[Config.COLUMN]);
                error = true;
            }
        }

        { // test 2
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

            WumpusCaves.move(cave, location, "w");
            if (!(location[Config.ROW] == 1 && location[Config.COLUMN] == 0)) {
                System.out.println(
                    "testMove 2: location expected 1,0; actual " + location[Config.ROW] + "," + location[Config.COLUMN]);
                error = true;
            }
        }

        { // test 3
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

            WumpusCaves.move(cave, location, "3");
            if (!(location[Config.ROW] == 1 && location[Config.COLUMN] == 1)) {
                System.out.println(
                    "testMove 3: location expected 1,1; actual " + location[Config.ROW] + "," + location[Config.COLUMN]);
                error = true;
            }
        }

        { // test 4
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

            WumpusCaves.move(cave, location, "e");
            if (!(location[Config.ROW] == 1 && location[Config.COLUMN] == 2)) {
                System.out.println(
                    "testMove 4: location expected 1,2; actual " + location[Config.ROW] + "," + location[Config.COLUMN]);
                error = true;
            }
        }

        { // test 5
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

            WumpusCaves.move(cave, location, "s");
            if (!(location[Config.ROW] == 2 && location[Config.COLUMN] == 1)) {
                System.out.println(
                    "testMove 5: location expected 2,1; actual " + location[Config.ROW] + "," + location[Config.COLUMN]);
                error = true;
            }
        }

        if (error) {
            System.out.println("Error in testMove.");
        } else {
            System.out.println("All tests in testMove passed.");
        }
    }
    
    /**
     * This method tests the move method.
     * 1. Check whether the playerPerception for bat prints correctly
     * 2. Check whether the playerPerception for pit prints correctly
     */
    private static void testPlayerPerception() {
        boolean error = false;
        {
         // test 1
            int[] location = {0, 1};
            char[][] cave = {{' ', 'b', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            WumpusCaves.GameMode mode = WumpusCaves.GameMode.rescue;
            
            if (WumpusCaves.playerPerception(cave, location, mode).equals("you hear a rustling")) {
                System.out.println(
               "testMove 1: Expected: you hear a rustling" + "Actual: " + WumpusCaves.playerPerception(cave, location, mode));
                error = true;
            }
            
        }
        { // test 2
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', 'p', ' '}, {' ', ' ', ' '}};
            WumpusCaves.GameMode mode = WumpusCaves.GameMode.rescue;

            if (WumpusCaves.playerPerception(cave, location, mode).equals("you feel a draft")) {
                System.out.println(
               "testMove 2: Expected: you feel a draft" + " Actual: " + WumpusCaves.playerPerception(cave, location, mode));
                error = true;
            }
        }
        

        if (error) {
            System.out.println("Error in testPlayerPerception.");
        } else {
            System.out.println("All tests in playerPerception passed.");
        }
    }
    
    private static void testBat() {
        boolean error = false;
        Random RNG = new Random();

        { // test 1
            int[] location = {0, 1};
            char[][] cave = {{' ', 'b', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

            WumpusCaves.batMovePlayer(RNG, cave, location);
            if (WumpusCaves.batMovePlayer(RNG, cave, location) != "A huge bat picked you up and dropped you in another room...") {
                System.out.println(
               "testMove 1: \"Expected: A huge bat picked you up and dropped you in another room...\" " + "Actual: " + WumpusCaves.batMovePlayer(RNG, cave, location));
                error = true;
            }
        }
        { // test 2
            int[] location = {2, 2};
            char[][] cave = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', 'b'}};

            WumpusCaves.batMovePlayer(RNG, cave, location);
            if (WumpusCaves.batMovePlayer(RNG, cave, location) != "A huge bat picked you up and dropped you in another room...") {
                System.out.println(
               "testMove 2: \" Expected: A huge bat picked you up and dropped you in another room...\" " + "Actual: " + WumpusCaves.batMovePlayer(RNG, cave, location));
                error = true;
            }
        }
        
        { // test 3
            int[] location = {1, 1};
            char[][] cave = {{' ', ' ', ' '}, {' ', 'p', ' '}, {' ', ' ', ' '}};
            String testVariable = " ";

            if (cave[location[Config.ROW]][location[Config.COLUMN]] == Config.BAT) {
                WumpusCaves.batMovePlayer(RNG, cave, location);
                testVariable = WumpusCaves.batMovePlayer(RNG, cave, location);
            }
            String testString = "A huge bat picked you up and dropped you in another room...";
            if (testVariable.equals(testString)) {
                System.out.println(
               "testMove 3: \" Expected :" + "Actual: " + WumpusCaves.batMovePlayer(RNG, cave, location));
                error = true;
            }
        }

        if (error) {
            System.out.println("Error in testBat.");
        } else {
            System.out.println("All tests in testBat passed.");
        }
    }
    public static void testEquipment () {
        
    }
}

