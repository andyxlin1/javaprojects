//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: AlphabetListTester
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
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    LinkedCart linkedCart = new LinkedCart(new Cart("F"));
    linkedCart.setNext(new LinkedCart(new Cart("G")));
    if (!(linkedCart.getNext().getCart().getCargo().equals("G")))
      return false;
    linkedCart.setPrevious(new LinkedCart(new Cart("A")));
    if (!(linkedCart.getPrevious().getCart().getCargo().equals("A")))
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
    AlphabetList letters1 = new AlphabetList();
    AlphabetList letters2 = new AlphabetList(20);
    if (letters1.capacity() != 26)
      return false;
    if (letters2.capacity() != 20)
      return false;
    if (!(letters1.isEmpty()))
      return false;
    if (!(letters2.isEmpty()))
      return false;
    return true;


  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    try {
      AlphabetList badInput = new AlphabetList(-20);
      System.out.println("Should've thrown an IllegalArgumentException.");
      return false;
    } catch (IllegalArgumentException IAE) {
      if (!(IAE.getMessage().contains("non-zero"))) {
        System.out.print("IllegalArgumentException does not contain the correct error message.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(
          "Should've thrown an IllegalArgumentException but instead another exception was thrown.");
      return false;
    }
    return true;

  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
    AlphabetList letters = new AlphabetList();
    // (1)
    letters.add(new Cart("A"));
    try {
      letters.add(null);
      System.out.println("Should've thrown a NullPointerException.");
      return false;
    } catch (NullPointerException NPE) {
    } catch (Exception e) {
      System.out.println(
          "Should've thrown a NullPointerExceptionbut instead another exception was thrown.");
      return false;
    }

    // (2)
    try {
      letters.add(new Cart("Hello"));
      System.out.println("Should've thrown an IllegalArgumentException.");
      return false;
    } catch (IllegalArgumentException IAE) {
      if (!(IAE.getMessage().contains("upper-case"))) {
        System.out.print("IllegalArgumentException does not contain the correct error message.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(
          "Should've thrown an IllegalArgumentException but instead another exception was thrown.");
      return false;
    }

    // (3)
    try {
      letters.add(new Cart("A"));
      System.out.println("Should've thrown an IllegalArgumentException.");
      return false;
    } catch (IllegalArgumentException IAE) {
      if (!(IAE.getMessage().contains("duplicate"))) {
        System.out.print("IllegalArgumentException does not contain the correct error message.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(
          "Should've thrown an IllegalArgumentException but instead another exception was thrown.");
      return false;
    }
    return true;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
    AlphabetList letters = new AlphabetList();
    // (1)
    letters.add(new Cart("C"));

    if (letters.get(0).getCargo() != "C") {
      System.out.println("The first element should be C.");
      return false;
    }

    if (letters.size() != 1) {
      System.out.println("The size should be one after one cart was added.");
      return false;
    }

    if (letters.indexOf(new Cart("C")) != 0) {
      System.out.println("The index of C should be 0.");
      return false;
    }
    if (!(letters.readForward().equals("C")))
      return false;
    if (!(letters.readBackward().equals("C")))
      return false;

    // (2)
    letters.add(new Cart("A"));

    if (letters.get(0).getCargo() != "A") {
      System.out.println("The first element should be A.");
      return false;
    }

    if (letters.size() != 2) {
      System.out.println("The size should be two after one cart was added.");
      return false;
    }

    if (letters.indexOf(new Cart("A")) != 0) {
      System.out.println("The index of A should be 0.");
      return false;
    }

    if (!(letters.readForward().equals("AC")))
      return false;
    if (!(letters.readBackward().equals("CA")))
      return false;

    // (3)
    letters.add(new Cart("F"));

    if (letters.get(2).getCargo() != "F") {
      System.out.println("The last element should be F.");
      return false;
    }

    if (letters.size() != 3) {
      System.out.println("The size should be three after one cart was added.");
      return false;
    }

    if (letters.indexOf(new Cart("F")) != 2) {
      System.out.println("The index of F should be 2.");
      return false;
    }
    if (!(letters.readForward().equals("ACF")))
      return false;
    if (!(letters.readBackward().equals("FCA")))
      return false;

    // (4)
    letters.add(new Cart("B"));

    if (letters.get(1).getCargo() != "B") {
      System.out.println("The second element should be B.");
      return false;
    }

    if (letters.size() != 4) {
      System.out.println("The size should be four after one cart was added.");
      return false;
    }

    if (letters.indexOf(new Cart("B")) != 1) {
      System.out.println("The index of B should be 1.");
      return false;
    }

    if (!(letters.readForward().equals("ABCF")))
      return false;
    if (!(letters.readBackward().equals("FCBA")))
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. For each of those scenarios, make sure that the
   * size of the list is appropriately updated after a call without errors of the add() method, and
   * that the contents of the list is as expected whatever if list is read in the forward or
   * backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
    AlphabetList letters = new AlphabetList();
    // (1)
    try {
      letters.remove(3);
      System.out.println("Should've thrown an IndexOutOfBoundsException.");
      return false;
    } catch (IndexOutOfBoundsException IOBE) {
      if (!(IOBE.getMessage().contains("index"))) {
        System.out.print("IndexOutOfBoundsException does not contain the correct error message.");
        return false;
      }
    } catch (Exception e) {
      System.out.println("Should've thrown an IndexOutOfBoundsException but instead another "
          + "exception was thrown.");
      return false;
    }
    if (letters.size() != 0)
      return false;
    if (letters.readForward() != "")
      return false;
    if (letters.readBackward() != "")
      return false;

    // (2)
    letters.add(new Cart("F"));
    letters.remove(0);

    if (!letters.isEmpty()) {
      System.out.println("Size should be zero hence empty list.");
      return false;
    }
    if (!(letters.readBackward().equals("")))
      return false;
    if (!(letters.readForward().equals("")))
      return false;

    // (3)
    AlphabetList letters2 = new AlphabetList();
    letters2.add(new Cart("B"));
    letters2.add(new Cart("D"));
    letters2.remove(0);
    if (letters2.size() != 1) {
      System.out.println("Size should be  one after removing one cart from letters2.");
      return false;
    }
    if (!(letters2.readBackward().equals("D")))
      return false;
    if (!(letters2.readForward().equals("D")))
      return false;

    // (4)
    AlphabetList letters3 = new AlphabetList();
    letters3.add(new Cart("A"));
    letters3.add(new Cart("B"));
    letters3.add(new Cart("C"));
    letters3.remove(1);
    if (letters3.size() != 2)
      return false;
    if (!(letters3.readBackward().equals("CA")))
      return false;
    if (!(letters3.readForward().equals("AC")))
      return false;

    // (5)
    AlphabetList letters4 = new AlphabetList();
    letters4.add(new Cart("A"));
    letters4.add(new Cart("B"));
    letters3.remove(letters3.size() - 1);
    if (letters3.size() != 1)
      return false;
    if (!(letters3.readBackward().equals("A")))
      return false;
    if (!(letters3.readForward().equals("A")))
      return false;
    return true;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (testLinkedCart() && testAlphabetListConstructorIsEmpty()
        && testAlphabetListConstructorBadInput() && testAlphabetListAddBadInput()
        && testAlphabetListAdd() && testAlphabetListRemove())
      return true;
    return false;
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
