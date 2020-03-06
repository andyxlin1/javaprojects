//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: FrozenStatue
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
 * Creates an image of a FrozenStatue given the x and y position, if it's facing right, and name of
 * the image to display.
 * 
 * @author Andy Lin
 *
 */
public class FrozenStatue {
  protected float x; // x coordinate of FrozenStatue's current position
  protected float y; // y coordinate of FrozenStatue's current position
  protected boolean isFacingRight; // If the object is facing right or not
  protected String imageName; // the name of the image to draw.

  /**
   * Constructor that initializes this.x to the first element in positions, this.y to the second
   * element in positions, sets isFacingRight to true, and sets the image name to "images" +
   * File.separator + "frozenStatue.png"
   * 
   * @param positions A 1-D array of type float that houses the x and y position of FrozenStatue in
   *                  it's first and second element respectively.
   * 
   */
  public FrozenStatue(float[] positions) {
    this.x = positions[0];
    this.y = positions[1];
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "frozenStatue.png";
  }

  /**
   * Calls an instance of SimulationEngine and uses SimulationEngine's draw method with the given
   * inputs imageName, x,y, and isFacingRight to create an image.
   * 
   * @param engine an instance of SimulationEngine
   */
  public void update(SimulationEngine engine) {
    engine.draw(this.imageName, this.x, this.y, !isFacingRight);
  }

}
