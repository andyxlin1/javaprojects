//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: AlphabetList
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
 * This class models a sorted doubly linked list of carts. Each cart carries one upper case alphabet
 * letter. Duplicate letters are not allowed in this list.
 * 
 * @author Andy Lin
 *
 */
public class AlphabetList implements SortedListADT<Cart> {
  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that
  // can be added to this sorted list
  private static final Cart MAX_CART = new Cart("Z"); // The largest cart that
  // can be added to this sorted list
  private LinkedCart head; // head of this doubly linked list
  private LinkedCart tail; // tail of this doubly linked list
  private int size; // size of this list
  private int capacity; // maximum number of carts which can be stored in this list

  /**
   * Creates an empty doubly linked list of carts with a given capacity
   * 
   * @param capacity - maximum number of carts to be connected in this list of carts
   * @throws java.lang.IllegalArgumentException - with the following error message "The capacity of
   *                                            this list must be a non-zero a positive integer." if
   *                                            capacity is zero or negative
   */
  public AlphabetList(int capacity) throws java.lang.IllegalArgumentException {
    if (capacity <= 0) {
      throw new java.lang.IllegalArgumentException(
          "The capacity of this list must be a non-zero a positive integer.");
    }
    this.capacity = capacity;
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Creates an empty doubly linked list of carts with a capacity equals to 26
   */
  public AlphabetList() {
    this.capacity = 26;
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Returns the capacity of this list in terms of maximum number of carts which can be stored in
   * it.
   * 
   * @return the capacity of this list.
   */
  public int capacity() {
    return this.capacity;
  }


  @Override
  /**
   * checks whether the list is empty.
   * 
   * @return true if the list is empty, otherwise false
   */
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  /**
   * Adds a new cart to this sorted list.
   * 
   * @param newCart - to add to this list
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if newCart does
   *                                            not carry one upper-case letter in the range "A" ..
   *                                            "Z" or if this list contains already a cart carrying
   *                                            the same letter. The descriptive error messages for
   *                                            these two cases can be respectively "Can only add
   *                                            carts carrying one upper-case alphabetic letter in
   *                                            the range A .. Z.", and "Cannot duplicate letters or
   *                                            carts in this list."
   * @throwsjava.lang.IllegalStateException - with the following error message "This list is full.
   *                                        Cannot add another cart." if this list reached its
   *                                        capacity
   */
  public void add(Cart newCart)
      throws java.lang.IllegalArgumentException, java.lang.IllegalStateException {
    LinkedCart currLinkedCart = this.head; // initializes the current Linked Cart we are traversing.

    // checks whether there is a valid uppercase letter.
    if (newCart.getCargo().length() != 1 || newCart.compareTo(MIN_CART) < 0
        || newCart.compareTo(MAX_CART) > 0) {
      throw new java.lang.IllegalArgumentException(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    }

    // makes sure the list isn't full.
    if (size == capacity) {
      throw new java.lang.IllegalStateException("This list is full. Cannot add another cart.");
    }
    // if the list is empty, it initializes the head and tail to a new LinkedCart instance of
    // newCart.
    if (this.isEmpty()) {
      LinkedCart initial = new LinkedCart(newCart);
      this.head = initial;
      this.tail = initial;
    }

    for (int i = 0; i < size; i++) {

      // checks whether or not you're adding a duplicate letter.
      if (newCart.getCargo().compareTo(currLinkedCart.getCart().getCargo()) == 0) {
        throw new java.lang.IllegalArgumentException(
            "Cannot duplicate letters or carts in this list.");
      }

      // checks if the cargo of newCart is smaller than currLinkedCart's cargo.
      else if ((newCart.getCargo().compareTo(currLinkedCart.getCart().getCargo()) < 0)) {

        // if the cargo of newCart is smaller than currLinkedCart's cargo on the first traversal,
        // then
        // initialize cartToAdd as a new LinkedCart instance of newCart with a null previous
        // reference and this.head next reference.
        // Afterwards, set the head's previous cart to cartToAdd and then sets the head to
        // cartToAdd.
        if (i == 0) {
          LinkedCart cartToAdd = new LinkedCart(newCart, null, this.head);
          this.head.setPrevious(cartToAdd);
          this.head = cartToAdd;
          break;
        }

        // if the cargo of newCart is smaller than currLinkedCart's cargo on the last traversal,
        // then
        // initialize newNode as a new instance of LinkedCart of newCNode with previous reference
        // of the tail's previous reference and a next reference of the tail. Afterwards, set the
        // next reference of currLinkedCart's previous cart to newNode. Then, set the previous cart
        // of currLinkedCart to newNode.
        else if (i == (size - 1)) {
          LinkedCart newNode = new LinkedCart(newCart, this.tail.getPrevious(), this.tail);
          currLinkedCart.getPrevious().setNext(newNode);
          currLinkedCart.setPrevious(newNode);
        }

        // otherwise, create an instance of LinkedCart called newNode with a cart of newCart,
        // previous reference of currLinkedCart's previous cart, and a next reference of
        // currLinkedCart. Afterwards, set the previous cart's next reference to newNode. Finally,
        // set currLinkedCart's previous cart to newNode.
        else {
          LinkedCart newNode =
              new LinkedCart(newCart, currLinkedCart.getPrevious(), currLinkedCart);
          currLinkedCart.getPrevious().setNext(newNode);
          currLinkedCart.setPrevious(newNode);
          break;
        }

      }

      // if the cargo of newCargo is not smaller than currLinkedCart's cargo and it's the last
      // traversal,
      // create a new instance named newNode of LinkedCart with cart newCart, a previous reference
      // of the tail,
      // and a null next reference. Set the tail's next cart next reference to the newNode, and set
      // the tail to newNode.
      else if (i == (size - 1)) {
        LinkedCart newNode = new LinkedCart(newCart, tail, null);
        this.tail.setNext(newNode);
        this.tail = newNode;

      }
      currLinkedCart = currLinkedCart.getNext(); // updates currLinkedCart to the next LinkedCart.

    }
    this.size = this.size + 1; // increments the size by 1.

  }



  @Override
  /**
   * returns the size of this list.
   * 
   * @return the number of carts linked in the list.
   */
  public int size() {
    return this.size;
  }

  @Override
  /**
   * Removes all the carts from this list. This list must be empty after this method returns.
   */
  public void clear() {
    LinkedCart currLinkedCart = this.head;
    LinkedCart nextLinkedCart;

    // goes through the list and sets currLinkedCart's next and previous car to null. Afterwards,
    // set the currLinkedCart to the nextLinkedCart.
    while (currLinkedCart != null) {
      nextLinkedCart = currLinkedCart.getNext();
      currLinkedCart.setNext(null);
      currLinkedCart.setPrevious(null);
      currLinkedCart = nextLinkedCart;
    }
    this.head = null;
    this.tail = null;
    size = 0;

  }

  @Override
  /**
   * Returns the cart at position index of this list without removing it
   * 
   * @param index - of the cart to return
   * @throws java.lang.IndexOutOfBoundsException - with the following error message "Invalid index."
   *                                             if index is less than 0 or index is greater or
   *                                             equal to size()
   * 
   * @returns the cart of this sorted list at the given index
   * 
   */
  public Cart get(int index) throws java.lang.IndexOutOfBoundsException {
    Cart cartToReturn = null;
    LinkedCart currLinkedCart = this.head;
    // checks if index is valid.
    if (index >= this.size || index < 0) {
      throw new java.lang.IndexOutOfBoundsException("Invalid index.");
    }

    // traverses through list until i is equal to index. Afterwards, return the currLinkedCart's
    // cart.
    for (int i = 0; i < size; i++) {
      if (i == index) {
        cartToReturn = currLinkedCart.getCart();
        break;
      }
      currLinkedCart = currLinkedCart.getNext();
    }
    return cartToReturn;

  }

  @Override
  /**
   * Returns the index of the cart carrying data within this list
   * 
   * @param findCart - cart to find in this list
   * @return the index of findCart within this list or -1 if this list does not contain that cart.
   */
  public int indexOf(Cart findCart) {
    LinkedCart currLinkedCart = this.head;
    // traverses the list until the cargo of currLinkedCart and findCart's cargo is equal to 0.
    // Afterwards, return i. If the cargos never equal, return -1.
    for (int i = 0; i < size; i++) {
      if (currLinkedCart.getCart().getCargo().compareTo(findCart.getCargo()) == 0) {
        return i;
      }
      currLinkedCart = currLinkedCart.getNext();
    }
    return -1;
  }

  @Override
  /**
   * Returns and removes the cart from this sorted list at the given index position
   * 
   * @param index - of the cart to be removed
   * @throws java.lang.IndexOutOfBoundsException - with the following error message "Invalid index."
   *                                             if index is less than 0 or index is larger or equal
   *                                             to size()
   * @return the removed cart
   */
  public Cart remove(int index) throws java.lang.IndexOutOfBoundsException {
    Cart returnCart = get(index);
    // checks whether the index is valid.
    if (index < 0 || index >= size) {
      throw new java.lang.IndexOutOfBoundsException("Invalid index.");
    }
    LinkedCart currLinkedCart = this.head;

    // traverses list until i equals index, otherwise keep updating currLinkedCart to the next Cart.
    for (int i = 0; i < size; i++) {
      if (i == index) {

        // if removing the head, set the head to currLinkedCart's next cart.
        if (i == 0) {
          this.head = currLinkedCart.getNext();
        }

        // sets the previous reference of currLinkedCart's next cart to the previous cart of
        // currLinkedCart only if currLinkedCart is not a tail node.
        if (currLinkedCart.getNext() != null) {
          currLinkedCart.getNext().setPrevious(currLinkedCart.getPrevious());
        }

        // sets the next reference of currLinkedCart's previous cart to currLinkedCart's next cart
        // if currLinkedCart is not a head node.
        if (currLinkedCart.getPrevious() != null) {
          currLinkedCart.getPrevious().setNext(currLinkedCart.getNext());
        }
        break;
      }
      currLinkedCart = currLinkedCart.getNext();
    }
    size = size - 1;
    return returnCart;
  }

  /**
   * Returns a String representation of this list. Note that the implementation details of this
   * method is provided in the assignment's specification.
   * 
   * @return a String representation of this list.
   */
  public String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;
  }

  /**
   * Reads the contents of this list in the forward direction starting from its head.
   * 
   * @return a String representation of the contents of this list read in the forward direction or
   *         an empty string if this list is empty. For instance, if the list contains the following
   *         letters "A", "B", "D", "M", and "O". This method MUST return the following string
   *         "ABDMO".
   */
  public String readForward() {
    LinkedCart currLinkedCart = this.head;
    String returnString = "";
    // traverses list and concatenates returnString to currLinkedCart's cargo.
    for (int i = 0; i < size; i++) {
      returnString = returnString + currLinkedCart.getCart().getCargo();
      currLinkedCart = currLinkedCart.getNext();
    }
    return returnString;
  }

  /**
   * Reads the contents of this list in the backward direction starting from its tail
   * 
   * @returna String representation of the contents of this list read in the backward direction or
   *          an empty string if this list is empty. For instance, if the list contains the
   *          following letters "A", "B", "D", "M", and "O". This method MUST return the following
   *          string "OMDBA".
   */
  public String readBackward() {
    LinkedCart currLinkedCart = this.head;
    String returnString = "";
    // traverses list and concatenates currLinkedCart's cargo to returnString.
    for (int i = size; i > 0; i--) {
      returnString = currLinkedCart.getCart().getCargo() + returnString;
      currLinkedCart = currLinkedCart.getNext();
    }
    return returnString;
  }
}
