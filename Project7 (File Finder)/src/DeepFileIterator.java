//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DeepFileIterator
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
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Iterates through a provided directory and lists all files within that directory and all sub
 * directories.
 * 
 * @author Andy Lin
 *
 */
public class DeepFileIterator implements java.util.Iterator<File> {
  private java.io.File[] folderContents; //a sorted array of File references which this iterator
  //steps through: containing references to all files in the specified directory

  private int nextIndex; //the int index specifying the next File within folderContents that this
  //iterators next() method will return
  private DeepFileIterator contentsIterator; //a DeepFileIterator reference that is used to step
  //through the contents within any directory that is contained within this folder

  /**
   * Constructor that initializes the folderContents as an array of the directorys files and sorts
   * it. Sets nextIndex to 0 and sets contentsIterator to null.
   * 
   * @param file - the specified directory
   * @throws FileNotFoundException - If the file does not exist within the system, it throws a
   *                               FileNotFoundException
   */
  public DeepFileIterator(File file) throws FileNotFoundException {
    if (!file.exists()) {
      throw new java.io.FileNotFoundException("File does not exist in directory.");
    }
    contentsIterator = null;
    folderContents = file.listFiles();
    Arrays.sort(folderContents);
    this.nextIndex = 0;
  }

  @Override
  /**
   * Checks whether or not there should be a next file within the directory or sub directory.
   * 
   * @return true if contentsIterator is null and the nextIndex is smaller than the length of
   *         folderContents or if contentsIterator does not equal null and
   *         contentsIterator.hasNext() is true, otherwise false.
   */
  public boolean hasNext() {
    if (contentsIterator != null && contentsIterator.hasNext()) {
      return true;
    } else {
      if (this.nextIndex < folderContents.length) {
        return true;
      } else {
        return false;
      }
    }
  }

  @Override
  /**
   * returns a reference to a different java.io.File that is contained within the provided directory
   * or sub directory.
   * 
   * @return - The file in the directory or sub directory.
   * @throws NoSuchElementException - If the next file does not exist within the directory/sub
   *                                directory.
   */
  public File next() throws NoSuchElementException {
    if (contentsIterator != null && contentsIterator.hasNext()) {
      if (hasNext()) {
        return contentsIterator.next();
      } else {
        throw new NoSuchElementException(
            "Reached the end of the Array. The next elment does not exist.");
      }
    } else {
      if (hasNext()) {
        if (folderContents[nextIndex].isDirectory()) {
          try {
            contentsIterator = new DeepFileIterator(folderContents[nextIndex]);
          } catch (FileNotFoundException FNFE) {
            contentsIterator = null;
          }
        }
        nextIndex++;
        return folderContents[nextIndex - 1];
      } else {
        throw new NoSuchElementException(
            "Reached the end of the Array. The next elment does not exist.");
      }
    }
  }
}
