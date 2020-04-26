//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: PatientRecordTreeTester
// Files: PatientRecord.java, PatientRecordNode.java, PatientRecordTree.Java,
//        PatientRecordTreeTester.java
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
// Online Sources: geeksforgeeks.org (Provided algorithm for some methods).
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 *@author Andy Lin
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
   * another patientRecord which is older that the one at the root, (4) Try adding a third patient
   * Record which is younger than the one at the root, (5) Try adding at least two further patient
   * records such that one must be added at the left subtree, and the other at the right subtree.
   * For all the above scenarios, and more, double check each time that size() method returns the
   * expected value, the add method call returns true, and that the .toString() method returns the
   * expected string representation of the contents of the binary search tree in an ascendant order
   * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
   * used as a key for a patient record already stored in the tree. Make sure that the
   * addPatientRecord() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {
    // (1)
    PatientRecordTree bst = new PatientRecordTree();
    if (bst.size() != 0)
      return false;
    if (!bst.isEmpty())
      return false;
    if (!(bst.toString().equals("")))
      return false;

    // (2)
    if (!bst.addPatientRecord(new PatientRecord("Norah", "11/23/1985")))
      return false;
    if (bst.size() != 1)
      return false;
    if (bst.isEmpty())
      return false;
    if (!bst.toString().equals("Norah(11/23/1985)"))
      return false;

    // (3)
    if (!bst.addPatientRecord(new PatientRecord("George", "5/27/1943")))
      return false;
    if (bst.size() != 2)
      return false;
    if (!bst.toString().equals("George(5/27/1943)" + "\n" + "Norah(11/23/1985)"))
      return false;

    // (4)
    if (!bst.addPatientRecord(new PatientRecord("William", "6/4/1998")))
      return false;
    if (bst.size() != 3)
      return false;
    if (!bst.toString().equals("George(5/27/1943)" + "\n" + "Norah(11/23/1985)\nWilliam(6/4/1998)"))
      return false;

    // (5)
    if (!bst.addPatientRecord(new PatientRecord("Adam", "8/12/1972")))
      return false;
    if (bst.size() != 4)
      return false;
    if (!bst.toString()
        .equals("George(5/27/1943)\nAdam(8/12/1972)\nNorah(11/23/1985)\nWilliam(6/4/1998)"))
      return false;

    // (5)
    if (!bst.addPatientRecord(new PatientRecord("Andrew", "4/20/2019")))
      return false;
    if (bst.size() != 5)
      return false;
    if (!bst.toString()
        .equals("George(5/27/1943)\nAdam(8/12/1972)\nNorah(11/23/1985)\nWilliam(6/4/1998)"
            + "\nAndrew(4/20/2019)"))
      return false;

    // (6)
    if (bst.addPatientRecord(new PatientRecord("Andrew", "4/20/2019")))
      return false;
    if (bst.size() != 5)
      return false;
    if (!bst.toString()
        .equals("George(5/27/1943)\nAdam(8/12/1972)\nNorah(11/23/1985)\nWilliam(6/4/1998)"
            + "\nAndrew(4/20/2019)"))
      return false;


    return true;
  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
   * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
   * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
   * try to call lookup() method to search for the patient record at the root of the tree, then a
   * patient records at the right and left subtrees at different levels. Make sure that the lookup()
   * method returns the expected output for every method call. (3) Consider calling .lookup() method
   * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
   * the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {
    // (1)
    PatientRecordTree bst = new PatientRecordTree();
    try {
      bst.lookup("11/23/2222");
      return false;
    } catch (NoSuchElementException NSEE) {
    }

    // (2)
    bst.addPatientRecord(new PatientRecord("Norah", "11/23/1985"));
    bst.addPatientRecord(new PatientRecord("George", "5/27/1943"));
    bst.addPatientRecord(new PatientRecord("Andrew", "4/20/2019"));
    bst.addPatientRecord(new PatientRecord("Tom", "1/2/1935"));
    bst.addPatientRecord(new PatientRecord("Sam", "9/12/2003"));
    if (bst.lookup("11/23/1985").compareTo(new PatientRecord("Norah", "11/23/1985")) != 0)
      return false;
    if (bst.lookup("5/27/1943").compareTo(new PatientRecord("George", "5/27/1943")) != 0)
      return false;
    if (bst.lookup("9/12/2003").compareTo(new PatientRecord("Sam", "9/12/2003")) != 0)
      return false;

    // (3)
    try {
      bst.lookup("11/23/2020");
      return false;
    } catch (NoSuchElementException NSEE) {
    }
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
   * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
   * the height of a PatientRecordTree with the following structure for instance, is 4. (*) / \ (*)
   * (*) \ / \ (*) (*) (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // (1)
    PatientRecordTree bst = new PatientRecordTree();
    if (bst.height() != 0)
      return false;

    // (2)
    bst.addPatientRecord(new PatientRecord("Norah", "11/23/1985"));
    if (bst.height() != 1)
      return false;

    // (3)
    bst.addPatientRecord(new PatientRecord("Daniel", "01/03/1975"));
    bst.addPatientRecord(new PatientRecord("Max", "03/09/1976"));
    bst.addPatientRecord(new PatientRecord("Stephany", "05/20/2000"));
    bst.addPatientRecord(new PatientRecord("Andy", "06/10/1999"));
    bst.addPatientRecord(new PatientRecord("Henry", "05/20/2004"));
    bst.addPatientRecord(new PatientRecord("Tiffany", "05/20/2006"));
    if (bst.height() != 4)
      return false;
    return true;

  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {
    // (1)
    PatientRecordTree bst = new PatientRecordTree();
    if (bst.getRecordOfYoungestPatient() != null)
      return false;

    // (2)
    bst.addPatientRecord(new PatientRecord("Norah", "11/23/1985"));
    if (bst.getRecordOfYoungestPatient().compareTo(new PatientRecord("Norah", "11/23/1985")) != 0)
      return false;

    // (3)
    bst.addPatientRecord(new PatientRecord("Daniel", "01/03/1975"));
    bst.addPatientRecord(new PatientRecord("Max", "03/09/1976"));
    bst.addPatientRecord(new PatientRecord("Stephany", "05/20/2000"));
    bst.addPatientRecord(new PatientRecord("Andy", "06/10/1999"));
    bst.addPatientRecord(new PatientRecord("Henry", "05/20/2004"));
    bst.addPatientRecord(new PatientRecord("Tiffany", "05/20/2006"));
    if (bst.getRecordOfYoungestPatient().compareTo(new PatientRecord("Tiffany", "05/20/2006")) != 0)
      return false;
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {
    // (1)
    PatientRecordTree bst = new PatientRecordTree();
    if (bst.getRecordOfOldestPatient() != null)
      return false;

    // (2)
    bst.addPatientRecord(new PatientRecord("Norah", "11/23/1985"));
    if (bst.getRecordOfOldestPatient().compareTo(new PatientRecord("Norah", "11/23/1985")) != 0)
      return false;

    // (3)
    bst.addPatientRecord(new PatientRecord("Daniel", "01/03/1975"));
    bst.addPatientRecord(new PatientRecord("Max", "03/09/1976"));
    bst.addPatientRecord(new PatientRecord("Stephany", "05/20/2000"));
    bst.addPatientRecord(new PatientRecord("Andy", "06/10/1999"));
    bst.addPatientRecord(new PatientRecord("Henry", "05/20/2004"));
    bst.addPatientRecord(new PatientRecord("Tiffany", "05/20/2006"));
    if (bst.getRecordOfOldestPatient().compareTo(new PatientRecord("Daniel", "01/03/1975")) != 0)
      return false;
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testAddPatientRecordToStringSize());
    System.out.println(testAddPatientRecordAndLookup());
    System.out.println(testHeight());
    System.out.println(testGetRecordOfYoungestPatient());
    System.out.println(testGetRecordOfOldestPatient());
  }

}
