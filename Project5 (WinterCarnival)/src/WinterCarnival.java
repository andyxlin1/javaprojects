//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: WinterCarnival
// Files: WinterCarnival.java,FrozenStatue.java,StarshipRobot.java,DancingBadger.java,P05.jar
// Course: CS 300, Term 1, 2020
//
// Author: Andy Lin
// Email: alin47@wisc.edu
// Lecturer's Name: Hobbes LeGault
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE (identify each person and describe their help in detail)
// Online Sources: NONE (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

/**
 * Class that extends SimulationEngine and creates a graphical simulation when creating an instance
 * of this object that displays images. It implicitly calls update until the simulation is
 * terminated, which draws/moves the images.
 * 
 * @author Andy Lin
 *
 */
public class WinterCarnival extends SimulationEngine {
  private ArrayList<FrozenStatue> objects; // an arraylist containing all objects of type
                                           // FrozenStatue

  /**
   * Constructor that adds 2 FrozenStatue objects with parameter float[] of the position of the
   * object, 2 StarshipRobot objects with a parameter float[][] giving the beginning and destination
   * of the object, and 4 DancingBadgers with a parameter that takes in float[] which is beginning
   * position and DanceStep[] which contains the movement of the objects to this.objects.
   */
  public WinterCarnival() {
    DanceStep[] danceSteps = new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right,
        DanceStep.Left, DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right,
        DanceStep.Left, DanceStep.Up};
    this.objects = new ArrayList<FrozenStatue>() {
      {
        add(new FrozenStatue(new float[] {600, 100}));
        add(new FrozenStatue(new float[] {200, 500}));
        add(new StarshipRobot(new float[][] {{0, 0}, {600, 100}}));
        add(new StarshipRobot(new float[][] {{800, 300}, {200, 500}}));
        add(new DancingBadger(new float[] {304, 268}, danceSteps));
        add(new DancingBadger(new float[] {368, 268}, danceSteps));
        add(new DancingBadger(new float[] {432, 268}, danceSteps));
        add(new DancingBadger(new float[] {496, 268}, danceSteps));
      }
    };
  }


  /**
   * update is implicitly called when creating an instance of WinterCarnival which calls the update
   * method on every object in this.objects.
   */
  public void update() {
    for (FrozenStatue object : this.objects) {
      object.update(this);
    }
  }

  /**
   * Creates a WinterCarnival instance that runs the graphical simulation with SimulationEngine and
   * continues to update the simulation until terminated.
   * 
   * @param args is not used by this program.
   */
  public static void main(String[] args) {
    WinterCarnival winterCarnival = new WinterCarnival();

  }
}
