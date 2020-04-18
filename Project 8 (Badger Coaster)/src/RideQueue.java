//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Ride Queue
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
import java.util.NoSuchElementException;

/**
 * Implementing QueueADT, RideQueue creates a queue of BGNodes.
 * 
 * @author Andy Lin
 */
public class RideQueue implements QueueADT<BoardingGroup> {
  private BGNode front; // the front of the queue
  private BGNode back; // the back of the queue
  private int capacity; // the maximum amount of people the queue can hold
  private int numOfPeople; // the number of people in the queue
  private int numOfGroups; // the number of boarding groups in the queue.

  /**
   * Constructs an empty queue with the designated capacity.
   * 
   * @param capacity - The number of people this queue can fit.
   */
  public RideQueue(int capacity) {
    this.front = null;
    this.back = null;
    this.capacity = capacity;
    this.numOfPeople = 0;
    this.numOfGroups = 0;
  }

  @Override
  /**
   * Determines whether or not this queue is empty.
   * 
   * @return True when queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    return this.numOfGroups == 0;
  }

  @Override
  /**
   * Gives the number of BoardingGroup nodes in this queue.
   * 
   * @return The current number of nodes in the queue.
   */
  public int size() {
    return this.numOfGroups;
  }

  @Override
  /**
   * Adds the newGroup to the queue.
   * 
   * @param newGroup - The BoardingGroup to be added to the queue.
   * @throws java.lang.IllegalStateException - If the newGroup cannot fit into the queue. The
   *                                         exception should have a meaningful message.
   */
  public void enqueue(BoardingGroup newGroup) {
    if (newGroup.getNumPeople() + this.numOfPeople > capacity) {
      throw new IllegalStateException("The queue is full, cannot add new group.");
    }
    if (!newGroup.getIsVIP()) {
      BGNode current = back;
      back = new BGNode(newGroup);
      if (isEmpty()) {
        this.front = this.back;
      } else {
        current.setNext(back);
      }
      numOfGroups++;
      this.numOfPeople += newGroup.getNumPeople();
    } else {
      BGNode current = front;
      front = new BGNode(newGroup, current);
      if (isEmpty()) {
        this.front = this.back;
      }
      numOfGroups++;
      this.numOfPeople += newGroup.getNumPeople();
    }
  }

  @Override
  /**
   * Removes all groups from this queue. This queue will become empty.
   */
  public void clear() {
    this.front = null;
    this.back = null;
    this.numOfGroups = 0;
    this.numOfPeople = 0;

  }

  @Override
  /**
   * Returns the BoardingGroup at the front of this queue without removing it.
   * 
   * @throws java.util.NoSuchElementException - If this queue is empty. The exception should have a
   *                                          meaningful message.
   * @return The Group at the front of the line.
   */
  public BoardingGroup peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty. Front does not exist.");
    }
    return front.getGroup();
  }

  @Override
  /**
   * Returns the BoardingGroup at the front of this queue and removes it.
   * 
   * @throws java.util.NoSuchElementException - If this queue is empty. The exception should have a
   *                                          meaningful message.
   * @return The BoardingGroup that was removed from this queue.
   */
  public BoardingGroup dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty. Front does not exist.");
    }
    BGNode current = front;
    front = current.getNext();
    this.numOfGroups--;
    this.numOfPeople -= current.getGroup().getNumPeople();
    return current.getGroup();
  }

  @Override
  /**
   * Returns a string representation of this queue.
   * 
   * @return This queue represented as a string.
   */
  public String toString() {
    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName = current.getGroup().getName();
      s += groupName + " ";
      current = current.getNext();
    }
    return s;
  }


}
