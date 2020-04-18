//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Linked Cart
// Files: AlphabetList.java, AlphabetListTester.java, Cart.java, LinkedCart.java, SortedListADT.java
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
 * This class models and implements a doubly linked cart
 * 
 * @author Andy Lin
 *
 */
public class LinkedCart {
  private final Cart CART; // data field of this linked Cart
  private LinkedCart previous; // reference to the previous linked cart in
  // a list of carts
  private LinkedCart next; // reference to the next linked cart in a list of carts


  /**
   * Creates a new LinkedCart object with specific data cart and null for both previous and next
   * linked carts
   * 
   * @param cart- data of this linked cart
   */
  public LinkedCart(Cart cart) {
    this.CART = cart;
    this.previous = null;
    this.next = null;
  }

  /**
   * Creates a new LinkedCart object with specific data cart, previous and next linked carts
   * 
   * @param cart     - data of this linkedCart
   * @param previous - reference to the previous linked cart
   * @param next     - reference to the next linked cart
   */
  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }

  /**
   * Returns a reference to the data cart of this linked cart
   * 
   * @return the data cart of this LinkedCart
   */
  public Cart getCart() {
    return this.CART;
  }

  /**
   * Returns a reference to the previous LinkedCart attached to this linked cart
   * 
   * @return the previous LinkedCart
   */
  public LinkedCart getPrevious() {
    return this.previous;
  }

  /**
   * Sets the previous LinkedCart attached to this LinkedCart
   * 
   * @param previous - the previous to set
   */
  public void setPrevious(LinkedCart previous) {
    this.previous = previous;
  }

  /**
   * Returns a reference to the next LinkedCart attached to this LinkedCart
   * 
   * @return the next LinkedCart
   */
  public LinkedCart getNext() {
    return this.next;
  }

  /**
   * Sets the next LinkedCart attached to this LinkedCart
   * 
   * @param next - the next to set
   */
  public void setNext(LinkedCart next) {
    this.next = next;
  }



}
