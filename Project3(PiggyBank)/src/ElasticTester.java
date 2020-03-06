//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ElasticTester
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
 * Tests the methods from ElasticBank
 * @author Andy Lin
 *
 */
public class ElasticTester {

  /**
   * tests the methods from Coin.java
   * @return true if the CoinInstantiable methods perform a correct function, otherwise false
   */
  public static boolean testCoinInstantiableClass() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    if (!penny.getName().equals("PENNY"))
      return false;
    if (penny.getValue() != 1)
      return false;
    if (!quarter.getName().equals("QUARTER"))
      return false;
    if (quarter.getValue() != 25)
      return false;
    return true;
  }

  /**
   * tests the accessor methods from ElasticBank.java
   * @return true if the ElasticBank accessor methods performs a correct function, otherwise false
   */
  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    if (one.getBalance() != 1)
      return false;
    if (two.getBalance() != 5)
      return false;
    return true;
  }

  /**
   * tests whether or not the getName() method works correctly
   * @return true if the getName method perform a correct function, otherwise false
   */
  public static boolean testCoinGetName() {
    Coin penny = new Coin("PENNY", 1);
    Coin nickel = new Coin("NICKEL", 5);
    Coin dime = new Coin("DIME", 10);
    if (penny.getName() != "PENNY")
      return false;
    if (nickel.getName() != "NICKEL")
      return false;
    if (dime.getName() != "DIME")
      return false;
    return true;
  }

  /**
   * tests whether or not the getValue() method works correctly
   * @return true if the getValue method perform a correct function, otherwise false
   */
  public static boolean testCoinGetValue() {
    Coin penny = new Coin("PENNY", 1);
    Coin nickel = new Coin("NICKEL", 5);
    Coin dime = new Coin("DIME", 10);
    if (penny.getValue() != 1)
      return false;
    if (nickel.getValue() != 5)
      return false;
    if (dime.getValue() != 10)
      return false;
    return true;
  }

  /**
   * tests whether or not the capacity() method works correctly
   * @return true if the capacity method perform a correct function, otherwise false
   */
  public static boolean testCapacity() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(30);
    ElasticBank three = new ElasticBank(15);
    if (one.capacity() != 10)
      return false;
    if (two.capacity() != 30)
      return false;
    if (three.capacity() != 15)
      return false;
    return true;
  }

  /**
   * tests whether or not the getExpansions method works correctly
   * @return true if the getExpansions method perform a correct function, otherwise false
   */
  public static boolean testGetExpansions() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(1);
    ElasticBank three = new ElasticBank(2);
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("PENNY", 1));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("QUARTER", 25));
    if (one.getExpansions() != 2)
      return false;
    if (two.getExpansions() != 1)
      return false;
    if (three.getExpansions() != 1)
      return false;
    return true;
  }

  /**
   * tests whether or not the getSize method works correctly
   * @return true if the getSize method perform a correct function, otherwise false
   */
  public static boolean testGetSize() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(1);
    ElasticBank three = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("DIME", 10));
    if (one.getSize() != 2)
      return false;
    if (two.getSize() != 0)
      return false;
    if (three.getSize() != 3)
      return false;
    return true;


  }

  /**
   * tests whether or not the getBalance method works correctly
   * @return true if the getBalance method perform a correct function, otherwise false
   */
  public static boolean testGetBalance() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(1);
    ElasticBank three = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("DIME", 10));
    if (one.getBalance() != 2)
      return false;
    if (two.getBalance() != 0)
      return false;
    if (three.getBalance() != 45)
      return false;
    return true;
  }

  /**
   * tests whether or not the getCoin method works correctly
   * @return true if the getCoin method perform a correct function, otherwise false
   */
  public static boolean testGetCoin() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(1);
    ElasticBank three = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("DIME", 10));
    if (!(one.getCoins().equals("(PENNY, 1) (PENNY, 1)")))
      return false;
    if (!(two.getCoins().equals("(NICKEL, 5)")))
      return false;
    if (!(three.getCoins().equals("(DIME, 10) (QUARTER, 25) (DIME, 10)")))
      return false;
    return true;
  }

  /**
   * tests whether or not the removeCoin method works correctly
   * @return true if the removeCoin method perform a correct function, otherwise false
   */
  public static boolean testRemoveCoin() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(1);
    ElasticBank three = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("DIME", 10));
    one.removeCoin();
    two.removeCoin();
    three.removeCoin();
    if (one.getSize() != 1)
      return false;
    if (two.getSize() != 0)
      return false;
    if (three.getSize() != 2)
      return false;
    return true;
  }

  /**
   * tests whether or not the empty method works correctly
   * @return true if the empty method perform a correct function, otherwise false
   */
  public static boolean testEmpty() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(4);
    ElasticBank three = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("DIME", 10));
    one.empty();
    two.empty();
    three.empty();
    if (one.getSize() != 0)
      return false;
    if (two.getSize() != 0)
      return false;
    if (three.getSize() != 0)
      return false;
    return true;
  }

  /**
   * tests whether or not the addCoin method works correctly
   * @return true if the addCoin method perform a correct function, otherwise false
   */
  public static boolean testAddCoin() {
    ElasticBank one = new ElasticBank(10);
    ElasticBank two = new ElasticBank(0);
    ElasticBank three = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("QUARTER", 25));
    three.addCoin(new Coin("DIME", 10));
    if (one.capacity() != 10)
      return false;
    if (two.capacity() != 10)
      return false;
    if (three.capacity() != 12)
      return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(testCoinInstantiableClass());
    System.out.println(testBalanceAccessors());
    System.out.println(testCoinGetName());
    System.out.println(testCoinGetValue());
    System.out.println(testCapacity());
    System.out.println(testGetExpansions());
    System.out.println(testGetSize());
    System.out.println(testGetBalance());
    System.out.println(testGetCoin());
    System.out.println(testRemoveCoin());
    System.out.println(testEmpty());
    System.out.println(testAddCoin());
  }

}
