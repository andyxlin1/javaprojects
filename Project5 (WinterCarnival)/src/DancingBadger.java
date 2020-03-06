//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DancingBadger
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
import java.io.File;

/**
 * Creates an image of a DancingBadger given the start position and the dancesteps.
 * 
 * @author Andy Lin
 *
 */
public class DancingBadger extends StarshipRobot {
  protected DanceStep[] danceSteps; // A 1-D array containing the dance steps for DancingBadger
  protected int stepIndex; // the index of the dance step to perform.

  /**
   * Constructor that calls the constructor from StarshipRobot with inputs a 2-DArray containing one
   * array of the starting positions, and another array of the destination of the instance of
   * DancingBadger after the first dance move. Afterwards, it sets this.danceSteps to dancesteps,
   * the imageName to "images" + File.separator + "dancingBadger.png", the speed to 2 and the
   * stepIndex to 1.
   * 
   * @param start      1-D float array containing the x starting position in the first element and y
   *                   starting position in second element.
   * @param danceSteps A 1-D DanceStep array containing danceSteps for DancingBadger to perform.
   */
  public DancingBadger(float[] start, DanceStep[] danceSteps) {
    super(new float[][] {{start[0], start[1]},
        {danceSteps[0].getPositionAfter(start)[0], danceSteps[0].getPositionAfter(start)[1]}});
    this.danceSteps = danceSteps;
    this.imageName = "images" + File.separator + "dancingBadger.png";
    this.speed = 2;
    int stepIndex = 1;
  }

  @Override
  /**
   * Overrides the updateDesination method from StarshipRobot. If stepIndex is greater than the
   * number of elements in danceSteps - 1, then reset stepIndex to 0. Otherwise, it updates the
   * destination for this instance of DancingBadger by calling getPositionAfter on the element of
   * danceSteps at stepIndex with parameters of the current destination. Afterwards, it increments
   * stepIndex by 1.
   */
  public void updateDestination() {
    if (stepIndex > this.danceSteps.length - 1) {
      stepIndex = 0;
    }
    this.destination[0] = this.danceSteps[stepIndex].getPositionAfter(this.destination)[0];
    this.destination[1] = this.danceSteps[stepIndex].getPositionAfter(this.destination)[1];
    this.stepIndex = this.stepIndex + 1;
  }
}
