//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter Tester
// Files: CalendarPrinter.java, CalendarTester.Java, and P02.jar
// Course: CS 300, Term 1, 2020
//
// Author: Andy Lin
// Email: alin47@wisc.edu
// Lecturer's Name: Hobbes LeGault
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Joseph Finklang
// Partner Email: finklang@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understood the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
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
 * Tests the methods in Calendar Printer to make sure they produce the correct output
 * 
 * @author Andy Lin and Joseph Finklang
 *
 */
public class CalendarTester {
  /**
   * Tests fullCenturiesContained method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testFullCenturiesContained() {
    if (CalendarPrinter.fullCenturiesContained(new Year(2)) != 0)
      return false;
    if (CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20)
      return false;
    if (CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444)
      return false;
    return true;
  }

  /**
   * Tests yearOffsetWithinCentury method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testYearOffsetWithinCentury() {
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2034)) != 34)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2020)) != 20)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(1990)) != 90)
      return false;
    return true;
  }

  /**
   * Tests isLeapYear method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testIsLeapYear() {
    if (CalendarPrinter.isLeapYear(new Year(2000)) != true)
      return false;
    if (CalendarPrinter.isLeapYear(new Year(2048)) != true)
      return false;
    if (CalendarPrinter.isLeapYear(new Year(1900)) != false)
      return false;
    return true;
  }

  /**
   * Tests numberOfDaysInMonth method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testNumberOfDaysInMonth() {
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.January, new Year(2000))) != 31)
      return false;

    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2000))) != 29)
      return false;

    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2001))) != 28)
      return false;


    return true;
  }

  /**
   * Tests calcFirstDayOfWeekInMonth method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testCalcFirstDayOfWeekInMonth() {
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.January, new Year(2020))) != DayOfWeek.Wednesday)
      return false;


    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.February, new Year(2011))) != DayOfWeek.Tuesday)
      return false;


    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.March, new Year(2001))) != DayOfWeek.Thursday)
      return false;

    return true;
  }

  /**
   * Tests dayOfWeekAfter method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testDayOfWeekAfter() {
    if (!(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday).equals(DayOfWeek.Saturday)))
      return false;


    if (!(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday).equals(DayOfWeek.Monday)))
      return false;


    if (!(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Monday).equals(DayOfWeek.Tuesday)))
      return false;


    return true;
  }

  /**
   * Tests monthOfYearAfter method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testMonthOfYearAfter() {
    if (!(CalendarPrinter.monthOfYearAfter(MonthOfYear.December).equals(MonthOfYear.January)))
      return false;


    if (!(CalendarPrinter.monthOfYearAfter(MonthOfYear.January).equals(MonthOfYear.February)))
      return false;


    if (!(CalendarPrinter.monthOfYearAfter(MonthOfYear.November).equals(MonthOfYear.December)))
      return false;


    return true;
  }

  /**
   * Tests createNewMonth method to see whether or not it produces the correct output
   * 
   * @return true if it performs the correct function, otherwise false
   */
  public static boolean testCreateNewMonth() {
    Month test1 = CalendarPrinter.createNewMonth(MonthOfYear.January, new Year(2020));
    Month test2 = CalendarPrinter.createNewMonth(MonthOfYear.February, new Year(2020));
    Month test3 = CalendarPrinter.createNewMonth(MonthOfYear.March, new Year(1900));

    if (!(test1).getDayByDate(1).getDayOfWeek().equals(DayOfWeek.Wednesday))
      return false;
    if (!(test1).getDayByDate(31).getDayOfWeek().equals(DayOfWeek.Friday))
      return false;
    if (!(test1).getDayByDate(14).getDayOfWeek().equals(DayOfWeek.Tuesday))
      return false;

    if (!(test2).getDayByDate(1).getDayOfWeek().equals(DayOfWeek.Saturday))
      return false;
    if (!(test2).getDayByDate(29).getDayOfWeek().equals(DayOfWeek.Saturday))
      return false;
    if (!(test2).getDayByDate(14).getDayOfWeek().equals(DayOfWeek.Friday))
      return false;

    if (!(test3).getDayByDate(1).getDayOfWeek().equals(DayOfWeek.Thursday))
      return false;
    if (!(test3).getDayByDate(31).getDayOfWeek().equals(DayOfWeek.Saturday))
      return false;
    if (!(test3).getDayByDate(14).getDayOfWeek().equals(DayOfWeek.Wednesday))
      return false;



    return true;
  }



  public static void main(String[] args) {
    System.out.println(testFullCenturiesContained());
    System.out.println(testYearOffsetWithinCentury());
    System.out.println(testIsLeapYear());
    System.out.println(testNumberOfDaysInMonth());
    System.out.println(testCalcFirstDayOfWeekInMonth());
    System.out.println(testDayOfWeekAfter());
    System.out.println(testMonthOfYearAfter());
    System.out.println(testCreateNewMonth());


  }

}