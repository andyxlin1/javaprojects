//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter
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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides supporting methods to allow user to : Print the months given the year, the month where
 * you want to calendar to start, and how many months you want to print after the starting month.
 * 
 * @author Andy Lin and Joseph Finklang
 *
 */
public class CalendarPrinter {
  /**
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * example, the year 2034 has the century index of 20 (as do the other years 2000-2099).
   * 
   * @param year to compute the century offset for
   * @return number of centuries between year 0 and the specified year
   */
  public static int fullCenturiesContained(Year year) {
    int returnYear = year.intValue() / 100;
    return returnYear;
  }

  /**
   * Calculates the number of years between the specified year and the first year of its century.
   * For example, the year 2034 has the offset within its century of 34 (as do 1234 and 9999934).
   * 
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
  public static int yearOffsetWithinCentury(Year year) {
    return year.intValue() % 100;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean isLeapYear(Year year) {

    if (year.intValue() % 4 != 0) {
      return false;
    }

    else if (year.intValue() % 100 != 0) {
      return true;
    }

    else if (year.intValue() % 400 != 0) {
      return false;
    }

    else {
      return true;
    }


  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified month is in a leap year. Note: that this is calculated based on the
   * month's monthOfYear and year, and is NOT retrieved from the month's getDayCount() method. This
   * is because this method is used to generate the day objects that are stored within each month.
   * 
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */
  public static int numberOfDaysInMonth(Month month) {
    Year year = month.getYear();
    if (month.getMonthOfYear().equals(MonthOfYear.January)
        || month.getMonthOfYear().equals(MonthOfYear.March)
        || month.getMonthOfYear().equals(MonthOfYear.May)
        || month.getMonthOfYear().equals(MonthOfYear.July)
        || month.getMonthOfYear().equals(MonthOfYear.August)
        || month.getMonthOfYear().equals(MonthOfYear.October)
        || month.getMonthOfYear().equals(MonthOfYear.December)) {
      return 31;
    }

    else if (month.getMonthOfYear().equals(MonthOfYear.February)) {
      if (isLeapYear(year)) {
        return 29;
      }

      else {
        return 28;
      }
    }

    else {
      return 30;
    }



  }

  /**
   * Calculates which day of the week the first day of the specified month falls on. Note: that this
   * is calculated based on the month's monthOfYear and year, and is NOT retrieved from the month's
   * getDayByDate(1) day. This is because this method is used to generate the day objects that are
   * stored within each month.
   * 
   * @param month within which we are calculate the day of week for the first day
   * @return DayOfWeek corresponding to the first day within the specified month
   */
  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
    double numMonth = month.getMonthOfYear().ordinal() + 1;
    int year = month.getYear().intValue();

    if (numMonth < 3) {
      numMonth = numMonth + 12;
      year = year - 1;

    }

    double yearOfCentury = yearOffsetWithinCentury(new Year(year));
    double zeroBasedCentury = fullCenturiesContained(new Year(year));
    double part1 = (13 * (numMonth + 1)) / 5;
    int part2 = (int) ((5 * yearOfCentury) / 4);
    int part3 = (int) ((21 * zeroBasedCentury) / 4);
    int dayOfWeek = (1 + ((int) ((int) (part1) + (part2) + (part3)))) % 7;


    if (dayOfWeek < 2) {
      dayOfWeek = dayOfWeek + 5;
    }

    else {
      dayOfWeek = dayOfWeek - 2;
    }

