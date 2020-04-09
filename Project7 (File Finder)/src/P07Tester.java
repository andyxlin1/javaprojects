//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07Tester
// Files: ShallowFileIterator.java, DeepFileiterator.java, FilteredFileIterator.java, P07Tester.java
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
 * Tests whether ShallowFileIterator.java, DeepFileIterator.java, and FilteredFileIterator.java
 * works correctly
 * 
 * @author Andy Lin
 *
 */
public class P07Tester {
  /**
   * Checks whether or not if ShallowFileIterator's next and hasNexxt method is working correctly by
   * comparing returnString (an accumulation of all return statements by next() while hasNext() is
   * true,) and expectedResults when given a specific directory.
   * 
   * @param directory - the specified directory.
   * @return true if returnString is equal to expectedResults, otherwise false if they don't equal
   *         and if a FileNotFoundException or NoSuchElementException is caught.
   */
  public static boolean testShallowFileIterator(java.io.File directory) {
    String returnString = "";
    String expectedResults =
        "assignments, exam preparation, lecture notes, " + "reading notes, todo.txt, ";
    try {
      ShallowFileIterator test = new ShallowFileIterator(directory);
      while (test.hasNext()) {
        returnString = returnString + test.next().getName() + ", ";
      }
      if (!(returnString.equals(expectedResults)))
        return false;
      return true;
    } catch (java.io.FileNotFoundException FNFE) {
      System.out.println(FNFE.getMessage());
      return false;
    } catch (java.util.NoSuchElementException NSEE) {
      System.out.println(NSEE.getMessage());
      return false;
    }
  }

  /**
   * Checks whether or not if DeepFileIterator's next and hasNexxt method is working correctly by
   * comparing returnString (an accumulation of all return statements by next() while hasNext() is
   * true,) and expectedResults when given a sub directory of assignments.
   * 
   * @param the specified directory.
   * @return true if returnString is equal to expectedResults, otherwise false if they don't equal
   *         and if a FileNotFoundException or NoSuchElementException is caught.
   */
  public static boolean testDeepFileIterator(java.io.File folder) {
    folder = new File(folder.getPath() + File.separator + "assignments");
    String returnString = "";
    String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
        + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
        + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";

    try {
      DeepFileIterator test = new DeepFileIterator(folder);
      while (test.hasNext()) {
        returnString = returnString + test.next().getName() + ", ";
      }

      if (!(returnString.equals(expectedResults)))
        return false;
      return true;
    } catch (java.io.FileNotFoundException FNFE) {
      System.out.println(FNFE.getMessage());
      return false;
    } catch (java.util.NoSuchElementException NSEE) {
      System.out.println(NSEE.getMessage());
      return false;
    }
  }

  /**
   * Checks whether or not if FilteredFileiterator's next and hasNexxt method is working correctly
   * by comparing returnString (an accumulation of all return statements by next() while hasNext()
   * is true,) and expectedResults when given a directory.
   * 
   * @param file the specified directory.
   * @return true if returnString is equal to expectedResults, otherwise false if they don't equal
   *         and if a FileNotFoundException or NoSuchElementException is caught.
   */
  public static boolean testFilteredFileIterator(java.io.File file) {
    String returnString = "";
    String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
        + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
        + "AlphabetTrain.java, codeSamples.java, ";

    try {
      FilteredFileIterator test = new FilteredFileIterator(file, ".java");
      while (test.hasNext()) {
        returnString = returnString + test.next().getName() + ", ";
      }

      if (!(returnString.equals(expectedResults)))
        return false;
      return true;
    } catch (java.io.FileNotFoundException FNFE) {
      System.out.println(FNFE.getMessage());
      return false;
    } catch (java.util.NoSuchElementException NSEE) {
      System.out.println(NSEE.getMessage());
      return false;
    }
  }

  /**
   * Prints out the return values of the test methods.
   * @param args - not used
   */
  public static void main(String[] args) {
    System.out.println(testShallowFileIterator(new File("filesystem")));
    System.out.println(testDeepFileIterator(new File("filesystem")));
    System.out.println(testFilteredFileIterator(new File("filesystem")));

  }

}
