//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:StarshipRobot
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
 * Creates and animates a StarshipRobot that moves back and forth between it's beginning position
 * and destination at a given speed. This class also inherits the properties from FrozenStatue.
 * 
 * @author Andy Lin
 *
 */
public class StarshipRobot extends FrozenStatue {
  protected float[][] beginAndEnd = new float[2][2]; // A 2-D array that contains the starting and
                                                     // ending position.
  protected float[] destination = new float[2]; // A 1-D array that containins the x and y
                                                // coordinates of the destination.
  protected float speed; // the speed of the robot.

  /**
   * Given a 2-D array of type float that contains the beginning and destination x and y positions,
   * the base class (FrozenStatue)'s constructor is called with input of 1-D float Array that
   * contains positions[0][1],positions[0][1] which is the starting x and y positions. Afterwards,
   * it sets this.beginAndEnd to positions, sets the first element of destination to the first
   * element of the second array in beginAndEnd, and sets the second element of destination to the
   * second elementary of the secondArray in beginAndEnd. it sets the imageName to "images" +
   * File.separator + "starshipRobot.png"; and speed to 6.
   * 
   * @param positions
   */
  public StarshipRobot(float[][] positions) {
    super(new float[] {positions[0][0], positions[0][1]});
    this.beginAndEnd = positions;
    this.destination[0] = beginAndEnd[1][0];
    this.destination[1] = beginAndEnd[1][1];
    this.imageName = "images" + File.separator + "starshipRobot.png";
    this.speed = 6;
  }

  /**
   * Updates instance StarshipRobot's position to the beginning position if the instance reaches the
   * destination, and to the destination once the robot travels back to the beginning position,
   * which allows the robot to move back and forth.
   */
  protected void updateDestination() {
    if (this.destination[0] == beginAndEnd[0][0] && this.destination[1] == beginAndEnd[0][1]) {
      this.destination[0] = beginAndEnd[1][0];
      this.destination[1] = beginAndEnd[1][1];
    } else {
      this.destination[0] = beginAndEnd[0][0];
      this.destination[1] = beginAndEnd[0][1];
    }

  }

  /**
   * Calculates the new position of x and y after moving at a certain speed using the distance
   * formula and the newX and newY formula. Furthermore, it sets isFacingRight to true if the first
   * element of designation is greater than the instance's current position, otherwise false.
   * 
   * @return true if the distance between the current position and destination is less than 2 times
   *         the speed of instance, otherwise false.
   */
  protected boolean moveTowardDestination() {
    float distanceBetweenX = (float) Math.pow((destination[0] - this.x), 2);
    float distanceBetweenY = (float) Math.pow((destination[1] - this.y), 2);
    float distanceTotal = distanceBetweenX + distanceBetweenY;
    float distanceBetweenCurrAndDest = (float) Math.sqrt(distanceTotal);
    float newXNumerator = this.speed * (destination[0] - this.x);
    this.x = this.x + (newXNumerator / distanceBetweenCurrAndDest);
    float newYNumerator = this.speed * (destination[1] - this.y);
    this.y = this.y + (newYNumerator / distanceBetweenCurrAndDest);

    if (destination[0] > this.x) {
      this.isFacingRight = true;
    } else {
      this.isFacingRight = false;
    }

    if (distanceBetweenCurrAndDest < (2 * this.speed)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * The update method calls the update method from FrozenStatue, then if moveTowardDestination is
   * false, it calls the update method from FrozenStatue. Otherwise, it calls the updateDestination
   * method.
   */
  public void update(SimulationEngine engine) {
    if (moveTowardDestination() == false) {
      super.update(engine);
    } else {
      updateDestination();
      super.update(engine);
    }
  }

}
