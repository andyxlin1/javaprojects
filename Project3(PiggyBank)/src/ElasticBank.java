//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ElasticBank
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
import java.util.Random;

/**
 * Instantiable class that allows the user to add a coin, remove a coin and empty a piggy bank.
 * 
 * @author Andy Lin
 * 
 */
public class ElasticBank {
  private int size = 0;
  private Coin[] coins;
  private int expansionsLeft = 2;
  Random rand = new Random();

  /**
   * default constructor that initializes coins array to an empty array of type coin with capacity
   * ten
   */
  public ElasticBank() {
    this.coins = new Coin[10];
  }

  /**
   * Constructor that initializes coins array to an empty array of type coin with capacity
   * initalCapacity
   * 
   * @param initialCapacity
   */
  public ElasticBank(int initialCapacity) {
    this.coins = new Coin[initialCapacity];
  }

  /**
   * returns the piggy bank's capacity;
   * 
   * @return capacity
   */
  public int capacity() {
    return coins.length;
  }

  /**
   * returns amount of expansions left
   * 
   * @return expansionsLeft
   */
  public int getExpansions() {
    return this.expansionsLeft;
  }

  /**
   * returns the current amount of coins in piggy bank
   * 
   * @return size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * returns the sum of the coins in piggy bank
   * 
   * @return the balance of piggy bank
   */
  public int getBalance() {
    int balance = 0;
    for (int i = 0; i < this.size; i++) {
      balance = balance + this.coins[i].getValue();
    }
    return balance;
  }

  /**
   * Allows the user to see what coins are in the piggy bank, by displaying each coins name and
   * value
   * 
   * @return a string representation of piggy bank
   */
  public String getCoins() {
    String returnString = "";
    for (int i = 0; i < size; i++) {
      returnString = returnString + "(" + coins[i].getName() + ", " + coins[i].getValue() + ") ";
    }
    returnString = returnString.trim();
    return returnString;
  }

  /**
   * Removes a random coin from a piggy bank by setting it to null, unless the piggy bank is empty
   * 
   * @return the removed coin, and null if piggy bank is empty
   */
  public Coin removeCoin() {
    boolean empty = true;
    // checks whether the coins array is empty or not
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] != null) {
        empty = false;
        break;
      }
    }

    if (empty) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
      return null;
    }

    else {
      int indexToRemove = rand.nextInt(this.size);
      Coin returnCoin = this.coins[indexToRemove];
      Coin tempCoin = coins[this.size - 1];
      this.coins[indexToRemove] = tempCoin;
      this.coins[this.size - 1] = null;
      this.size = this.size - 1;
      return returnCoin;
    }
  }

  /**
   * Empties the piggy bank by setting all coins to null.
   */
  public void empty() {
    boolean empty = true;
    // checks whether the coins array is empty or not
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] != null) {
        empty = false;
        break;
      }
    }
    
    if (empty) {
      System.out.println("Zero coin removed. The piggy bank is already empty.");
    }

    else {
      System.out.println("All done. " + getBalance() + " cents removed.");
      for (int i = 0; i < coins.length; i++) {
        coins[i] = null;
      }
      this.size = 0;
    }

  }

  /**
   * Adds a coin, c into the piggy bank if there's room. If there's no room, and there's still
   * expansionsLeft, the method creates a new array of type Coin with ten extra capacity, and
   * transfers the old contents into the new array and then adds the coin. It then increases size by
   * one. If there's no space left and no expansions left, empty the piggy bank and then add coin.
   * Afterwords, set size to 1.
   * 
   * @param c The coin to add
   */
  public void addCoin(Coin c) {
    // if size < capacity, then it adds the coin to piggy bank
    if (this.size < coins.length) {
      for (int i = 0; i < coins.length; i++) {
        if (coins[i] == null) {
          coins[i] = c;
          break;
        }
      }
      this.size = this.size + 1;
    }

    else {
      // if there are expansions left, it expands the piggy bank by 10 and adds a coin
      if (this.expansionsLeft > 0) {
        Coin[] currentCoins = this.coins;
        this.expansionsLeft = this.expansionsLeft - 1;
        this.coins = new Coin[coins.length + 10];
        for (int i = 0; i < size; i++) {
          this.coins[i] = currentCoins[i];
        }

        for (int i = 0; i < coins.length; i++) {
          if (coins[i] == null) {
            coins[i] = c;
            break;
          }
        }
        this.size = this.size + 1;
      }

      //else, if there aren't any expansions left, it empties the piggy bank and then adds a coin.
      else {
        empty();
        for (int i = 0; i < coins.length; i++) {
          if (coins[i] == null) {
            coins[i] = c;
            break;
          }
        }
        this.size = this.size + 1;
      }
    }
  }



}