    DayOfWeek[] allValues = DayOfWeek.values();
    return allValues[dayOfWeek];
  }

  /**
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
    int dayOfWeekBeforeNum = dayBefore.ordinal();
    DayOfWeek[] allValues = DayOfWeek.values();

    if (dayOfWeekBeforeNum != 6) {
      return allValues[dayOfWeekBeforeNum + 1];
    }

    else {
      return allValues[0];
    }

  }

  /**
   * Calculates the month of the year that follows the specified month. For example, July comes
   * after June, and January comes after December.
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefore
   */
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
    int monthBeforeNum = monthBefore.ordinal();
    MonthOfYear[] allValues = MonthOfYear.values();

    if (monthBeforeNum != 11) {
      return allValues[monthBeforeNum + 1];
    }

    else {
      return allValues[0];
    }
  }

  /**
   * Creates a new month object and fully initializes with its corresponding days.
   * 
   * @param monthOfYear which month of the year this new month represents
   * @param year        in which this month is a part
   * @return reference to the newly created month object
   */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
    Month returnMonth = new Month(monthOfYear, year);
    DayOfWeek DayOfWeek = calcFirstDayOfWeekInMonth(returnMonth);
    for (int i = 0; i < numberOfDaysInMonth(returnMonth); i++) {
      Day dayToAdd = new Day(DayOfWeek, i + 1, returnMonth);
      returnMonth.addDay(dayToAdd);
      DayOfWeek = dayOfWeekAfter(DayOfWeek);

    }
    return returnMonth;

  }

  /**
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * with the Month an year of the month. The next line should contain the three letter
   * abbreviations for the seven days of the week. And then the dates of each day of that month
   * should follow: one week per line, with periods in positions of days that are a part of the
   * month before or after. For example, January 2020 should be printed as follows:
   *
   * January 2020 
   * MON TUE WED THU FRI SAT SUN 
   *  .   .   1   2   3   4   5 
   *  6   7   8   9   10  11  12 
   *  13  14  15  16  17  18  19 
   *  20  21  22  23  24  25  26 
   *  27  28  29  30  31  .   .
   *
   * @param month which is to be printed by this method
   */
  public static void printMonth(Month month) {
    DayOfWeek[] allValues = DayOfWeek.values();
    System.out.println(month.getMonthOfYear() + " " + month.getYear().intValue());
    System.out.println("MON TUE WED THU FRI SAT SUN");
    int k = 0;
    DayOfWeek dayOfWeek = calcFirstDayOfWeekInMonth(month);
    System.out.print(" ");
    while (!(calcFirstDayOfWeekInMonth(month).equals(allValues[k]))) {
      System.out.print(".   ");
      k++;
    }
    for (int i = 0; i < numberOfDaysInMonth(month); i++) {
      if (i < 9) {
        System.out.print((i + 1) + "   ");
      } else {
        System.out.print((i + 1) + "  ");
      }
      if (dayOfWeek == DayOfWeek.Sunday) {
        System.out.println();
      }
      dayOfWeek = dayOfWeekAfter(dayOfWeek);
      if (dayOfWeek.equals(DayOfWeek.Monday)) {
        System.out.print(" ");
      }
    }
    while (dayOfWeek != DayOfWeek.Monday) {
      System.out.print(".   ");
      dayOfWeek = dayOfWeekAfter(dayOfWeek);
    }
    System.out.println();
  }

  /**
   * Creates an array list of months that are initialized with their full complement of days. Prints
   * out each of these months in calendar form, and then returns the resulting ArrayList.
   * 
   * @param month of the year for the first month that is created and printed
   * @param year  that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   * @return the array list of months that this method generates and prints.
   */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {
    Year realYear = year;
    ArrayList<Month> returnMonths = new ArrayList<Month>();
    MonthOfYear[] allMonths = MonthOfYear.values();
    Month currentMonth;
    int tracking = 0;
    for (int j = 0; j < allMonths.length; j++) {
      if (month.equals(allMonths[j])) {
        break;
      } else {
        tracking += 1;
      }
    }
    
    for (int i = 0; i < count; i++) {
      currentMonth = (createNewMonth(allMonths[tracking], realYear));
      tracking++;
      returnMonths.add(currentMonth);
      printMonth(currentMonth);
      if (tracking == 12) {
        tracking = 0;
        realYear = new Year(realYear.intValue() + 1);
      }
    }
    return (returnMonths);
  }

  /**
   * Driver for the CalendarPrinter Application. This program asks the user to enter an initial
   * month, an initial year, and the total number of months to create and display in calendar form.
   * 
   * @param args is not used by this program
   */
  public static void main(String[] args) {
    // print welcome message
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    // read input from the user
    System.out.print("Enter the month to begin calendar: ");
    String monthString = in.nextLine().trim();
    System.out.print("Enter the year to begin calendar: ");
    String yearString = in.nextLine().trim();
    System.out.print("Enter the number of months to include in this calendar: ");
    String countString = in.nextLine().trim();
    // convert user input into usable form
    monthString = monthString.substring(0, 3).toUpperCase();
    MonthOfYear month = null;
    for (int i = 0; i < MonthOfYear.values().length; i++)

      if (monthString.equals(MonthOfYear.values()[i].name().substring(0, 3).toUpperCase()))
        month = MonthOfYear.values()[i];
    Year year = new Year(Integer.parseInt(yearString.trim()));
    int count = Integer.parseInt(countString.trim());
    // create months and display them in calendar form
    System.out.println();
    createAndPrintMonths(month, year, count);
    // display thank you message
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("Thanks, and have a nice day.");
    in.close();
  }



}
