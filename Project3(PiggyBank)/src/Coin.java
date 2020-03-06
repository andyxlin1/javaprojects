//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Coin
// Files: Coin.java, ElasticBank.java, ElasticTester.java
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
/**
 * Instantiable class to create a coin and get it's name and value.
 * @author Andy Lin
 *
 */
public class Coin {
  private String name = "";
  private int value = 0;
  
  /**
   * Constructor for coin that sets the Coin's name to parameter name and value to paramter value
   * @param name the name of the coin
   * @param value the value of the coin
   */
  public Coin(String name, int value) {
    this.name = name;
    this.value = value;
  }
  
  /**
   * returns the name of the coin
   * @return name of coin   
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * returns the value of the coin 
   * @return value of coin
   */
  public int getValue() {
    return this.value;
  }

}
