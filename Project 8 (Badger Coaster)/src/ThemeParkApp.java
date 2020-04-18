//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ThemeParkApp
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Driver for RideQueue. Reads commands from a text files and executes them accordingly.
 * 
 * @author Michelle Jensen
 */
public class ThemeParkApp {
  /**
   * Runs the driver for RideQueue by performing certain functions when given an input.
   * @param args - not used.
   * @throws IOException - throws IOException if none of the inputs matches the given commands.
   */
  public static void main(String[] args) throws IOException {
    List<String> fileLines = Files.readAllLines(Paths.get("sample.txt"));
    String command = "";
    String[] commandParts;

    // Default queue capacity and ride capacity. Can change values if desired.
    RideQueue coaster = new RideQueue(50);
    int trainCapacity = 24;

    // Process each line in the text file.
    for (int i = 0; i < fileLines.size(); i++) {
      commandParts = fileLines.get(i).split(" ");
      command = commandParts[0].toUpperCase();

      // ENTER Command
      if (command.equals("E")) {
        enter(coaster, commandParts);
      }

      // BREAKDOWN Command
      if (command.equals("B")) {
        breakdown(coaster);
      }

      // PREVIEW Command
      if (command.equals("P")) {
        preview(coaster);
      }

      // RIDE Command
      if (command.equals("R")) {
        ride(coaster, trainCapacity);
      }

      // STATUS Command
      if (command.equals("S")) {
        status(coaster);
      }
    }
  }


  /**
   * prints the number of people and groups and the names of the groups in the queue.
   * 
   * @param coaster - the given RideQueue to retrieve status from.
   */
  private static void status(RideQueue coaster) {
    System.out.println("Retrieving Status...");
    System.out.println(coaster.toString());
    System.out.println("------------------------------------");
  }

  /**
   * Adds a group to the queue and prints a message, unless the queue is filled.
   * 
   * @param coaster      - the given RideQueue to retrieve status from.
   * @param commandParts - A 1-D string array containing the inputs.
   */
  private static void enter(RideQueue coaster, String[] commandParts) {
    System.out.println("Entering into ride line...");
    String groupName = commandParts[1];
    int groupSize = Integer.parseInt(commandParts[2]);

    BoardingGroup newGroup;
    /*
     * newGroup = CALL YOUR BoardingGroup CONSTRUCTOR HERE. NOTE: var groupName is the name of the
     * group from the file and var groupsize is the number of people
     */
    newGroup = new BoardingGroup(groupName, groupSize);

    if (commandParts.length == 4) {
      if (commandParts[3].toUpperCase().equals("V")) {
        newGroup.setIsVIP();
      }
    }

    try {
      coaster.enqueue(newGroup);
      System.out.println(
          groupName + "'s group of " + groupSize + " has entered the line for Badger Coaster.");
    } catch (IllegalStateException e) {
      System.out.println("Cannot fit group of that size into queue.");
    }

    System.out.println("------------------------------------");
  }

  /**
   * Removes all groups from the queue.
   * 
   * @param coaster - the given RideQueue to retrieve status from.
   */
  private static void breakdown(RideQueue coaster) {
    System.out.println("Ride Breakdown...");
    System.out.println("The ride has broken down. All " + coaster.size()
        + " group(s) have been removed from the line.");
    coaster.clear();
    System.out.println("------------------------------------");
  }

  /**
   * Prints the group's name and amount of people in the front of the queue.
   * 
   * @param coaster - the given RideQueue to retrieve status from.
   */
  private static void preview(RideQueue coaster) {
    System.out.println("Previewing the front of the line...");

    try {
      BoardingGroup peeked = coaster.peek();
      int peekedSize;
      /* peekedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON peeked */
      peekedSize = peeked.getNumPeople();
      String peekedName;
      /* peekedName = CALL YOUR NAME ACCESSOR HERE ON peeked */
      peekedName = peeked.getName();
      System.out
          .println(peekedName + "'s group of " + peekedSize + " is at the front of the line.");
    } catch (NoSuchElementException e) {
      System.out.println("Cannot look at a group from an empty queue.");
    }

    System.out.println("------------------------------------");
  }

  /**
   * Prints each group's name and amount of people as they board the train while removing the group
   * from the queue.
   * 
   * @param coaster - the given RideQueue to retrieve status from.
   * @param trainCapacity - the maximum amount of people the train can hold.
   */
  private static void ride(RideQueue coaster, int trainCapacity) {
    System.out.println("Boarding and Running the Ride...");
    int ridingTrain = 0;

    while (!coaster.isEmpty()) {
      BoardingGroup peeked = coaster.peek();
      int peekedSize;
      /* peekedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON peeked */
      peekedSize = peeked.getNumPeople();

      if (ridingTrain + peekedSize > trainCapacity) {
        break;
      }

      try {
        BoardingGroup removed = coaster.dequeue();
        String removedName;
        /* removedName = CALL YOUR NAME ACCESSOR HERE ON removed */
        removedName = removed.getName();
        int removedSize;
        /* removedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON removed */
        removedSize = removed.getNumPeople();

        System.out.println(
            removedName + "'s group of " + removedSize + " has boarded the Badger Coaster train.");

        ridingTrain += removedSize;
      } catch (NoSuchElementException e) {
        System.out.println("Cannot remove a group from an empty queue.");
      }
    }

    if (ridingTrain == 0) {
      System.out.println("There is no one on the train to ride.");
    } else {
      System.out.println("Train of " + ridingTrain + " people has left the ride station.");
    }

    System.out.println("------------------------------------");
  }
}

