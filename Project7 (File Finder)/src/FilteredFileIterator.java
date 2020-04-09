//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: FilteredFileIterator
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
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Iterates through a provided directory and searchPattern and lists all files within the directory
 * and sub directories that contain searchPattern in the file's name.
 * 
 * @author Andy Lin
 *
 */
public class FilteredFileIterator implements java.util.Iterator<File> {
  private DeepFileIterator fileIterator = null; //a DeepFileIterator that steps through all files
  //within the initial directory (and all contained sub directories).
  private String searchPattern = ""; //a String that must be part of a files name in order for
  // that file to be returned from this iterators next method.
  private File nextMatchingFile; //a File reference to the next file that this iterator will
  //return (or null, if there are no more files containing this string in their file name left to
  //be returned).

  /**
   * A helper method that returns a file if the file's name contains searchPattern, otherwise null.
   * 
   * @return A file that contains searchPattern in the file's name, otherwise null.
   */
  private File findRightFile() {
    while (fileIterator.hasNext()) {
      File nextFile = fileIterator.next();
      if (nextFile.getName().contains(searchPattern)) {
        return nextFile;
      }
    }
    return null;
  }

  /**
   * A constructor that initializes fileIterator to a reference of DeepFileIterator given input
   * file, searchPattern to parameter searchPattern, and nextMatchinfFile to the result of
   * findRightFile().
   * 
   * @param directory     - the specified directory in the system.
   * @param searchPattern - the string to look for in a file's name.
   * @throws FileNotFoundException - If the file does not exist within the system, it throws a
   *                               FileNotFoundException
   */
  public FilteredFileIterator(File directory, String searchPattern) throws FileNotFoundException {
    if (!directory.exists()) {
      throw new java.io.FileNotFoundException("File does not exist in directory.");
    }
    this.fileIterator = new DeepFileIterator(directory);
    this.searchPattern = searchPattern;
    this.nextMatchingFile = findRightFile();

  }

  @Override
  /**
   * Checks whether or not there should be a next file within the directory or sub directory.
   * 
   * @return true if nextMatchingFile does not equal null, otherwise false.
   */
  public boolean hasNext() {
    if (nextMatchingFile == null) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  /**
   * returns a reference to a different java.io.File that contains searhcPattern that is contained
   * within the provided directory or sub directory.
   * 
   * @return File - a reference to a file if the file's name contians searchPattern.
   * @throws NoSuchElementException - If the next file does not exist within the directory/sub
   *                                directory.
   */
  public File next() throws NoSuchElementException {
    File currentFile = this.nextMatchingFile;
    if (hasNext()) {
      this.nextMatchingFile = findRightFile();
      return currentFile;
    } else {
      throw new NoSuchElementException("The next elment does not exist.");
    }
  }

}
