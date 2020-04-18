//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: BoardingGroup
// Files: ThemeParkApp.java,BoardingGroup.Java,BGNode.java.RideQueue.java,QueueADT.java,sample.txt
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
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understood the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
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

/**
 * Creates an instance of the group name, amount of people in the group, and whether the group is
 * VIP or not.
 * 
 * @author Andy Lin
 *
 */
public class BoardingGroup {
  private String name;
  private int numPeople;
  private boolean isVIP;

  /**
   * Constructs a boarding group with it's name, amount of people, and VIP status.
   * @param name - the name of the group
   * @param numPeople - the amount of people in the group
   */
  public BoardingGroup(String name, int numPeople) {
    this.name = name;
    this.numPeople = numPeople;
    this.isVIP = false;
  }

  /**
   * returns the name of the group.
   * 
   * @return the instance variable name
   */
  public String getName() {
    return this.name;
  }

  /**
   * returns the amount of people in the group.
   * 
   * @return the instance variable numPeople
   */
  public int getNumPeople() {
    return this.numPeople;
  }

  /**
   * returns whether or not the group is VIP status
   * 
   * @return the instance variable isVIP.
   */
  public boolean getIsVIP() {
    return this.isVIP;
  }

  /**
   * sets VIP status of a group to true.
   */
  public void setIsVIP() {
    this.isVIP = true;
  }

}
